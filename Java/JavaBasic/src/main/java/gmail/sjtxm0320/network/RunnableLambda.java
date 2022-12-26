package gmail.sjtxm0320.network;

public class RunnableLambda {
    public static void main(String[] args) {
        // Runnable 인터페이스를 이용한 스레드 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("General");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }).start();

        // Lambda를 이용한 방식
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Using Lambda");
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }).start();
    }
}
