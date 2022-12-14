package gmail.sjtxm0320;

import java.util.Date;

public class Member {
    private String name;
    private int age;
    private Date birth;
    private String email;
    private String nickname;

    public Member() {
        super();
    }

    public Member(String name, int age, Date birth, String email, String nickname) {
        super();
        
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.email = email;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Member{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", birth=" + birth +
            ", email='" + email + '\'' +
            ", nickname='" + nickname + '\'' +
            '}';
    }
}
