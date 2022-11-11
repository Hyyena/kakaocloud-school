let map = new Map();

// Map은 동일한 key에 데이터를 여러번 저장하면 마지막 데이터로 수정
map.set("name", "adam");
console.log(map);

map.set("name", "아담");
console.log(map);

// 데이터 가져오기
console.log(map.get("name"));
console.log(map.get("이름"));

// 전체 데이터 순회
for (key of map.keys()) {
  console.log(key);
}

// iphone에서 접속한 것을 확인
// 이 코드는 대부분 서버에 작성
let os = ["iphone"];
for (o of os) {
  // os 배열에 있는 문자열이 userAgent에 포함 여부 확인
  if (navigator.userAgent.toLowerCase().indexOf(0) >= 0) {
    // 배열에 포함된 운영체제에서 접속했을 때 수행할 작업
    break;
  }
}
