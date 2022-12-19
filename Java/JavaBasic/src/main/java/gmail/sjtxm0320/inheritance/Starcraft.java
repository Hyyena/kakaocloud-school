package gmail.sjtxm0320.inheritance;

// Protoss, Zerg, Terran 클래스의 인스턴스를 하나의 변수에 대입할 수 있도록 하기 위한 상위 클래스
public interface Starcraft {
    // Overriding을 위해서 생성한 메서드 (추상 메서드)
    // 추상 메서드는 추상 클래스나 인터페이스에만 존재할 수 있다.
    void attack();
}
