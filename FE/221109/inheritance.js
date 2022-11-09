class Star {
  // 생성자
  constructor(name = "") {
    this.name = name;
  }

  attack() {
    console.log("공격");
  }
}

class Protoss extends Star {
  constructor(name = "", damage = 1) {
    // 상위 클래스의 생성자 호출
    super(name);
    this.damage = damage;
  }

  // 상위 클래스에 있는 메서드를 다시 정의하는 것
  // Method Overriding
  attack() {
    // 상위 클래스의 메서드 호출
    super.attack();
    console.log("프로토스의 공격");
  }
}

let protoss = new Protoss("질럿", 10);
protoss.attack();

// 위에 있는 protoss.attack()과 동일한 코드인데,
// 어떤 클래스의 인스턴스를 대입했느냐에 따라
// 다른 메서드를 호출하는데 이를 Polymorphism(다형성)이라 한다.
protoss = new Star("스타크래프트");
protoss.attack();
