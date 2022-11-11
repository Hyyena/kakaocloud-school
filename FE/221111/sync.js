// btn이라는 id를 가진 버튼을 눌렀을 떄
document.getElementById("btn").addEventListener("click", (e) => {
  // 동기식 처리

  // 반복문을 10억번 돌렸을 떄걸리는 시간을 측정
  const start = Date.now();

  for (let i = 0; i < 100000000; i++) {}

  const end = Date.now();

  console.log((end - start) * 1000 + "초");

  console.log("다음 작업");

  // 비동기식 처리
  // 타이머는 비동기식 처리를 수행
  setTimeout(() => {
    const start = Date.now();

    for (let i = 0; i < 100000000; i++) {}

    const end = Date.now();

    console.log((end - start) * 1000 + "초");
  }, 0); // 기다리는 시간 없이 바로 수행

  console.log("다음 작업");
});
