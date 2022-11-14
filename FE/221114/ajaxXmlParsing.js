// DOM 객체 찾아오기
let btn = document.getElementById("btn");
let display = document.getElementById("display");

btn.addEventListener("click", (e) => {
  let request = new XMLHttpRequest();

  request.open("GET", "./resources/data.xml");
  request.send("");
  request.addEventListener("load", () => {
    // 읽어온 데이터 중 name 태그 내용만 추출
    let xmlData = request.responseXML;
    let names = xmlData.getElementsByTagName("name");

    // 순회하면서 태그 안의 내용을 추출
    for (let i = 0; i < names.length; i++) {
      const name = names[i].childNodes[0].nodeValue;
      display.innerHTML += `<p>이름: ${name}</p>`;
    }
  });
});
