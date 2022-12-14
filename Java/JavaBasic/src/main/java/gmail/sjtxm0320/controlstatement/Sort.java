package gmail.sjtxm0320.controlstatement;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};

        for (int i = 0; i < arr.length; i++) {
            // 기준의 뒤부터 마지막 자리까지
            for (int j = i + 1; j < arr.length; j++) {
                // 자리의 데이터를 비교해서 기준 자리의 데이터가 크면 2개의 데이터를 swap
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            // 하나의 pass가 완료되면 출력
            System.out.println(Arrays.toString(arr));
        }
    }
}
