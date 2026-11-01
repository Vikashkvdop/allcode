const {supabaseAdmin} = require('../config/supabase');

exports.orders = async () => {
  const { data, error } = await supabaseAdmin.from('purchase_orders').select('*');
  if (error) throw error;
  return data;
};

exports.createPO = async (body, ) => {
  const { data, error } = await supabaseAdmin.from('purchase_orders')
    .insert({
      ...body,
      
    })
    .select()
    .single();
  if (error) throw error;
  return data;
};

exports.items = async status => {
  let q = supabaseAdmin.from('inventry_items').select('*');
  if (status) q = q.eq('status', status);
  const { data, error } = await q;
  if (error) throw error;
  return data;
};

exports.itemDetail = async id => {
  const { data, error } = await supabaseAdmin
    .from('items')
    .select('*')
    .eq('id', id)
    .single();
  if (error) throw error;
  return data;
};

exports.addItem = async (poId, body) => {
  const total = body.quantity * body.unit_price;

  const { data, error } = await supabaseAdmin.from('purchase_order_items')
    .insert({
      po_id: poId,
      ...body,
      total
    })
    .select()
    .single();

  if (error) throw error;
  return data;
};




/* ================= SUMMARY ================= */

exports.followUpSummary = async () => {
  const today = new Date().toISOString().split('T')[0];

  const pending = await supabaseAdmin
    .from('purchase_orders')
    .select('id', { count: 'exact' })
    .in('delivery_status', ['Pending','Partially Delivered']);

  const overdue = await supabaseAdmin
    .from('purchase_orders')
    .select('id', { count: 'exact' })
    .lt('expected_delivery', today)
    .neq('delivery_status', 'Completed');

  const awaitingGrn = await supabaseAdmin
    .from('purchase_orders')
    .select('id', { count: 'exact' })
    .eq('delivery_status', 'Awaiting GRN');

  return {
    total_pending: pending.count,
    overdue: overdue.count,
    awaiting_grn: awaitingGrn.count
  };
};

/* ================= LIST BY STATUS ================= */

exports.followUpList = async type => {
  let query = supabaseAdmin.from('purchase_orders').select('*');

  switch (type) {
    case 'all':
      query = query.neq('delivery_status', 'Completed');
      break;
    case 'overdue':
      query = query.eq('delivery_status', 'Overdue');
      break;
    case 'partial':
      query = query.eq('delivery_status', 'Partially Delivered');
      break;
    case 'awaiting-grn':
      query = query.eq('delivery_status', 'Awaiting GRN');
      break;
    default:
      throw new Error('Invalid follow-up type');
  }

  const { data, error } = await query;
  if (error) throw error;
  return data;
};

/* ================= VIEW PO ================= */

exports.viewPurchaseOrder = async id => {
  const { data, error } = await supabaseAdmin
    .from('purchase_orders')
    .select(`
      *,
      purchase_order_items(*),
      purchase_order_attachments(*),
      purchase_order_activity(*)
    `)
    .eq('id', id)
    .single();

  if (error) throw error;
  return data;
};

/* ================= EDIT PO ================= */

exports.editPurchaseOrder = async (id, body, user) => {
  const { data: po } = await supabaseAdmin
    .from('purchase_orders')
    .select('status')
    .eq('id', id)
    .single();

  if (!['Draft','Pending'].includes(po.status)) {
    throw new Error('Only Draft or Pending POs can be edited');
  }

  const { data, error } = await supabaseAdmin
    .from('purchase_orders')
    .update(body)
    .eq('id', id)
    .select()
    .single();

  if (error) throw error;

  await supabaseAdmin.from('purchase_order_activity').insert({
    po_id: id,
    action: 'PO Updated',
    action_by: user.name
  });

  return data;
};
