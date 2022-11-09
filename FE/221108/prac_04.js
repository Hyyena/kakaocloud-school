/*
? 뒷부분을 query string 또는 parameter라고 함
자바스크립트에서 서버에게 요청을 할 때,
query string에 영문과 숫자 이외의 데이터가 있으면 인코딩해서 전송해야 한다.
*/
const url = "https://www.kakao.com/taxi?name=블랙";

/*
인코딩 수행 -> https://www.kakao.com/taxi?name=%EB%B8%94%EB%9E%99
최근에는 서버 렌더링을 잘 사용하지 않기 때문에 더욱 중요
*/
const param = encodeURI(url);
console.log(param);
