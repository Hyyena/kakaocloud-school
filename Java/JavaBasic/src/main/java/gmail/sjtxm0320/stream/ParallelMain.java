package gmail.sjtxm0320.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelMain {
    public static void main(String[] args) {
        // 정수 리스트 생성
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        //일반 스트림으로 1초씩 쉬면서 출력
        long start = System.currentTimeMillis();
        list.stream().forEach(tmp -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });

        long end = System.currentTimeMillis();
        System.out.println("time(general): " + (end - start) + "ms");

        // 병렬 스트림으로 1초씩 쉬기
        start = System.currentTimeMillis();
        list.stream().parallel().forEach(tmp -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });

        end = System.currentTimeMillis();
        System.out.println("time(parallel): " + (end - start) + "ms");

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
