package gmail.sjtxm0320.inheritance;

public class Sub extends Super {
    private String nickname;

    public Sub() {
        System.out.println("상위 클래스의 생성자 호출 전 수행");
        // 상위 클래스의 생성자 호출
        // super(1, "hyyena");
        System.out.println("상위 클래스의 생성자 호출 뒤 수행");
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Sub [nickname = " + nickname + "]";
    }
}
