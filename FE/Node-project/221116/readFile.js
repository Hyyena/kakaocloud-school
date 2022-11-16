// 파일을 읽고 쓸 수 있는 모듈 가져오기
let fs = require("fs");

let data = fs.readFileSync("./test_01.txt");

// 줄단위로 분할해서 읽기
let arr = data.toString().split("\n");

arr.forEach((element) => {
  // console.log(element);
});

// 비동기식 파일 읽기
// error : 에러 내용, data : Buffer
fs.readFile("./test_01.txt", (error, data) => {
  if (error) {
    // 에러가 발생했을 때
    // console.log(error.message);
  } else {
    // 에러가 발생하지 않았을 때
    // console.log(data.toString());
  }
});

// console.log("파일 읽기 종료");

fs = require("fs/promises");

fs.readFile("./test_01.txt")
  .then((data) => {
    console.log(data.toString());
  })
  .catch((error) => {
    console.log(error.message);
  });
