// DOM 찾아오기
let allbtn = document.getElementById("allbtn");

// 데이터 출력을 위한 영역
let content = document.getElementById("content");

// allbtn 클릭 이벤트 처리
allbtn.addEventListener("click", (e) => {
  // ajax로 데이터 가져오기
  let request = new XMLHttpRequest();

  // 요청 생성
  request.open("GET", "/item/all");

  // 요청
  request.send("");

  // 데이터가 전송된 경우 처리
  request.addEventListener("load", () => {
    // 출력을 하기 위해서는 JSON 문자열을 자바스크립트 객체로 변환
    let data = JSON.parse(request.responseText);

    // 데이터 가져오기에 성공한 경우
    if (data.result == true) {
      content.innerHTML = "<div align='center' class='body'>";
      content.innerHTML += "<h2>상품 목록</h2>";
      content.innerHTML += "<table border='1'>";
      content.innerHTML += "<tr class='header'>";
      content.innerHTML += "<th align='center' width='80'>ID</th>";
      content.innerHTML += "<th align='center' width='320'>이름</th>";
      content.innerHTML += "<th align='center' width='100'>가격</th>";
      content.innerHTML += "</tr>";

      // list 키에 있는 데이터를 가져오기
      let arr = data.list;

      // 배열의 데이터 순회
      for (let item of arr) {
        content.innerHTML += "<tr class='record'>";

        content.innerHTML += "<td align='center'>" + item.itemid + "</td>";
        content.innerHTML += "<td align='left'>" + item.itemname + "</td>";
        content.innerHTML += "<td align='right'>" + item.price + "원</td>";

        content.innerHTML += "</tr>";
      }

      content.innerHTML += "</table>";
      content.innerHTML += "</div>";
    } else {
      content.innerHTML = "데이터 가져오기 실패";
    }
  });
});

let listBtn = document.getElementById("listBtn");

// 현재 페이지 번호를 저장할 변수 선언
let pageno = 1;

listBtn.addEventListener("click", (e) => {
  let request = new XMLHttpRequest();
  request.open("GET", `/item/list?pageno=${pageno}`);
  request.send("");

  request.addEventListener("load", () => {
    // 출력 영역을 초기화
    content.innerHTML = "";

    // 데이터 파싱
    let data = JSON.parse(request.responseText);
    console.log(data);

    if (data.result == true) {
      // 데이터 개수와 목록 가져오기
      let count = data.count;
      console.log(count);
      let list = data.list;

      // 출력 내용 만들기
      let display = "<div align='center' class='body' >";
      display += "<h2>상품 목록</h2>";
      display += "<table border='1' id='tableData'";
      display += "<tr><td colspan='3' align='right' >";
      display += `전체 데이터 개수: ${count}개</td></tr>`;

      // 항목 헤더 출력
      display += "<tr class='header' >";
      display += "<th width='80' >ID</th>";
      display += "<th width='320' >상품명</th>";
      display += "<th width='100' >가격</th>";
      display += "</tr>";

      // 데이터 목록 출력
      for (item of list) {
        display += `<tr class='record' >`;
        display += `<td align="center" >${item.itemid}</td>`;
        display += `<td align="left"><a href="#" id="item${item.itemid}">${item.itemname}</td>`;
        display += `<td align="right" >${item.price} 원</td>`;
        display += `</tr>`;
      }

      display += `</table></div>`;

      // 더보기 구현
      // 현재 페이지가 마지막 페이지가 아닌 경우만 출력
      if ((pageno - 1) * 5 < count) {
        display += `<table align="center" width="500" id="tableBtn">`;
        display += `<tr><td align="center" colspan="3">`;
        display += `<span id="addBtn"><a>더보기</a></span></td>`;
        display += `</tr></table>`;
      }

      content.innerHTML = display;

      // 더보기 버튼을 눌렀을 때 처리
      let addBtn = document.getElementById("addBtn");

      // addBtn이 존재하는 경우에만 수행
      if (addBtn != undefined) {
        addBtn.addEventListener("click", (e) => {
          pageno += 1;
          let request = new XMLHttpRequest();
          request.open("GET", `/item/list?pageno=${pageno}`);
          request.send("");

          // 전체 데이터 개수보다 더 많이 출력하면 더보기 영역을 삭제
          if (pageno * 5 >= data.count) {
            pageno -= 1;
            document.getElementById("tableBtn").remove();
          }

          // 데이터를 가져오면
          request.addEventListener("load", () => {
            let data = JSON.parse(request.responseText);
            let list = data.list;

            // 데이터 테이블 출력
            const table = document.getElementById("tableData");

            let display = "";
            for (item of list) {
              display += `<tr class="record">`;
              display += `<td align="center">${item.itemid}</td>`;
              // 상세보기를 위해 제목에 item+실제itemid를 추가해서 id 생성
              display += `<td align="left"><a href="#" id="item${item.itemid}">${item.itemname}</td>`;
              display += `<td align="right">${item.price} 원</td>`;
              display += `</tr>`;
            }

            table.innerHTML += display;
          });
        });
      }
    } else {
      content.innerHTML = "<p>데이터 로드 실패</p>";
    }
  });
});

