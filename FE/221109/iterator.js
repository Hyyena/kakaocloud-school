// 일반 객체 생성
let obj = { name: "Anthony", job: "singer" };

// Iterator 가능 여부
let result1 = obj[Symbol.iterator];

if (result1 === undefined) {
  console.log("순차적 반복처리 불가능");
} else {
  console.log("순차적 반복처리 가능");
}

let arr = ["XHTML", "CSS", "JavaScript", "HTML5", "Node.js", "React.js"];

let result2 = arr[Symbol.iterator];

if (result2 === undefined) {
  console.log("순차적 반복처리 불가능");
} else {
  console.log("순차적 반복처리 가능");

  // 반복자 가져오기
  let iter = arr[Symbol.iterator]();
  console.log(iter.next());
  console.log(iter.next());
  console.log(iter.next());
  console.log(iter.next());
  console.log(iter.next());
  console.log(iter.next());
  console.log(iter.next());
}

// in은 속성을 추출 (배열의 경우 인덱스)
for (attr in arr) {
  console.log(attr);
}

// of는 데이터를 순회
for (attr of arr) {
  console.log(attr);
}

// 문자열도 순회 가능
const str = "abcdefg";
for (ch of str) {
  console.log(ch);
}
