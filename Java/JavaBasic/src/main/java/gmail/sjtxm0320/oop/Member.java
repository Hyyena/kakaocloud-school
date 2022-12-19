package gmail.sjtxm0320.oop;

import java.util.Arrays;
import java.util.Date;

public class Member {
    private String email;
    private String password;
    private String[] nicknames;
    private Date birthday;
    private boolean married;
    private int age;

    // 매개변수가 없는 생성자(Default Constructor)
    // 기본적으로 제공되지만 생성자를 만들면 없어진다.
    public Member() {
        super();
    }

    // 모든 속성을 매개변수로 받아서 초기화해주는 생성자
    public Member(String email, String password, String[] nicknames, Date birthday, boolean married, int age) {
        this.email = email;
        this.password = password;
        this.nicknames = nicknames;
        this.birthday = birthday;
        this.married = married;
        this.age = age;
    }

    // 접근자 메서드
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 속성에 배열이나 List와 같은 컬렉션이 있을 때는 컬렉션 내에서
    // 하나의 데이터만 읽고 쓸 수 있는 메서드를 제공해주는 것이 좋다.
    public String getNickname(int index) {
        return nicknames[index];
    }

    public void setNickname(int index, String nickname) {
        nicknames[index] = nickname;
    }

    // 6개의 값을 받아서 속성들을 초기화해주는 메서드
    public void init(String email, String password, String[] nicknames, Date birthday, boolean married, int age) {
        // 클래스의 메서드 안에서 속성 이름을 사용하면
        // 메서드 안에 만들어진 것을 찾고, 없으면 클래스에 만들어진 것을 찾고,
        // 그래도 없으면 상위 클래스에서 찾고 없으면 에러
        // 클래스에서 만들어진 곳에서 먼저 찾고자 할 때는 앞에 this. 을 추가하면 된다.
        this.email = email;
        this.password = password;
        this.nicknames = nicknames;
        this.birthday = birthday;
        this.married = married;
        this.age = age;

    }

    // 모든 속성의 toString을 호출해서 하나의 문자열로 만들어주는 메서드
    // 출력하는 메서드에서 인스턴스 이름을 대입하면 자동 호출
    // 디버깅(값을 확인하는 작업)을 위해서 호출하는 메서드
    @Override
    public String toString() {
        return "Member [email = " + email + ", password = " + password + ", nicknames = " + Arrays.toString(nicknames)
            + ", birthday = " + birthday + ", married = "
            + married + ", age = " + age + "]";
    }
}
