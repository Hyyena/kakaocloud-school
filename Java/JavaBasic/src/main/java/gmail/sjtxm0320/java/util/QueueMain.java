package gmail.sjtxm0320.java.util;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        // 데이터를 sort 된 것 처럼 저장
        Queue<String> queue = new PriorityQueue<>();

        queue.offer("최예나");
        queue.offer("김채원");
        queue.offer("조유리");
        queue.offer("박지원");
        queue.offer("노지선");
        queue.offer("송하영");

        System.out.println(queue);
        System.out.println(queue.poll());
    }
}
