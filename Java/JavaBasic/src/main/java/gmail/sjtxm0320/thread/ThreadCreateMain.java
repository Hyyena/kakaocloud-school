package gmail.sjtxm0320.thread;

// Thread 클래스로부터 상속 받는 클래스
class ThreadEx extends Thread {
    @Override
    public void run() {
        // 1초마다 스레드 이름을 10번 출력
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadCreateMain {
    public static void main(String[] args) {
        // 클래스를 상속 받은 경우
        // 대부분의 경우 변수를 만들 때, 상위 클래스 이름을 사용
        Thread th1 = new ThreadEx();
        th1.start();

        // anonymous 클래스 사용
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // 1초마다 i 값을 10번 출력
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread th2 = new Thread(r);
        th2.start();
    }
}
