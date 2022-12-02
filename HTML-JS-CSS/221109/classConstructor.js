const Person = class {
  // 생성자
  constructor(num) {
    this.num = num;
  }

  getNum() {
    return this.num;
  }

  setNum(num) {
    this.num = num;
  }

  // 클래스가 호출하는 메서드
  // 숨겨진 매개변수인 this가 없음
  // prototype에 추가하는 것이 아닌 클래스에 추가
  // 인스턴스는 prototype에 추가된 것만 호출 가능
  static disp() {
    // 이 메서드 안에서 this를 사용하면
    // this는 인스턴스의 참조가 아닌 class 객체의 참조가 된다.
    return "static";
  }
};

// 인스턴스 생성
const person1 = new Person();
console.log(person1.getNum());

// 클래스 이름으로 일반 메서드를 호출하면 에러
// 메서드를 호출할 때 this에 인스턴스 자신의 참조를 넘겨야 하는데,
// 클래스는 인스턴스가 아니기 때문에 this에 대입이 안 됨
// console.log(Person.getNum());

// static이 붙으면 출력 가능
console.log(Person.disp);

// 인스턴스는 static 메서드를 호출할 수 없다.
// console.log(person.disp());
