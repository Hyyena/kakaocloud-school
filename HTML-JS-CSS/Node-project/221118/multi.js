const btn = document.getElementById("btn");
const img = document.getElementById("image");
const title = document.getElementById("title");

btn.addEventListener("click", (e) => {
  // 전송할 폼 데이터 생성
  const formData = new FormData();

  // 내용 추가
  let files = img.files;

  for (let idx = 0; i < files.length; idx++) {
    formData.append("image", img.files[idx]);
  }

  formData.append("title", title.value);

  // ajax를 이용한 전송
  let xhr = new XMLHttpRequest();

  xhr.open("POST", "/multi", true);
  xhr.send(formData);
  xhr.addEventListener("load", (e) => {
    // 서버가 준 JSON 문자열을 파싱
    let text = xhr.responseText;
    let result = JSON.parse(text);

    // 파싱 결과 출력
    console.log(result.result);
  });
});
