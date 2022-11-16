// 파일을 읽고 쓸 수 있는 모듈 가져오기
const fs = require("fs");

// key값과 iv값이 들어있는 텍스트 파일 파싱
let data = fs.readFileSync("./problem_01.txt");

// 줄단위 구분
let arr = data
  .toString()
  .split(/\r?\n/)
  .filter((element) => element);

// key값 파싱
let key = arr[0].toString().split("=");
key = key[1];

// iv값 파싱
let iv = arr[1].toString().split("=");
iv = iv[1];

// 암호화 모듈 가져오기
const crypto = require("crypto");

// 알고리즘은 정해진 것을 이용
const algorithm = "aes-256-cbc";

// 암호화 객체 생성
let cipher = crypto.createCipheriv(algorithm, key, iv);
let result = cipher.update("01012345678", "utf8", "base64");
result += cipher.final("base64");
console.log(result);

// 복호화
let decipher = crypto.createDecipheriv(algorithm, key, iv);
let result2 = decipher.update(result, "base64", "utf8");
result2 += decipher.final("utf8");
console.log(result2);
