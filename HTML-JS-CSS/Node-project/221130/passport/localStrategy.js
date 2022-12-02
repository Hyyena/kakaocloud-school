// 로컬 로그인 관련 기능 구현
const passport = require("passport");
const LocalStrategy = require("passport-local");
const bcrypt = require("bcrypt");
const User = require("../models/user");

module.exports = () => {
  passport.use(
    new LocalStrategy(
      {
        usernameField: "email",
        passwordField: "password",
      },
      async (email, password, done) => {
        try {
          // 로그인 처리를 위해서 email에 해당하는 데이터 찾기
          const exUser = await User.findOne({ where: { email } });

          if (exUser) {
            // 비밀번호 비교
            const result = await bcrypt.compare(password, exUser.password);

            if (result) {
              done(null, exUser);
            } else {
              done(null, false, { message: "비밀번호가 일치하지 않습니다." });
            }
          } else {
            done(null, false, { message: "존재하지 않는 회원입니다." });
          }
        } catch (error) {
          console.log("🚀 ~ file: localStrategy.js:32 ~ error", error);
          done(error);
        }
      }
    )
  );
};
