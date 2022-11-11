document.getElementById("paragraph").addEventListener("clikc", (e) => {
  for (attr in e) {
    console.log(attr + ": " + e[attr]);
  }
});

document.getElementById("btn").addEventListener("click", (e) => {
  // 문단 태그의 클릭이 발생하도록 강제로 이벤트 발생
  document.getElementById("paragraph").click();
});
