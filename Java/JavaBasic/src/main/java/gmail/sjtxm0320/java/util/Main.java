package gmail.sjtxm0320.java.util;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 정수 배열
        int[] arr = {60, 30, 20, 87, 56};

        // 문자열 배열
        String[] brr = {"최예나", "김채원", "조유리"};

        // 배열의 데이터 확인
        System.out.println(Arrays.toString(arr));

        // 정수 배열 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 문자열 배열 정렬
        Arrays.sort(brr);
        System.out.println(Arrays.toString(brr));

        // VO 클래스의 인스턴스 5개를 소유하는 배열
        VO[] datas = new VO[5];
        datas[0] = new VO(1, "노지선", 28);
        datas[1] = new VO(2, "박지원", 29);
        datas[2] = new VO(3, "송하영", 31);

        System.out.println(Arrays.toString(datas));
    }
}
