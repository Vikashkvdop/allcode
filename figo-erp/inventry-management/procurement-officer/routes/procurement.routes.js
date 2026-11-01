const router = require('express').Router();
const c = require('../controllers/procurement.controller');
// const auth = require('../middlewares/auth.middleware');
// const role = require('../middlewares/role.middleware');

// router.use(auth, role('PROCUREMENT','ADMIN'));

const {requireAuth}=require('../middlewares/auth.middleware');
router.use(requireAuth);

router.get('/orders', c.listOrders);
router.post('/orders', c.createPO);

router.get('/items', c.listItems);
router.get('/items/:id', c.viewItem);

router.post('/orders/:id/items', c.addItemToPO);



// ==========================Follow UPs==================


// FOLLOW-UPS
router.get('/followups/summary', c.followUpSummary);
router.get('/followups/:type', c.followUpList);

// PURCHASE ORDER DETAIL
router.get('/purchase-orders/:id', c.viewPurchaseOrder);

// EDIT PO (only Draft / Pending)
router.put('/purchase-orders/:id', c.editPurchaseOrder);

module.exports = router;