// itemname을 눌렀을 때 수행할 코드
// 링크 하나 하나 이벤트 처리를 하는 것은 자원 낭비
// 부모에 이벤트 처리 코드를 작성
content.addEventListener("click", (e) => {
  // 클릭한 대상의 id가 item으로 시작하는 경우만 동작
  if (e.target.id.startsWith("item")) {
    // 클릭한 대상의 아이디에서 item을 제외한 부분 (itemid)
    let itemId = e.target.id.substring(4).trim();
    // console.log(itemid);
    // alert(itemid);

    let request = new XMLHttpRequest();
    request.open("GET", `/item/detail/${itemId}`);
    request.send("");

    request.addEventListener("load", () => {
      // console.log(request.responseText);

      let data = JSON.parse(request.responseText);

      if (data.result == true) {
        // 데이터 가져오기
        let item = data.item;

        // 출력 내용 생성
        let display = `<div align="center" class="body">`;

        display += `<h2>상세보기</h2>`;

        display += `<table>`;

        display += `<tr><td><a href="/img/${item.pictureurl}"><img src="/img/${item.pictureurl}" /></a><td>`;

        display += `<td align="center"><table>`;

        display += `<tr height="50"><td width="80">상품명</td>`;
        display += `<td width="160">${item.itemname}</td>`;

        display += `<tr height="50"><td width="80">가격</td>`;
        display += `<td width="160">${item.price} 원</td>`;

        display += `<tr height="50"><td width="80">비고</td>`;
        display += `<td width="160">${item.description}</td></tr>`;

        // 삭제를 위한 DOM 추가
        display += `<tr><td colspan="2" align="center" width="240">`;
        display += `<a href="#" id="deleteBtn">데이터 삭제</a>`;
        display += `</td></tr>`;

        // 수정을 위한 DOM 추가
        display += `<tr><td colspan="2" align="center" width="240">`;
        display += `<a href="#" id="updateBtn">데이터 수정</a>`;
        display += `</td></tr>`;

        display += `</table></td></tr></table>`;

        content.innerHTML = display;

        // 데이터 삭제를 눌렀을 때 처리
        let deleteBtn = document.getElementById("deleteBtn");

        if (deleteBtn != undefined) {
          deleteBtn.addEventListener("click", (e) => {
            // 폼이 없는 경우의 POST 방식 파라미터 만들기
            let params = `itemid=${item.itemid}`;

            let request = new XMLHttpRequest();
            request.open("POST", "/item/delete");

            // 폼이 아닌 경우는 form 형식으로 인코딩
            request.setRequestHeader(
              "Content-type",
              "application/x-www-form-urlencoded"
            );

            request.send(params);
            request.addEventListener("load", () => {
              let data = JSON.parse(request.responseText);

              if (data.result) {
                document.getElementById("listBtn").click();
                alert("삭제 성공");
              } else {
                alert("삭제 실패");
              }
            });
          });
        }

        // 데이터 수정을 눌렀을 때 처리
        let updateBtn = document.getElementById("updateBtn");

        if (updateBtn != undefined) {
          updateBtn.addEventListener("click", (e) => {
            let request = new XMLHttpRequest();

            request.open("GET", "/item/update");
            request.send("");
            request.addEventListener("load", () => {
              let html = request.responseText;

              content.innerHTML = html;

              // 수정은 수정하기 위한 원본 데이터를 화면에 출력
              document.getElementById("itemId").value = item.itemid;
              document.getElementById("itemId").readOnly = true;
              document.getElementById("itemName").value = item.itemname;
              document.getElementById("price").value = item.price;
              document.getElementById("description").value = item.description;

              // 원본 이름을 숨김
              document.getElementById("oldPictureUrl").value = item.pictureurl;

              // 원본을 다른 방식으로 출력
              document.getElementById(
                "pictureUrl"
              ).src = `/img/${item.pictureurl}`;

              // 수정 form 찾아오기
              let updateForm = document.getElementById("updateForm");

              if (updateForm != undefined) {
                updateForm.addEventListener("click", (e) => {
                  // 기본 이벤트 제거
                  e.preventDefault();

                  // 전송할 데이터 생성 (form 안에 입력한 데이터 생성)
                  const formData = new FormData(updateForm);

                  // 서버에게 요청
                  let request = new XMLHttpRequest();

                  request.open("POST", "/item/update");
                  request.send(formData);

                  // 응답을 받았을 때 처리
                  request.addEventListener("load", () => {
                    let data = JSON.parse(request.responseText);

                    if (data.result == true) {
                      document.getElementById("listBtn").click();
                      alert("수정 성공");
                    } else {
                      alert("수정 실패");
                    }
                  });
                });
              }
            });
          });
        } else {
        }
      }
    });
  }
});

let insertBtn = document.getElementById("insertBtn");
insertBtn.addEventListener("click", (e) => {
  // 삽입 화면 출력
  content.innerHTML = "";

  let html = `
      <div>
        <p></p>
        <form id="insertForm" enctype="multipart/form-data" method="post">
          아이템이름
          <input type="test" name="itemname" id="itemname" />
          <br/>
          가격
          <input type="text" name="price" id="price" />
          <br/>
          설명
          <input type="text" name="description" id="description" />
          <br/>
          이미지
          <input type="file" name="pictureurl" id="pictureurl" />
          <input type="submit" value="삽입" />
        </form>
      </div>
  `;

  content.innerHTML = html;

  // 폼 안에서 삽입 버튼을 눌렀을 때 처리
  let insertForm = document.getElementById("insertForm");

  if (insertForm != undefined) {
    insertForm.addEventListener("submit", (e) => {
      // 기본 이벤트 제거
      e.preventDefault();

      // 폼 데이터 찾아오기
      const formData = new FormData(insertForm);
      console.log(formData);

      // 폼 데이터 전송
      let request = new XMLHttpRequest();

      request.open("POST", "/item/insert", true);
      request.send(formData);
      request.addEventListener("load", () => {
        let data = JSON.parse(request.responseText);

        if (data.result) {
          // 데이터 다시 불러오기
          listBtn.click();
        } else {
          alert("삽입 실패");
        }
      });
    });
  }
});
