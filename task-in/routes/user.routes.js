const router = require('express').Router();
const auth = require('../middleware/auth');
const ctrl = require('../controllers/user.controller');

router.post('/register', auth, ctrl.register);
router.post('/login', ctrl.login);
router.get('/:id', auth, ctrl.getUser);
router.put('/:id', auth, ctrl.updateUser);
router.put('/:id/roles', auth, ctrl.updateRoles);

module.exports = router;
