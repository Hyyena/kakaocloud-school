// Math.random() : 랜덤한 숫자를 출력
// 범위는 0.0 ~ 1.0
// console.log(Math.random());

// 숫자를 정수로 만들기 : 반올림, 내림, 올림
// 0부터 4까지의 정수가 나오도록 하기
let num = Math.random() * 1000;
let menu = Math.round(num % 5);

// 0이면 한식, 1이면 중식, 2이면 일식, 3이면 분식, 4이면 양식
let foods = ["한식", "중식", "일식", "분식", "양식"];
console.log(foods[menu]);
