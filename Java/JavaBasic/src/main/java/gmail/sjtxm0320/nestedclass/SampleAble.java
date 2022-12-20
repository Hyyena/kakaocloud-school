package gmail.sjtxm0320.nestedclass;

/*
 * 인터페이스 안에 속성을 만들면 final 변수가 된다.
 * 인터페이스 안에 메서드를 만들면 abstract method가 된다.
 * 인터페이스 안에 메서드를 만들 때 내용을 추가하고자 하면 default 키워드를 추가해야 한다.
 * 인터페이스는 인스턴스를 생성하지 못한다.(변수 생성은 가능)
 * 클래스에 implements해서 사용한다.
 */
public interface SampleAble {
    // 자동으로 추상 메서드가 된다.
    // 추상 메서드는 하위 클래스에서 반드시 재정의해야 한다.
    void method();
}
