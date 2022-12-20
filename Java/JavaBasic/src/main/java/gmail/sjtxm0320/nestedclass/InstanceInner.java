package gmail.sjtxm0320.nestedclass;

public class InstanceInner {
    // 내부 클래스의 특성에 static이 추가되면
    // 외부에서 인스턴스를 만들 때, 클래스이름.new 내부클래스이름() 의 형태로 만든다.
    // ex) 안드로이드에서 뷰의 이벤트 처리를 위한 인터페이스들이 이러한 방식으로 설계돼있다.
    public static class Inner {
        public static int autoIncrement;

        // 내부 클래스에 static 멤버가 존재하면 클래스의 특성에 static을 추가해줘야 한다.
        public int score;
    }
}
