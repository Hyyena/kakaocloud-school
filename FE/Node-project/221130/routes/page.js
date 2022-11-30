const express = require("express");
const { isLoggedIn, isNotLoggedIn } = require("./middlewares");

const router = express.Router();

// 공통된 처리 (무조건 수행)
router.use((req, res, next) => {
  // 로그인 한 유저 정보
  res.locals.user = null;

  // 게시글을 follow 한 개수
  res.locals.followCount = 0;
  // 게시글을 following 하고 있는 개수
  res.locals.followingCount = 0;

  // 게시글을 follow 하고 있는 유저 목록
  res.locals.followerIdList = [];
  next();
});

// 메인 화면
router.get("/", (req, res, next) => {
  const twits = [];

  // 템플릿 엔진을 이용한 출력
  // views 디렉토리의 main.html로 출력
  res.render("main", { title: "Node Authentication", twits });
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
