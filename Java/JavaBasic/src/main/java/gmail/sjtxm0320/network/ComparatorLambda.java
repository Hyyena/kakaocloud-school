package gmail.sjtxm0320.network;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        // 데이터 정렬을 위해서 문자열 배열 생성
        String[] arr = {"예나", "채원", "유리", "지선", "지원", "하영"};

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(arr));

        // Using Lambda
        // 코드는 간결해졌지만 가독성이 떨어진다.
        /*
        Arrays.sort(arr, (o1, o2) -> {
            return o2.compareTo(o1);
        });
        */
        // 아래 코드처럼도 작성 가능하다.
        Arrays.sort(arr, (o1, o2) ->
            o2.compareTo(o1)
        );
        System.out.println(Arrays.toString(arr));
    }
}
