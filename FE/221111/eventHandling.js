// window의 load 이벤트는
// 파일을 전부 읽어서 태그들을 전부 메모리에 적재한 후에 발생
window.addEventListener("load", (e) => {
  document.getElementById("display").innerHTML = "이벤트 처리";

  for (let i = 0; i < 100; i++) {
    document.getElementById("body").innerHTML += "<h1>무한 스크롤</h1>";
  }

  window.addEventListener("scroll", (e) => {
    // 스크롤하는 위치와 문서의 높이가 같을 때
    // 가장 아래에서 스크롤을 할 때

    // 스크롤하는 가장 상단의 위치를 가져오기
    let supportPageOffset = window.pageXOffset !== undefined;
    let isCSS1Compat = (document.compatMode || "") === "CSS1Compat";
    let scrollTop = supportPageOffset
      ? window.pageYOffset
      : isCSS1Compat
      ? document.documentElement.scrollTop
      : document.body.scrollTop;

    // 스크롤하는 높이
    let scrollHeight = scrollTop + window.innerHeight;

    // 문서의 높이
    let documentHeight = document.body.clientHeight;

    // 스크롤하는 위치가 문서의 높이보다 크거나 같다면
    if (scrollHeight >= documentHeight) {
      for (let i = 0; i < 100; i++) {
        document.getElementById("body").innerHTML += "<h1>무한 스크롤</h1>";
      }
    }
  });
});
