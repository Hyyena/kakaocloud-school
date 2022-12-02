// 입력 데이터의 유효성 검사는 문자열과 정규 표현식 이용
// 텍스트 마이닝을 할 때, 정규 표현식에 해당하는 데이터를 다른 데이터로 치환하는 경우가 있다.

const str = "JavaScript Reg Exp";

// 위의 문자열에 script가 포함되어 있는지 확인
const regExp = /script/i;
console.log(regExp.test(str));

// 주민등록번호 검사
// 숫자6개-숫자7개
const jumin1 = "134567-1234567";
const jumin2 = "123456-123456";
const jumin3 = "1r3456-1234567";

// 패턴 생성
const jumin = /\d{6}-\d{7}/;
console.log(jumin.test(jumin1));
console.log(jumin.test(jumin2));
console.log(jumin.test(jumin3));

const email1 = "test@gmail.com";
const email2 = "test!gmail.com";

const email = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$/;
console.log(email.test(email1));
console.log(email.test(email2));
