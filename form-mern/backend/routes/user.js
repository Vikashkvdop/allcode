const express = require("express");
const router = express.Router();
const { createUser } = require("../controller/createUser");
const { getUser } = require("../controller/getUser");
router.post("/createUser", createUser);
router.get("/getallUser", getUser);

module.exports = router;
