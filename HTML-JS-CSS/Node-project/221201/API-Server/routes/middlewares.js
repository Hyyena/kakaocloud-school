exports.isLoggedIn = (req, res, next) => {
  if (req.isAuthenticated()) {
    next();
  } else {
    res.status(403).send("로그인이 필요한 서비스입니다.");
  }
};
//
exports.isNotLoggedIn = (req, res, next) => {
  if (!req.isAuthenticated()) {
    next();
  } else {
    // 메시지를 생성하는 Query String(parameter)으로 사용할 것이기 때문에 Encoding을 해주어야 한다.
    const message = encodeURIComponent("로그인 상태입니다.");

    // 이전 request 객체의 내용을 모두 삭제하고,
    // 새로운 요청 흐름을 만드는 것으로 새로고침을 하면 결과 화면만 새로고침 된다.
    res.redirect(`/?error=${message}`);
  }
};

const jwt = require("jsonwebtoken");
exports.verifyToken = (req, res, next) => {
  try {
    // 토큰 확인
    req.decoded = jwt.verify(req.headers.authorization, process.env.JWT_SECRET);

    // 인증에 성공하면 다음 작업 수행
    return next();
  } catch (error) {
    if (error.name === "TokenExpiredError") {
      return res.status(419).json({
        code: 419,
        message: "Token has expired",
      });
    }
    return res.status(401).json({
      code: 401,
      message: "Invalid Token",
    });
  }
};
