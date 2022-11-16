let today = new Date();

console.log(today);
console.log(today.getFullYear());
console.log(today.getMonth());
console.log(today.getDate());

// 오늘 날짜로 된 디렉토리(20221116)가 없으면 생성
let dirname =
  new String(today.getFullYear()) + (today.getMonth() + 1) + today.getDate();
console.log(dirname);

// 디렉토리 존재 여부 확인
const fs = require("fs");

fs.access(dirname, (error) => {
  if (error) {
    console.log("디렉토리 없음");
    fs.mkdir(dirname, (error) => {
      if (error) {
        console.log("디렉토리 생성 실패");
      } else {
        console.log("디렉토리 생성");
      }
    });
  } else {
    console.log("디렉토리 존재");
  }
});

const crypto = require("crypto");

const pass = "pass";
const salt = "salt";
const start = Date.now();

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("1: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("2: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("3: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("4: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("5: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("6: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("7: ", Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("8: ", Date.now() - start);
});
