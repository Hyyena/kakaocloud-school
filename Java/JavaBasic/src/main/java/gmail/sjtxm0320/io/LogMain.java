package gmail.sjtxm0320.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LogMain {
    public static void main(String[] args) {
        // 파일 경로 확인
        File file = new File("log.txt");
        // System.out.println(file.exists());

        // 문자열을 읽기 위한 스트림 생성
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            int sum = 0;

            // 줄 단위로 읽어서 출력
            while (true) {
                // 한 줄을 읽어서 읽은 게 없으면 종료
                // 읽은 내용이 있으면 출력
                String log = br.readLine();
                if (log == null) {
                    break;
                }
                // System.out.println(log);

                // 공백을 기준으로 분할
                String[] arr = log.split(" ");

                // IP 확인
                // System.out.println(arr[0]);

                // 트래픽 확인
                // System.out.println(arr[arr.length - 1]);

                // 트래픽을 정수로 변환해서 다힉
                try {
                    // 정수로 변환해서 더하는데 예외가 발생하면 넘어가도록 하기 위해 try catch 사용
                    sum += Integer.parseInt(arr[arr.length - 1]);
                } catch (Exception e) {
                }
            }
            System.out.println("Total Traffic: " + sum);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
