package gmail.sjtxm0320.network;

import java.util.ArrayList;
import java.util.List;

public class MethodParameter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("예나");
        list.add("채원");
        list.add("유리");

        /*
        list.forEach((tmp) -> {
            System.out.println(tmp);
        });
         */

        // Lambda로 구현해야 하는 메서드와 동일한 원형의 메서드 이름 대입
        list.forEach(System.out::println);
    }
}
