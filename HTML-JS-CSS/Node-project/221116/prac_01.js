// {}로 묶어서 내보낸 것은 이름을 맞추어서 받아야 한다.
const { odd, even } = require("./prac_01_variable");

// 하나를 내보낼 때는 이름을 바꿔서 받을 수 있다.
// prac_01_func의 내용울 가져와서 checkNumber라는 이름을 붙이는 것
const checkNumber = require("./prac_01_func");

console.log(checkNumber(5));
console.trace(5);

const os = require("os");
console.log(os.freemem());

const path = require("path");
console.log(path.sep);

// 현재 디렉토리 확인
console.log(__dirname);

// 현재 디렉토리 내의 public 디렉토리 경로
console.log(path.join(__dirname, "public"));

// const url = require("url");

// let address = "https://www.naver.com/login?id=sjp03083";

// // url 분해
// const p = url.parse(address);

// // pathname에는 서버 url을 제외한 경로를 저장
// // query는 query string을 저장
// console.log(p);

// address에서 파라미터 부분만 가져오기
// searchParams 속성을 호출하면 파라미터 부분에 해당하는 객체를 리턴
const address = new URL("https://www.naver.com/login?id=sjp03083");
console.log(address.searchParams);

// id 값 추출
console.log(address.searchParams.get("id"));
