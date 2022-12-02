// 필요한 DOM 찾아오기
let csv = document.getElementById("csv");
let json1 = document.getElementById("json1");
let json2 = document.getElementById("json2");
let content = document.getElementById("content");

// csv 버튼을 눌렀을 때
csv.addEventListener("click", (e) => {
  // ajax 요청 객체 생성
  let request = new XMLHttpRequest();

  // 연결 준비
  // open(요청 방식, URL)
  request.open("GET", "data.csv");

  // 요청
  // 데이터와 함께 전송해야 하는데, 현재는 없는 코드
  request.send("");

  // 요청을 받기 위한 콜백 등록
  // 정상 응답이 온 경우
  request.addEventListener("load", () => {
    // XML 이외의 데이터 읽기
    // 읽은 데이터 ,로 구분된 csv 형식
    let arr = request.responseText.split(",");

    for (name of arr) {
      content.innerHTML += "<p>" + name + "</p>";
    }
  });

  // 에러가 발생했을 때 처리
  request.addEventListener("error", () => {
    console.log(request.status);
  });
});

json1.addEventListener("click", (e) => {
  let request = new XMLHttpRequest();

  request.open("GET", "data1.json");
  request.send("");

  request.addEventListener("load", () => {
    // JSON 파싱을 해서 데이터로 만들어주는 것
    let result = JSON.parse(request.responseText);

    content.innerHTML += "<p>이름: " + result.firstname + "</p>";
    content.innerHTML += "<p>성: " + result.lastname + "</p>";
    content.innerHTML += "<p>직업: " + result.job + "</p>";
  });

  // 에러가 발생했을 때 처리
  request.addEventListener("error", () => {
    console.log(request.status);
  });
});

json2.addEventListener("click", (e) => {
  let request = new XMLHttpRequest();

  request.open("GET", "data2.json");
  request.send("");

  request.addEventListener("load", () => {
    let result = JSON.parse(request.responseText);

    // 필요한 데이터만 추출해서 사용 : parsing
    let count = result.count;
    content.innerHTML += "<p>인원수: " + count + "</p>";

    let arr = result.documents;
    arr.forEach((element) => {
      content.innerHTML +=
        "<p>이름: " + element.name + ", 회사: " + element.company + "</p>";
    });
  });

  // 에러가 발생했을 때 처리
  request.addEventListener("error", () => {
    console.log(request.status);
  });
});
