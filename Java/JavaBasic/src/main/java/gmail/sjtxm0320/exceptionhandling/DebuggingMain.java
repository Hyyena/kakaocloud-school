package gmail.sjtxm0320.exceptionhandling;

import java.util.Arrays;

public class DebuggingMain {
    public static void test() {
        int x = 10;
        int[] arr = {30, 20, 30, 50};

        x = 30;
        System.out.println(x);

        arr[2] = 90;
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        test();
    }
}
