package gmail.sjtxm0320.java.lang;

import java.util.Arrays;
import java.util.Objects;

// 하나의 데이터 묶음을 표현하기 위한 클래스
// Value Object(VO)
public class Data implements Cloneable {
    private int num;
    private String name;
    private String[] nicknames;

    // Default Constructor
    public Data() {
        super();
    }

    // 속성을 대입받아서 생성하는 생성자
    // 인스턴스를 빠르게 초기화하기 위해서 사용
    public Data(int num, String name, String[] nicknames) {
        super();
        this.num = num;
        this.name = name;
        this.nicknames = nicknames;
    }

    // 접근자 메서드
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    // 인스턴스의 내용을 빠르게 만들기 위해서 사용
    // 디버깅을 위한 메서드
    @Override
    public String toString() {
        return "Data{"
            + "num=" + num
            + ", name='" + name + '\''
            + ", nicknames=" + Arrays.toString(nicknames)
            + '}';
    }

    // 복제를 위한 메서드
    public Data clone() {
        Data data = new Data();

        // 이 방식은 얕은 복사(weak copy)
        // num은 숫자 데이터이므로 바로 복제 가능
        // name과 necknames는 숫자 데이터가 아니기 때문에 바로 대입하면 참조가 대입된다.
        data.setNum(this.num);
        data.setName(this.name);
        // data.setNicknames(this.nicknames);

        // 배열을 복제한 후 대입(깊은 복사)
        String[] nicknames = Arrays.copyOf(this.nicknames, this.nicknames.length);
        data.setNicknames(nicknames);

        return data;
    }

    // 데이터의 내용이 같은지 확인하는 메서드
    @Override
    public boolean equals(Object other) {
        // 원래 자료형으로 변환
        Data newOther = (Data)other;

        // return this.num == newOther.getNum() && this.name == newOther.getName();

        // 위 방법보다 아래 방법이 더 빠름

        // Objects.hash(데이터 나열)을 이용하면 데이터를 정수로 만든 해시코드 생성
        return Objects.hash(num, name) == Objects.hash(newOther.getNum(), newOther.getName());
    }
}
