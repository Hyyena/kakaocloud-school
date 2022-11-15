// Input
let keyInput = document.getElementById("keyInput");
let valueInput = document.getElementById("valueInput");

// Button
let addBtn = document.getElementById("addBtn");
let delBtn = document.getElementById("delBtn");
let newTabBtn = document.getElementById("newTabBtn");

// fieldset list
let list = document.getElementById("list");

// 세션 스토리지의 내용을 읽어서 list에 출력하는 함수
// 처음 접속할 때, 삽입 or 삭제할 때
// 매번 데이터를 다시 출력할 생각이기 때문에 코드를 여러번 작성하지 않도록 하기
const showData = () => {
  // list초기화
  list.innerHTML = "";

  // 세션 스토리지를 순회하면서 하나씩 읽기
  for (let i = 0; i < sessionStorage.length; i++) {
    let key = sessionStorage.key(i);

    // select에 옵션을 추가
    // 앞의 내용이 보여지는 내용이고, 뒤의 내용이 이름
    list.options[list.options.length] = new Option(
      `${key}: ${sessionStorage[key]}`,
      key
    );
  }
};

// 윈도우가 모든 데이터를 로드한 후
window.addEventListener("load", () => {
  // Live Server를 이용해서 실행하면 기본적으로 하나의 데이터가 저장되서 출력
  showData();
});

// 삽입 버튼을 눌렀을 때
addBtn.addEventListener("click", () => {
  // 세션 스토리지에 저장
  sessionStorage[keyInput.value] = valueInput.value;

  // 데이터를 다시 출력
  showData();

  // input 데이터 초기화
  keyInput.value = "";
  valueInput.value = "";
});

// list를 클릭했을 때 클릭한 데이터를 input에 출력
list.addEventListener("click", () => {
  // 선택한 데이터 찾아오기
  let selectedData = list.options[list.selectedIndex];

  keyInput.value = selectedData.value;
  valueInput.value = sessionStorage[selectedData.value];
});

// 삭제 버튼을 눌렀을 때 선택된 데이터 삭제
delBtn.addEventListener("click", () => {
  // 선택한 데이터 삭제
  delete sessionStorage[keyInput.value];

  // 데이터를 다시 출력
  showData();
});

// New Tab 버튼을 눌렀을 때 새 창으로 열기
newTabBtn.addEventListener("click", () => {
  // 새 창에서 열면 세션은 현재 내용을 복제해서 생성
  window.open(location.href);
});
