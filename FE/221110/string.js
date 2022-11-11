const company = "kakaocloud";

console.log("문자열 길이: " + company.length);
console.log("0번째 문자: " + company.charAt(0));
console.log("0번째 문자 코드: " + company.charCodeAt(0));

// 대문자로 변환
console.log("대문자로 변환: " + company.toUpperCase());

// 소문자로 변환
console.log("소문자로 변환: " + company.toLowerCase());

let sample = "     Hello     ";
// 좌우 공백 제거 : trim
console.log("좌우 공백 제거 1: " + sample.trim());

// 좌우 공백 제거
let result = "";
let len = sample.length;
for (let i = 0; i < len; i++) {
  if (sample.charAt(i) !== " ") {
    result += sample.charAt(i);
  }
}
console.log("좌우 공백 제거 2: " + result);

// 찾아주는 메서드 : indexOf
console.log(company.indexOf("k")); // 앞에서부터 첫 번째
console.log(company.lastIndexOf("k")); // 뒤에서부터 첫 번째
console.log(company.indexOf("x")); // 못찾으면 음수

const uri = "abc/def";
// 문자열 분할
// 패턴을 가지고 분할해서 배열로 생성 : split
let arr = uri.split("/");
console.log(arr[0]);
console.log(arr[arr.length - 1]);

// 위치를 가지고 분할해서 문자열로 생성 : substring
// substring은 매개변수가 1개이면 그 이후를 전부 잘라서 리턴
// 매개변수가 2개이면 앞은 시작하는 위치
// 뒤는 끝나는 위치인 경우도 있고, 개수인 경우도 있다.
console.log(uri.substring(1));
console.log(uri.substring(1, 5));

// 문자열 템플릿
const data = 42;

// 이 데이터는 42 입니다. 형태로 출력
console.log("이 데이터는 " + data + " 입니다.");

console.log(`이 데이터는 ${data} 입니다.`);

/*
console.log("중간에 줄바꿈을 하면
에러가 발생");
*/
console.log(`중간에 줄바꿈을 해도
에러가 발생하지 않는다.`);

// 1986년 5월 5일에서 현재까지 지나온 날 수

// 현재 날짜 가져오기
let today = new Date();

// 1986년 5월 5일 설정
let meetday = new Date(1986, 4, 5);
console.log(meetday);

let interval = today.getTime() - meetday.getTime();
let date = interval / (1000 * 60 * 60 * 24);
console.log("지나온 날 수: " + Math.round(date));
