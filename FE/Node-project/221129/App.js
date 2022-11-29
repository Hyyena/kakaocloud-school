const express = require("express");
const morgan = require("morgan");
const path = require("path");
const multer = require("multer");
const fs = require("fs");

// 환경 변수
require("dotenv").config();
const env = process.env;

// Express Web Application Server를 9000번 포트로 생성
const app = express();
app.set("port", process.env.PORT || 9000);

// 로그를 화면에 출력
app.use(morgan("dev"));

// form이 아닌 형태의 POST 방식의 파라미터를 읽기 위한 설정
let bodyParser = require("body-parser");
app.use(bodyParser.json()); // to support JSON-encoded bodies
app.use(
  bodyParser.urlencoded({
    // to support URL-encoded bodie
    extended: true,
  })
);

// 파일 다운로드를 구현하기 위한 모듈
let util = require("util");
let mime = require("mime");

// 파일 업로드를 위한 디렉토리 생성
try {
  fs.readdirSync("img");
} catch (error) {
  console.error("img 폴더가 없어 img 폴더를 생성합니다.");
  fs.mkdirSync("img");
}

// 파일 업로드
const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, done) {
      // 업로드 할 디렉토리 설정
      done(null, "img/");
    },
    filename(req, file, done) {
      // 업로드 될 때의 파일 이름 설정
      const ext = path.extname(file.originalname);
      done(null, path.basename(file.originalname, ext) + Date.now() + ext);
    },
  }),
  limits: { fileSize: 10 * 1024 * 1024 },
});

// 템플릿 엔진 설정
// 템플릿 엔진: 서버의 데이터를 HTML에 출력하기 위한 모듈
app.set("view engine", "html");
app.engine("html", require("ejs").renderFile);

// MongoDb 사용을 위한 모듈 가져오기
let MongoClient = require("mongodb").MongoClient;

// 접속할 데이터베이스 URL 설정
let databaseUrl = `${env.DIALECT}://${env.DB_USERNAME}:${env.DB_PASSWORD}@${env.HOST}:${env.DB_PORT}/?authMechanism=DEFAULT`;

/* 전체 아이템 조회 페이지
 * node 데이터베이스의 item 컬렉션에 존재하는 모든 데이터 리턴
 */
app.get("/item/list", (req, res) => {
  // 데이터베이스 연결
  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (error, database) => {
      if (error) {
        console.log("🚀 ~ file: App.js ~ line 75 ~ app.get ~ error", error);
        res.json({ result: false, message: "Database Connection Failed" });
      } else {
        // 데이터베이스 가져오기
        let db = database.db(env.DATABASE);

        // item 컬렉션의 모든 데이터 가져오기
        db.collection("item")
          .find()
          .sort({ itemid: -1 })
          .toArray((error, items) => {
            if (error) {
              console.log(
                "🚀 ~ file: App.js ~ line 87 ~ .toArray ~ error",
                error
              );
              res.json({ result: false, message: "failed to load items" });
            } else {
              res.json({ result: true, list: items, count: items.length });
            }
          });
      }
    }
  );
});

/* 페이지 단위로 아이템 가져오는 페이지
 * node 데이터베이스의 item 컬렉션의 데이터를 페이지 단위로 가져오기
 * 데이터베이스에 페이지 단위로 데이터를 가져올 때는
 * 건너뛸 개수와 가져올 데이터 개수가 필요

 * 클라이언트에서 넘겨주는 데이터: 페이지 번호와 데이터 개수
 */
