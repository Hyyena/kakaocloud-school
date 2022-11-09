/*
// Member라는 클래스 생성
class Member {
  // 클래스 안에 메서드를 만들 때는 function 생략
  getName() {
    return this.name;
  }

  // 메서드 안에서 `this.속성이름`을 이용하면 객체의 속성이 생성됨
  setName(name) {
    this.name = name;
  }
}

// 클래스의 인스턴스 만들기
let member = new Member();
member.setName("John");

// 인스턴스를 이용한 메서드 호출
console.log(member.getName()); // 이름

Member.prototype.getJob = function () {
  return "직업";
};

console.log(member.getJob()); //
 */

function f() {
  console.log("매개변수가 없는 함수");
}

function f(n) {
  console.log("매개변수가 있는 함수");
}

f(10); // 매개변수가 있는 함수
f(); // 매개변수가 있는 함수
