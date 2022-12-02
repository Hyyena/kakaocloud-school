let arr = [10, 30, 27, 16, 38, 99];

// 배열의 모든 데이터를 출력 : forEach
// forEach : 배열을 순회하면서 함수를 호출
// 함수의 매개변수 자리에 배열의 데이터를 순서대로 대입해서 함수 호출
// 이러한 방법은 내부 반복자를 사용하기 때문에 실행 속도가 빠름
arr.forEach((e) => {
  console.log(e);
});

// 배열의 모든 요소에 함수를 호출해서 그 결과를 모아서 배열로 리턴
let r = arr.map((e) => {
  return e * 10;
});
console.log(r);

// filter는 조건에 맞는 데이터만 추출하는 함수
// 매개변수가 1개이고, Boolean을 리턴하는 함수를 설정
// 짝수만 찾기
r = arr.filter((e) => {
  return e % 2;
});
console.log(r);

// ko가 포함된 것만 찾기
let arr2 = ["KOrea", "china", "korean"];
r = arr2.filter((e) => {
  return e.toLowerCase().indexOf("ko") >= 0;
});
console.log(r);
