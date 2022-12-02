// 배열 생성
let arr1 = ["HTML", "CSS", "JavaScript", "Reac.js"];
let arr2 = ["MariaDB", "Java", "Spring"];

// 2개의 배열 합치기
// Map Reduce Programming에서 각각의 데이터로 처리한 후 결과를 합친다.
let subjects = arr1.concat(arr2);

// 전체 배열을 확인
console.log(subjects);

// 배열의 데이터를 순서대로 순회
for (subject of subjects) {
  console.log(subject);
}

// 처음에 데이터를 추가하고 처음에 삽입한 데이터를 제거
// Queue(FIFO, Firtst In Firtst Out)
// ex) 스케쥴링에 이용
// JavaScript에서는 unshift와 shift로 구현되어 있음
subjects.unshift("node");
console.log(subjects);

// 마지막에 데이터를 추가하고 마지막에 삽입한 데이터를 제거
// Stack(LIFO, Last In First Out)
// ex) 복귀 주소 저장에 이용
// JavaScript에서는 push와 pop로 구현되어 있음
subjects.push("Linux");
console.log(subjects);
