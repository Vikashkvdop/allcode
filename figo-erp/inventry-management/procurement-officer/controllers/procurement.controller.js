const s = require('../services/procurement.service');
const r = require('../utils/response');

exports.listOrders = async (_, res) => {
  try {
    r.success(res, 'Orders fetched', await s.orders());
  } catch (e) {
    r.error(res, 'Failed to fetch orders', e.message);
  }
};

exports.createPO = async (req, res) => {
  try {
    r.success(res, 'PO created', await s.createPO(req.body, req.user), 201);
  } catch (e) {
    r.error(res, 'Failed to create PO', e.message);
  }
};

exports.listItems = async (req, res) => {
  try {
    r.success(res, 'Items fetched', await s.items(req.query.status));
  } catch (e) {
    r.error(res, 'Failed to fetch items', e.message);
  }
};

exports.viewItem = async (req, res) => {
  try {
    r.success(res, 'Item details', await s.itemDetail(req.params.id));
  } catch (e) {
    r.error(res, 'Failed to fetch item', e.message);
  }
};

exports.addItemToPO = async (req, res) => {
  try {
    r.success(res, 'Item added to PO', await s.addItem(req.params.id, req.body));
  } catch (e) {
    r.error(res, 'Failed to add item', e.message);
  }
};


/*================================FOLLOW UPS Detail controllers======================== */


exports.followUpSummary = async (_, res) => {
  try {
    r.success(res, 'Follow-up summary fetched', await s.followUpSummary());
  } catch (e) {
    r.error(res, 'Failed to fetch summary', e.message);
  }
};

exports.followUpList = async (req, res) => {
  try {
    r.success(
      res,
      'Follow-up list fetched',
      await s.followUpList(req.params.type)
    );
  } catch (e) {
    r.error(res, 'Failed to fetch follow-up list', e.message);
  }
};

exports.viewPurchaseOrder = async (req, res) => {
  try {
    r.success(
      res,
      'Purchase order detail fetched',
      await s.viewPurchaseOrder(req.params.id)
    );
  } catch (e) {
    r.error(res, 'Failed to fetch PO detail', e.message);
  }
};

exports.editPurchaseOrder = async (req, res) => {
  try {
    r.success(
      res,
      'Purchase order updated',
      await s.editPurchaseOrder(req.params.id, req.body, req.user)
    );
  } catch (e) {
    r.error(res, e.message, null, 403);
  }
};