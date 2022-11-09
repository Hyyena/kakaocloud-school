// class : 동일한 모양의 객체를 만들기 위해서 사용하는 모형
// 사용자 정의 자료형
const Member = class {
  // 생성자
  constructor(name) {
    // name 속성을 {} 안에 감싸서 만들면 속성이 생성된다.
    // 인스턴스가 속성을 직접 호출하는 것이 가능
    // return { name: "noname" };

    // 인스턴스가 속성을 직접 호출하는 것이 불가능
    // 아래와 같은 경우 데이터를 리턴하는 메서드를 별도로 만들어야 한다.
    this.name = name;
  }

  // name이라는 속성을 생성하면서 대입
  setName(name) {
    this.name = name;
  }
  // name 속성의 값을 리턴하는 메서드
  getName() {
    return this.name;
  }
};

// 인스턴스 생성
const member = new Member();

// 생성자에서 name이라는 속성을 생성했으므로, name 속성 사용 가능
console.log(member.name);

console.log(member.getName());
