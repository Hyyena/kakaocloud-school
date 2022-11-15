// 필요한 DOM 객체 찾아오기
let imgInput = document.getElementById("imgInput");
let display = document.getElementById("display");

// imgInput의 선택이 변경되면
imgInput.addEventListener("change", (e) => {
  // 선택한 파일의 내용을 읽기
  // 비동기로 수행됨
  let reader = new FileReader();

  // 파일이 선택되었는지 확인
  // truthy : JavaScript는 0이 아닌 숫자나 null이나 undefined가 아니면 true로 간주
  if (!imgInput.files && imgInput.files[0]) {
    alert("선택된 파일이 없습니다.");
    return;
  }

  reader.readAsDataURL(imgInput.files[0]);

  // 파일의 내용을 전부 읽으면
  reader.addEventListener("load", (e) => {
    // 읽은 내용을 이미지의 소스로 사용
    display.src = reader.result;
  });
});
