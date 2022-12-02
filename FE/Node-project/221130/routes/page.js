const express = require("express");
const { isLoggedIn, isNotLoggedIn } = require("./middlewares");

const { Post, User, Hashtag } = require("../models");

const router = express.Router();

// 공통된 처리 (무조건 수행)
router.use((req, res, next) => {
  // 로그인 한 유저 정보
  res.locals.user = req.user;

  // 게시글을 follow 한 개수
  res.locals.followCount = req.user ? req.user.Followers.length : 0;
  // 게시글을 following 하고 있는 개수
  res.locals.followingCount = req.user ? req.user.Followings.length : 0;

  // 게시글을 follow 하고 있는 유저 목록
  res.locals.followerIdList = req.user
    ? req.user.Followings.map((f) => f.id)
    : [];

  next();
});

router.get("/hashtag", async (req, res, next) => {
  const query = req.query.hashtag;

  if (!query) {
    return res.redirect("/");
  }

  try {
    const hashtag = await Hashtag.findOne({ where: { title: query } });
    let posts = [];

    if (hashtag) {
      posts = await hashtag.getPosts({ include: [{ model: User }] });
    }

    return res.render("main", {
      title: `${query} | Node Authentication`,
      twits: posts,
    });
  } catch (error) {
    console.error("🚀 ~ file: page.js:45 ~ router.get ~ error", error);
    return next(error);
  }
});

// 메인 화면
router.get("/", async (req, res, next) => {
  try {
    // Post 모듈의 모든 데이터를 찾아온다.
    // 이 때, User 정보의 id와 nick도 같이 가져오기
    const posts = await Post.findAll({
      include: {
        model: User,
        attributes: ["id", "nick"],
      },
      order: [["createdAt", "DESC"]],
    });
    res.render("main", {
      title: "Node Authentication",
      twits: posts,
    });
  } catch (error) {
    console.error("🚀 ~ file: page.js:67 ~ router.get ~ error", error);
    next(error);
  }
});

// 회원 가입
// 로그인이 되어 있지 않은 경우만 수행
router.get("/join", isNotLoggedIn, (req, res, next) => {
  res.render("join", { title: "Sign Up" });
});

// 프로필 화면 처리
// 로그인 되어 있는 경우만 수행
router.get("/profile", isLoggedIn, (req, res, next) => {
  res.render("profile", { title: "Profile" });
});

module.exports = router;
