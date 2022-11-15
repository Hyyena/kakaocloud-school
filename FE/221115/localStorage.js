let signInForm = document.getElementById("signInForm");
let idInput = document.getElementById("id");
let pwInput = document.getElementById("pw");
let idSave = document.getElementById("idSave");

// submit : form의 데이터를 전송할 때
signInForm.addEventListener("submit", () => {
  // 체크 여부 확인
  if (idSave.checked === true) {
    // 로컬 스토리지에 저장
    localStorage.ids = idInput.value;
  } else {
    // 로컬 스토리지에서 삭제
    delete localStorage.ids;
  }
});

// 메모리 로드가 끝났을 때, ids가 저장되어 있으면 가져오기
window.addEventListener("load", () => {
  if (typeof localStorage.ids !== "undefined") {
    idInput.value = localStorage.ids;
    idSave.checked = true;
  }
});
