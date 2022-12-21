package gmail.sjtxm0320.java.util;

import java.util.HashMap;
import java.util.Map;

public class Array2D {
    public static void main(String[] args) {
        // 배열의 배열
        // 2차원 배열: Matrix
        // 태그가 없음
        String[] tmp1 = {"최예나", "김채원", "조유리"};
        String[] tmp2 = {"노지선", "박지원"};
        String[] tmp3 = {"송하영", "박지원", "이채영"};

        // 2차원 배열 생성
        // 변수가 추가되면 태그를 수정해야 한다.
        String[][] arr2D = {tmp1, tmp2, tmp3};

        int i = 0;
        for (String[] strings : arr2D) {
            if (i == 0) {
                System.out.print("조유리즈:\t");
            } else {
                System.out.print("97즈:\t");
            }

            i++;

            for (String string : strings) {
                System.out.print(string + "\t");
            }

            System.out.println();
        }

        // 2차원 배열 대신 Map의 배열 (Table)
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "조유리즈");
        map1.put("team", tmp1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "97즈");
        map2.put("team", tmp2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "삐융즈");
        map3.put("team", tmp3);

        Map[] v = {map1, map2, map3};

        for (Map map : v) {
            System.out.print(map.get("name") + "\t");

            String[] tmp = (String[])map.get("team");
            for (String s : tmp) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }
}
