const express = require("express");

const router = express.Router();

router.get("/", (req, res) => {
  res.sendFile("Hello Boarda");
});

module.exports = router;
