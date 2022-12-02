// DOM 불러오기
const result = document.getElementById("result");

// JavaScript 객체를 받아서 문자열로 변환 후 result에 출력하는 함수
const render = (content) => {
  // JavaScript 객체를 JSON 문자열로 변환
  // POST 방식에서 파라미터를 만들 때 많이 사용
  result.innerHTML = JSON.stringify(content);
};

// 전송방식, url, 파라미터를 받아서 요청 하는 함수
const promiseAjax = (method, url, payload) => {
  // resolve는 성공했을 때, 호출될 함수 : then
  // reject는 실패했을 때, 호출될 함수 : catch
  return new Promise((resolve, reject) => {
    const request = new XMLHttpRequest();
    request.open(method, url);

    request.setRequestHeader("Content-type", "application/json");

    // 파라미터를 전송할 때는 JavaScript 객체를 문자열로 변환해서 전송
    request.send(JSON.stringify(payload));

    request.addEventListener("load", () => {
      resolve(request.response);
    });

    request.addEventListener("error", () => {
      reject(new Error(request.status));
    });
  });
};

// 실제 요청
// 요청의 결과를 가지고 연속 작업
promiseAjax("GET", "https://jsonplaceholder.typicode.com/posts")
  .then(JSON.parse)
  .then(render, console.error);
