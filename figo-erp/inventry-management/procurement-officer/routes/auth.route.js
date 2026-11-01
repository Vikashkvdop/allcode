const router = require('express').Router();
const { signIn, signOut } = require('../controllers/auth.controller');

router.post('/signin', signIn);
router.post('/signout', signOut);

module.exports = router;
