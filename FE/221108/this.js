// name과 song이라는 속성을 갖는 생성자
// 매개변수가 없는 생성자를 default constructor라고 한다.
let singer = function () {
  // this가 없으면 지역변수가 만들어진다.
  // this와 함께 만들어야 객체의 속성이 된다.
  this.name = "이름없음";
  this.song = "노래없음";
};

// 생성자를 이용한 인스턴스를 생성
let obj = new singer();
console.log("obj: ", obj);

let artist = function (name = "이름없음", job = "불분명") {
  this.name = name;
  this.job = job;
};

let suzi = new artist("수지", "가수");
let iu = new artist("아이유", "가수");
let tae = new artist("태연");

console.log("suzi: ", suzi);
console.log("iu: ", iu);
console.log("tae: ", tae);
