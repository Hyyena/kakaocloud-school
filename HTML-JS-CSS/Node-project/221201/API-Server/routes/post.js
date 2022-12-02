const express = require("express");

// 파일 업로드를 위한 모듈
const multer = require("multer");
const path = require("path");
const fs = require("fs");

// 데이터 삽입을 위한 모듈
const { Post, Hashtag } = require("../models");

// 로그인 여부 판단
const { isLoggedIn } = require("./middlewares");

const router = express.Router();

// 파일을 업로드 할 디렉토리가 없으면 생성
try {
  fs.readdirSync("public/img");
} catch (error) {
  fs.mkdirSync("public/img");
}

// 파일 업로드 객체
const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, cb) {
      cb(null, "public/img/");
    },
    filename(req, file, cb) {
      const ext = path.extname(file.originalname);

      cb(null, path.basename(file.originalname, ext) + Date.now() + ext);
    },
  }),
  limits: { fileSize: 10 * 1024 * 1024 },
});

// 이미지 업로드
router.post("/img", isLoggedIn, upload.single("img"), (req, res) => {
  console.log(req.file);

  res.json({
    url: `/img/${req.file.filename}`,
  });
});

// 게시글 업로드
const upload2 = multer();
router.post("/", upload2.none(), async (req, res, next) => {
  try {
    // 게시글 업로드
    const post = await Post.create({
      content: req.body.content,
      img: req.body.url,
      UserId: req.user.id,
    });

    // 해시태그 찾기
    // # 다음에 나오는 내용을 찾음
    const hashtags = req.body.content.match(/#[^\s#]*/g);

    // 해시태그가 있으면 삽입
    if (hashtags) {
      // 전부 실행
      const result = await Promise.all(
        // 배열의 전체 데이터를 순서대로 대입해서 {} 안의 내용 수행
        hashtags.map((tag) => {
          return Hashtag.findOrCreate({
            where: {
              title: tag.slice(1).toLowerCase(),
            },
          });
        })
      );

      await post.addHashtags(result.map((r) => r[0]));
    }

    res.redirect("/");
  } catch (error) {
    console.log("🚀 ~ file: post.js:81 ~ router.post ~ error", error);
    next(error);
  }
});

module.exports = router;
