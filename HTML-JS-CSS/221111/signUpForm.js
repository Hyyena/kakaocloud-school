/*
비밀번호가 비어있으면 전송이 안되도록 작성
비밀번호 확인란을 만들어서 비밀번호와 확인란이 맞지 않으면 전송이 안되도록 작성
비밀번호의 패턴이 맞지 않으면 전송이 되지 않도록 작성
비밀번호의 패턴을 보고 강한 비밀번호인지 아닌지 판별
*/

let signUpForm = document.getElementById("signUpForm");

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pwVal = document.getElementById("pwVal");

let idMsg = document.getElementById("idMsg");
let pwMsg = document.getElementById("pwMsg");
let pwValMsg = document.getElementById("pwValMsg");

// 최소 8자, 하나 이상의 문자와 하나의 숫자
const reg1 = /^(?=.*[A-Za-z])(?=.*d)[A-Za-zd]{8,}$/;

// 최소 8자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자
const reg2 = /^(?=.*[A-Za-z])(?=.*d)(?=.*[@$!%*#?&])[A-Za-zd@$!%*#?&]{8,}$/;

signUpForm.addEventListener("submit", (e) => {
  // 아이디 입력 확인
  if (id.value.trim().length === 0) {
    idMsg.innerHTML = "아이디를 입력해주세요!";
    idMsg.style.color = "Red";

    // 기본 이벤트를 제거해서 서버에 전송하지 않도록 하기
    e.preventDefault();
  }

  // 비밀번호 입력 확인
  // if (pw.value.trim().length === 0) {
  //   pwMsg.innerHTML = "비밀번호를 입력해주세요!";
  //   pwMsg.style.color = "Red";

  //   e.preventDefault();
  // }

  // 비밀번호 일치
  if (pw.value.trim() === pwVal.value.trim() && pw.value.trim().length !== 0) {
    pwValMsg.innerHTML = "비밀번호가 일치합니다.";
    pwValMsg.style.color = "Green";
  }

  // 비밀번호 불일치
  if (pw.value.trim() !== pwVal.value.trim()) {
    pwValMsg.innerHTML = "비밀번호가 일치하지 않습니다!";
    pwValMsg.style.color = "Red";

    e.preventDefault();
  }
  // 비밀번호 패턴 확인
  if (reg1.test(pw.value.trim()) === false) {
    pwMsg.innerHTML = "최소 8자, 하나 이상의 문자와 하나의 숫자를 포함해주세요";
    pwMsg.style.color = "Red";

    e.preventDefault();
  }

  // 비밀번호 보안 확인
  if (reg1.test(pw.value.trim()) === true) {
    pwMsg.innerHTML = "비밀번호가 강력합니다!!";
    pwMsg.style.color = "Green";
  }
});
