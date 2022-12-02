let obj = {
  name: "John",
  job: "guitarlist",
  // 일반적으로 toString은 직접 호출하지 않고,
  // 출력하는 메서드에 객체 이름만 대입하면 자동으로 호출
  // 클래스를 만들 때, toString을 오버라이딩하면 출력할 때,
  // 객체 이름만으로 메서드를 호출할 수 있다.

  // toString: function () {
  //   return this.name + ": " + this.job;
  // },
};

console.log(obj);
