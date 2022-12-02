// DOM 객체 찾아오기
let btn = document.getElementById("btn");
let display = document.getElementById("display");

// 버튼을 클릭했을 때
btn.addEventListener("click", (e) => {
  // ajax 요청 객체 생성
  let request = new XMLHttpRequest();

  // 요청 준비
  request.open("GET", "./resources/data.json");

  // 요청 전송
  request.send("");

  // 응답 받기
  // 정상적으로 응답이 왔을 때
  request.addEventListener("load", () => {
    // XML 이외의 데이터 읽기
    // display.innerHTML = request.responseText;

    let result = JSON.parse(request.responseText);
    display.innerHTML = `<p>데이터 개수: ${result.count}</p>`;

    let arr = result.documents;
    // 배열을 순회하면서 {} 안의 내용을 수행
    arr.forEach((doc) => {
      display.innerHTML += `<h3>이름 : ${doc.name}</h3>`;
      display.innerHTML += `<p>나이: ${doc.age}</p>`;
      display.innerHTML += `<p>생일: ${doc.birthday}</p>`;
    });
  });

  // 요청 도중 문제 발생
  request.addEventListener("error", (error) => {
    display.innerHTML = error.message;
  });
});
