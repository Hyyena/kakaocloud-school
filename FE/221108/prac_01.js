/*
// Hoisting 가능
// 함수를 선언하기 전에 호출해도 호출이 가능
// 단, 이 방법을 권장하지 않는다.
func_1();

function func_1() {
  console.log("function 키워드 다음에 함수 이름 설정");
}

func_1();

// let을 이용해서 만들면 Hoisting 시 에러 발생
// func_2();

let func_2 = function () {
  console.log("function 키워드로 만들고, 변수에 대입");
};

func_2();

// 화살표 함수
// 함수를 다른 함수에 대입할 때 사용
let func_3 = () => {
  console.log("화살표 함수");
};

func_3();

// 매개변수를 받아서 매개변수만큼 출력
let func_4 = (n) => {
  for (var i = 0; i < n; i++) {
    console.log("매개변수 1개");
  }
};

func_4(3);

// 2개의 매개변수를 받아서 매개변수1만큼 매개변수2를 출력
// 매개변수가 2개 이상이면, 하나로 묶는 것을 고려
// 2개 이상이 되면, 매개변수를 순서대로 대입해야 한다.
// 대부분의 사람은 순서보다는 이름을 잘 기억하므로
// 2개 이상인 경우 별도의 이름을 이용해서 묶는 것이 좋다.
let func_5 = (n, msg) => {
  for (var i = 0; i < n; i++) {
    console.log(msg);
  }
};

func_5(3, "메시지");
*/

let data1 = 10;
let data2 = [100, 200, 300];

// 문자열은 세부 데이터 변경 불가
// 문자열은 전체를 변경해야 한다.
let data3 = "문자열";

let f1 = (arg) => {
  console.log("arg : " + arg);
  arg = 20;
};

// arg = data1 -> arg = 10
// 함수 내에서 변경을 해도 data1은 변경되지 않는다.
f1(data1);
console.log("data1 : " + data1);

let f2 = (arr) => {
  console.log("arr : " + arr);

  // 함수 내에서 매개변수로 받은 배열이나 객체의
  // 내부 요소를 변경하면 원본의 내용이 변경될 수 있다.
  // 바람직하지 않은 거승로 간주하지만
  // 메모리를 아낄 목적으로 이용하는 경우도 있다.
  arr[0] = 2030;
};

// 배열을 함수에 대입하면 배열의 내용이 변경될 수 있다.
f2(data2);
console.log("data2 : " + data2);
