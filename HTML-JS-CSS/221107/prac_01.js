/*
var x = 10;

// 앞의 식의 결과가 false이면 뒤의 식을 확인하지 않음
let result = x > 10 && x++;
console.log(x);

// JavaScript는 Boolean이 아니어도 && 연산을 할 수 있음
result = true && 10;
console.log(result);

let data1 = [1, 2];
let data2 = [3, 4];

// data1 == Falsy -> data2 대입
// data1 == Truly -> data1 대입
result = data1 || data2;
console.log(result);

var a1 = 20;
var a2 = 30;

// 맨 앞의 내용이 true이면 다음 내용이 남고
// 그렇지 않으면 마지막 내용이 남는다.
let max = a1 > a2 ? a1 : a2;
console.log(max);

// Nullish Operator
var data1 = 0;
var data2 = "JavaScript";

// 0은 Falsy 값이기 때문에 data2가 남는다.
let result = data1 || data2;
console.log(result);

// data1이 null이 아니기 때문에 data1이 남는다.
// `??` 연산자는 Falsy를 판단하는 것이 아니고,
// 데이터의 존재 여부를 확인한다.
result = data1 ?? data2;
console.log(result);

var str = "카리나";
console.log(typeof str);

var arr = ["카리나", "윈터", "지젤"];
// 존재 여부 확인
console.log("닝닝" in arr);


// 데이터를 입력받기
var score = prompt("점수를 입력하세요.");
console.log(score);

// 점수가 60 이상이면 합격이라고 출력
if (Number(score) >= 60) {
  alert("합격!");

// 점수가 60 이상이면 합격, 아니면 불합격이라고 출력
if (Number(score) >= 60) {
  alert("합격!");
} else {
  alert("불합격")
}

// 점수가 90 이상이면 A, 80 이상이면 B, 60 이하는 C
if (Number(score) >= 90) {
  alert("A");
} else if (Number(score) >= 80) {
  alert("B");
} else {
  alert("C");
}

// 1 ~ 4 사이의 문자를 입력
let menu = prompt("1 부터 4 사이의 문자를 입력하세요.");

// 1이면 중식, 2이면 한식, 3이면 일식, 4이면 분식 그 이외는 잘못된 입력
switch (menu) {
  case "1":
    alert("중식");
    break;
  case "2":
    alert("한식");
    break;
  case "3":
    alert("일식");
    break;
  case "4":
    alert("분식");
  default:
    alert("잘못된 입력입니다.");
    break;
}

let score = print("점수를 입력하세요");

switch (true) {
  case score >= 60:
    alert("합격");
    break;
  case score < 60:
    alert("불합격");
    break;
}

// Hello JavaScript를 3번 출력
console.log("Hello JavaSCript");
console.log("Hello JavaSCript");
console.log("Hello JavaSCript");

// 0부터 3보다 작을 때 까지 하나씩 증가하면서 수행
// 0, 1, 2
// 스파게티 코드가 제거되서 유지보수가 편리해진다.
for (var i = 0; i < 3; i++) {
  console.log("Hello JavaScript");
}

// 일정한 패턴이 반복되는 반복문

// img1.png, img11.png, img21.png, img31.png
// 위의 내용을 반복문을 이용해서 해결
for (var i = 0; i < 4; i++) {
  console.log("img" + (10 * i + 1) + ".png");
}

// 초기식을 while 외부에 작성하고, 증감식을 반복 블럭 안에 작성하면
// for와 거의 유사한 역할을 하는 형태를 만들 수 있다.
var i = 0;
while (i < 4) {
  console.log("img" + (10 * i + 1) + ".png");
  i++;
}

// do ~ while로 작성하면 반드시 한 번은 수행한다는 의미를 전달
var i = 0;
do {
  console.log("img" + (10 * i + 1) + ".png");
  i++;
} while (i < 4);

// Object 객체 생성 - name과 age라는 속성에 adam과 26이라는 값을 저장
var obj = { name: "adam", age: 26 };

// Array 객체 생성
var arr = [100, 300, 200];

// obj가 가진 모든 속성을 attr에 대입하고 {} 안의 내용 수행
for (var attr in obj) {
  console.log(attr + ":" + obj[attr]);
}

// 배열의 경우 인덱스가 순서대로 attr에 대입
for (var attr in arr) {
  console.log(attr + ":" + arr[attr]);
}

for (var i = 0; i < 10; i++) {
  console.log(i);
  if (i % 3 == 0) {
    // 반복문 중단
    break;
  }
  console.log(i);
}

for (var i = 0; i < 10; i++) {
  if (i % 3 == 0) {
    // continue 아래는 수행하지 않고, 다음 반복으로 넘어감
    continue;
  }
  console.log(i);
}

for (var i = 0; i < 5; i++) {
  for (var j = 0; j < 5; j++) {
    document.write("*");
  }
  document.write("<br/>");
}

for (var i = 0; i < 5; i++) {
  for (var j = 0; j < i + 1; j++) {
    document.write("*");
  }
  document.write("<br/>");
}

for (var i = 0; i < 5; i++) {
  for (var j = 0; j < 2 * i - 1; j++) {
    document.write("*");
  }
  document.write("<br/>");
}

for (var i = 0; i < 5; i++) {
  for (var j = 0; j < 5 - 1 * i; j++) {
    document.write("*");
  }
  document.write("<br/>");
}

for (var i = 0; i < 5; i++) {
  // 3보다 작을 때 : 3줄은 증가하는 형태로 작성
  if (i < 3) {
    for (var j = 0; j < i + 1; i++) {
      document.write("*");
    }
  }
  // 3보다 크거나 같을 때 : 감소하는 형태로 작성
  else {
    for (var j = 0; j < 5 - 1 * i; j++) {
      document.write("*");
    }
  }
  document.write("<br/>");
}
*/

for (let i = 0; i < 6; i++) {
  for (let j = 0; j < 5 - 2 * i; j++) {
    document.write("1");
  }
  for (let j = 0; j < 2 * i - 1; j++) {
    document.write("*");
  }
  for (let j = 0; j < 2 * i - 1; j++) {
    document.write("1");
  }
  for (let j = 0; j < 5 - 2 * i; j++) {
    document.write("*");
  }
  document.write("<br/>");
}
