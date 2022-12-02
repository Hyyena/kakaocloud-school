let num = document.getElementById("num");
let sumBtn = document.getElementById("sumBtn");
let sumResult = document.getElementById("sumResult");

let sumWorker;

sumBtn.addEventListener("click", () => {
  // 워커가 만들어져 있으면 중지
  if (sumWorker) {
    sumWorker.terminate();
  }

  // 워커 생성
  sumWorker = new Worker("sumWorker.js");

  // 메시지 전송
  sumWorker.postMessage(Number(num.value));

  // 워커가 결과를 전송했을 때
  sumWorker.onmessage = (event) => {
    // 워커가 전송한 데이터 출력
    sumResult.innerHTML = `합계 : ${event.data.toLocaleString()}`;
  };
});
