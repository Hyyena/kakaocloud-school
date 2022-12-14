/* // 웹 서버 모듈 가져오기
const express = require("express");

// 절대 경로 생성을 위해 사용
const path = require("path");

// .env 파일의 내용을 읽어서 process.env에 저장해주는 모듈
const dotenv = require("dotenv");

// 로그 출력을 위한 모듈 가져오기
const morgan = require("morgan");

// 세션 사용을 위한 모듈 가져오기
const session = require("express-session");
// 세션을 파일에 저장하기 위한 모듈 가져오기
const fileStore = require("session-file-store")(session);

// 쿠키 사용을 위한 모듈 가져오기
const cookieParser = require("cookie-parser");

// 파일 업로드를 위한 모듈 가져오기
const fs = require("fs");
const multer = require("multer");

// .env 읽어오기
dotenv.config();

// 웹 서버 객체 생성과 포트 설정
const app = express();
app.set("port", process.env.PORT);

// 로그 출력
app.use(morgan("dev"));

// 세션 사용을 위한 미들웨어 장착
// req.session으로 세션 객체 사용
// app.use(
//   session({
//     secret: "keyboard cat",
//     resave: false,
//     saveUninitialized: true,
//     store: new fileStore(),
//   })
// );

// POST 방식의 파라미터를 읽을 수 있도록 설정
// app.use(express.json());
// app.use(expressurlencoded({ extended: false }));

// 쿠키 사용이 가능하도록 설정
// app.use(cookieParser(process.env.COOKIE_SECRET));

// // 파일 업로드하기 위한 디렉토리 생성
// try {
//   // 디렉토리를 읽을 때 디렉토리가 없으면 예외 발생
//   fs.readdirSync("uploads");
// } catch (error) {
//   // 디렉토리 생성
//   fs.mkdirSync("uploads");
// }

// 파일 업로드 설정
// const upload = multer({
//   storage: multer.diskStorage({
//     destination(req, file, done) {
//       done(null, "uploads/");
//     },
//     filename(req, file, done) {
//       file.originalname = Buffer.from(file.originalname, "latin1").toString(
//         "utf-8"
//       );
//       const ext = path.extname(file.originalname);
//       done(null, path.basename(file.originalname, ext) + Date.now() + ext);
//     },
//   }),
//   limits: { fileSize: 1024 * 1024 * 10 },
// });

// 포트번호(localhost:3000 -> ContextPath)까지 요청 처리
// app.get("/", (req, res) => {
//   res.sendFile(path.join(__dirname, "./index.html"));
// });

// 라우팅 관련 파일 가져오기
const indexRouter = require("./index");
const userRouter = require("./user");
const boardRouter = require("./board");

// url과 매핑
app.use("/", indexRouter);
app.use("/user", userRouter);
app.use("/board", boardRouter);

// 하나의 파일 업로드 처리
// app.get("/multi", (req, res) => {
//   res.sendFile(path.join(__dirname, "./multi.html"));
// });

// app.post("/multi", upload.array("image"), (req, res) => {
//   // title 파라미터 읽기
//   // post 방식에서의 파라미터는 req.body.파라미터이름
//   console.log(req.body.title);
//   console.log(req.file.originalname);
//   res.send("성공");

//   // node에서 json 전송
//   let result = { result: "success" };
//   res.json(result);
// });

// 웹 서버 실행
app.listen(app.get("port"), () => {
  console.log(app.get("port"), "번 포트 서버 대기 중");
});
 */

const express = require("express");

// 로그 출력을 위한 모듈 가져오기
const morgan = require("morgan");

const path = require("path");

const indexRouter = require("./routes/index");
const userRouter = require("./routes/user");
const boardRouter = require("./routes/board");

const app = express();
app.set("port", 3000);

// pug 설정
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "pug");

// 로그 출력
app.use(morgan("dev"));

app.use("/", (req, res) => {
  // 템플릿 엔진으로 출력
  // views/index.html로 출력
  res.render("index", { title: "Pug", aespa: ["카리나", "윈터"] });
});

// URL과 매핑
// app.use("/", indexRouter); // 요청은 indexRouter에서 처리
app.use("/user", userRouter); // /user가 앞에 있는 것은 userRouter에서 처리
app.use("/board", boardRouter); // /board가 앞에 있는 것은 userRouter에서 처리

// 웹 서버 실행
app.listen(app.get("port"), () => {
  console.log(app.get("port"), "번 포트 서버 대기 중");
});
