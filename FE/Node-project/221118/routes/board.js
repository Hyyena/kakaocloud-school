const express = require("express");

const router = express.Router();

router.get("/", (req, res) => {
  res.send("Hello Board");
});

router.get("/post", (req, res) => {
  res.send("Post");
});

module.exports = router;
