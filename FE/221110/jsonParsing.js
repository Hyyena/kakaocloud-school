// 이 데이터는 실제로는 서버에서 받아온다.
let jsonText = '{ "name": "adam", "age": 47 }';

// 파싱을 수행
let result = JSON.parse(jsonText);

// 이번 문자열은 {} 안에 있으므로 객체
console.log(result.name);
console.log(result.age);

// 배열 문자열
jsonText = "[40, 50, 20, 40]";
result = JSON.parse(jsonText);

// 배열을 순회
result.forEach((element) => {
  console.log(element);
});
