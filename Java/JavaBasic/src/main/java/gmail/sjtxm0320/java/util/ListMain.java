package gmail.sjtxm0320.java.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        // 정수를 저장하기 위한 ArrayList
        List<Integer> al = new ArrayList<>();

        // 정수를 저장하기 위한 LinkedList
        List<Integer> li = new LinkedList<>();

        al.add(1);
        al.add(3);

        li.add(1);
        li.add(3);

        long start;
        long end;

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            al.add(1, 2);
        }
        end = System.currentTimeMillis();

        System.out.println("ArrayList 중간에 데이터 삽입하는 시간: " + (end - start) + "ms"); // 377ms

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            li.add(1, 2);
        }
        end = System.currentTimeMillis();

        System.out.println("LinkedList 중간에 데이터 삽입하는 시간: " + (end - start) + "ms"); // 9ms

        List<String> list = new ArrayList<>();

        list.add("예나");
        list.add("채원");
        list.add("유리");
        list.add("카리나");
        list.add("윈터");

        // 순회
        for (String temp : list) {
            System.out.println(temp);
        }

        // 데이터 정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(list);
    }
}
