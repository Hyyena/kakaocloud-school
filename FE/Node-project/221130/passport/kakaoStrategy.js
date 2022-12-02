const passport = require("passport");
const KakaoStrategy = require("passport-kakao").Strategy;

// 유저 정보
const User = require("../models/user");

// 카카오 로그인
module.exports = () => {
  passport.use(
    new KakaoStrategy(
      {
        clientID: process.env.KAKAO_REST_API_KEY,
        callbackURL: "/auth/kakao/callback",
      },
      async (accessToken, refreshToken, profile, done) => {
        // 로그인 성공 시 정보 출력
        console.log(`kakao profile: ${profile}`);

        try {
          // 이전에 로그인 한 적이 있는지 찾기 위해서
          // 카카오 아이디와 provider가 kakao로 되어있는 데이터가 있는지 조회
          const exUser = await User.findOne({
            where: { snsId: profile.id, provider: "kakao" },
          });

          if (exUser) {
            done(null, exUser);
          } else {
            // 이전에 로그인 한 적이 없으면 데이터를 저장
            const newUser = await User.create({
              email: profile._json.kakao_account.email,
              nick: profile.displayName,
              snsId: profile.id,
              provider: "kakao",
            });
            done(null, newUser);
          }
        } catch (error) {
          console.log("🚀 ~ file: kakaoStrategy.js:43 ~ error", error);
          done(error);
        }
      }
    )
  );
};
