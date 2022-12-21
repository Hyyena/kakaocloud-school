package gmail.sjtxm0320.java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 데이터 클래스(VO)
class VO1 {
    private int num;
    private String name;

    public VO1() {
        super();
    }

    public VO1(int num, String name) {
        super();
        this.num = num;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "VO1{"
            + "num=" + num
            + ", name='" + name + '\''
            + '}';
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        // 데이터 생성 (Model)
        VO1 vo = new VO1(1, "최예나");

        // 데이터 출력 (View)
        // 모델의 근원이 되는 VO 클래스 안에 속성 이름을 변경하면 View도 수정되어야 한다.
        // 관계형 데이터베이스는 VO 클래스를 활용
        System.out.println(vo.getNum());
        System.out.println(vo.getName());

        // VO 클래스의 인스턴스 역할을 수행하는 Map을 생성
        Map<String, Object> map = new HashMap<>();

        // 데이터 저장
        map.put("번호", 1);
        map.put("이름", "예나");

        // map의 모든 키를 가져와서 출력
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
