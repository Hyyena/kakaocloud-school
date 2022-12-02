const express = require("express");
const { User } = require("../models");

const USer = require("../models/user");
const { isLoggedIn } = require("./middlewares");

const router = express.Router();

router.post("/:id/follow", isLoggedIn, async (req, res, next) => {
  try {
    // 현재 로그인 한 유저를 찾는다.
    const user = await User.findOne({ where: { id: req.user.id } });

    if (user) {
      // 팔로우로 추가
      await user.addFollowing(parseInt(req.params.id, 10));
    } else {
      res.status(404).send("No user");
    }
  } catch (error) {
    console.log("🚀 ~ file: users.js:20 ~ router.post ~ error", error);
    next(error);
  }
});

module.exports = router;
