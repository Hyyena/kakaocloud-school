package gmail.sjtxm0320.thread;

public class ThreadMain {
    public static void main(String[] args) {
        Thread th1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        // 스레드를 Daemon으로 설정
        // 다른 스레드가 동작 중이 아니면 자동 종료
        th1.setDaemon(true);
        th1.start();

        // NullPointerException 예외 발생
        // Daemon이 아닌 스레드는 다른 스레드가 중지되더라도 계속 동작
        // String str = null;
        // System.out.println(str.trim());

        Thread th2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        // th2.start();

        Thread th3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        // th3.start();

        // 스레드의 우선 순위 설정
        // 우선 순위가 높아지면 먼저 실행되거나 자주 실행될 가능성이 높음
        th2.setPriority(Thread.MIN_PRIORITY);
        th3.setPriority(Thread.MAX_PRIORITY);

        th2.start();
        th3.start();
    }
}
