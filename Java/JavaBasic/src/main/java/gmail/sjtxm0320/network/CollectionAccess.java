package gmail.sjtxm0320.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionAccess {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("예나");
        list.add("채원");
        list.add("유리");

        int len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();

        // 이터레이터 이용
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();

        // 빠른 열거
        for (String s : list) {
            System.out.print(s + "\t");
        }
        System.out.println();

        // Stream API 이용
        // 내부 반복자를 이용하기 때문에 가장 빠름
        Stream<String> stream = list.stream();

        // \t 사용을 못 한다.
        // stream.forEach(System.out::println);

        stream.forEach(tmp -> System.out.print(tmp + "\t"));
    }
}
