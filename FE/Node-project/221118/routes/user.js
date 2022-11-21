const express = require("express");

const router = express.Router();

router.get("/", (req, res) => {
  res.send("Hello User");
});

router.get("/signup", (req, res) => {
  res.send("Sign Up");
});

module.exports = router;
