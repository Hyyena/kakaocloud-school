const express = require("express");
const axios = require("axios");

// 매번 동일한 요청을 위한  URL을 상수로 설정
// const URL = "http://localhost:9090/v1";
const URL = "http://localhost:9090/v2";

// ajax 요청을 할 때, 누가 요청했는지 확인해주기 위해 origin header 추가
axios.defaults.headers.origin = "http://localhost:10000";

// 토큰 발급 코드
const request = async (req, api) => {
  try {
    if (!req.session.jwt) {
      const tokenResult = await axios.post(`${URL}/token`, {
        clientSecret: process.env.CLIENT_SECRET,
      });

      // 세션에 토큰 저장
      req.session.jwt = tokenResult.data.token;
    }

    // 토큰 내용 확인
    const result = await axios.get(`${URL}/${api}`, {
      headers: { authorization: req.session.jwt },
    });

    return result;
  } catch (error) {
    // 토큰 유효 기간 만료
    if (error.response.status === 419) {
      // 기존 토큰 삭제
      delete req.session.jwt;

      // 토큰을 다시 생성해달라고 요청
      return request(req, api);
    }

    return error.response;
  }
};

const router = express.Router();

router.get("/mypost", async (req, res, next) => {
  try {
    const result = await request(req, "/posts/my");
    res.json(result.data);
  } catch (error) {
    console.error("🚀 ~ file: index.js:49 ~ router.get ~ error", error);
    next(error);
  }
});

router.get("/test", async (req, res, next) => {
  try {
    if (!req.session.jwt) {
      const tokenResult = await axios.post("http://localhost:9090/v1/token", {
        clientSecret: process.env.CLIENT_SECRET,
      });

      if (tokenResult.data && tokenResult.data.code === 200) {
        req.session.jwt = tokenResult.data.token;
      } else {
        // 토큰 발급 실패
        return res.json(tokenResult.data);
      }
    }

    // 토큰 내용 확인
    const result = await axios.get("http://localhost:9090/v1/test", {
      headers: { authorization: req.session.jwt },
    });

    return res.json(result.data);
  } catch (error) {
    console.log("🚀 ~ file: index.js:10 ~ router.get ~ error", error);
    next(error);
  }
});

router.get("/", (req, res) => {
  res.render("main", { key: process.env.CLIENT_SECRET });
});

module.exports = router;