app.get("/item/page", (req, res) => {
  // 클라이언트의 데이터 받아오기
  let pageNo = req.query.pageno; // 페이지 번호
  let count = req.query.count; // 한 번에 가져올 데이터 개수

  // 건너뛸 개수 계산
  if (pageNo == undefined) {
    pageNo = 1;
  }

  if (count == undefined) {
    count = 2;
  }

  // 웹에서 클라이언트가 전송하는 데이터는 기본적으로 문자열
  // 계산을 할 때는 숫자로 변형 후 계산해야 한다.
  let start = (parseInt(pageNo) - 1) * parseInt(count);

  // 데이터베이스 연결
  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (error, database) => {
      if (error) {
        console.log("🚀 ~ file: App.js ~ line 134 ~ app.get ~ error", error);
        res.json({ result: false, message: "Database Connection Failed" });
      } else {
        // 데이터베이스 가져오기
        let db = database.db(env.DATABASE);

        // item 컬렉션의 모든 데이터 가져오기
        db.collection("item")
          .find()
          .sort({ itemid: -1 })
          .skip(start)
          .limit(parseInt(count))
          .toArray((error, items) => {
            if (error) {
              console.log(
                "🚀 ~ file: App.js ~ line 148 ~ .toArray ~ error",
                error
              );
              res.json({ result: false, message: "failed to load items" });
            } else {
              res.json({ result: true, list: items, count: items.length });
            }
          });
      }
    }
  );
});

/* 아이템 상세보기 페이지
 * 기본 키 하나의 데이터를 필요로 하는 경우가 많고,
 * 결과는 하나의 데이터를 리턴하는 경우가 많다.
 * 그 이외에 주위의 3 ~ 10여개의 데이터를 같이 리턴하는 경우도 많다.
 */
app.get("/item/:itemid", (req, res) => {
  // 클라이언트의 데이터 받아오기
  // url에 포함된 데이터 받기
  let itemId = req.params.itemid;

  // 데이터베이스 연결
  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (error, database) => {
      if (error) {
        console.log("🚀 ~ file: App.js ~ line 178 ~ app.get ~ error", error);
        res.json({ result: false, message: "Database Connection Failed" });
      } else {
        // 데이터베이스 가져오기
        let db = database.db(env.DATABASE);

        // item 하나 가져오기
        db.collection("item").findOne(
          { itemid: Number(itemId) },
          (error, item) => {
            if (error) {
              console.log(
                "🚀 ~ file: App.js ~ line 190 ~ app.get ~ error",
                error
              );
              res.json({ result: false, message: "failed to load items" });
            } else {
              res.json({ result: true, item: item });
            }
          }
        );
      }
    }
  );
});

/* 데이터 삽입 구현
 * itemname, description, price, pictureurl() 받기
 *
 */
app.post("/item", upload.single("pictureurl"), (req, res) => {
  // 파라미터 읽어오기
  const itemName = req.body.itemname;
  const description = req.body.description;
  const price = req.body.price;

  let pictureUrl;

  // 업로드한 파일이 있으면 파일의 이름을 설정하고, 없으면 디폴트 값 설정
  if (req.file) {
    pictureUrl = req.file.filename;
  } else {
    pictureUrl = "default.jpg";
  }

  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (error, database) => {
      if (error) {
        console.log("🚀 ~ file: App.js ~ line 229 ~ app.post ~ error", error);
        res.json({ result: false, message: "Database Connection Failed" });
      } else {
        let db = database.db("node");

        // 가장 큰 itemid를 찾아오기
        db.collection("item")
          .find({}, { projection: { _id: 0, itemid: 1 } })
          .sort({ itemid: -1 })
          .limit(1)
          .toArray((error, result) => {
            let itemId = 1;

            if (result[0] != null) {
              itemId = result[0].itemid + 1;
            }

            db.collection("item").insertOne(
              {
                itemid: itemId,
                itemname: itemName,
                description: description,
                price: price,
                pictureurl: pictureUrl,
              },
              (error, result) => {
                if (error) {
                  console.log(
                    "🚀 ~ file: App.js ~ line 256 ~ .toArray ~ error",
                    error
                  );
                  res.json({ result: false, message: "failed to insert item" });
                } else {
                  res.json({ result: true });
                }
              }
            );
          });
      }
    }
  );
});

// 에러 처리를 위한 부분
app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).send(err.message);
});

// 서버 구동
app.listen(app.get("port"), () => {
  console.log("📡", app.get("port"), "PORT wating...");
});
