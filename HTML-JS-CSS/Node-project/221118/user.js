const express = require("express");

const router = express.Router();

router.get("/", (req, res) => {
  res.sendFile("Hello User");
});

module.exports = router;
