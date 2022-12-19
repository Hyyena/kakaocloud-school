package gmail.sjtxm0320.inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        Sub sub = new Sub();

        // Sub 클래스에 만들지 않았던 setNum과 setName 사용 가능
        sub.setNum(1);
        sub.setName("yena");
        sub.setNickname("hyyena");
    }
}
