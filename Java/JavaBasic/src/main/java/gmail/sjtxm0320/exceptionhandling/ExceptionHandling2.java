package gmail.sjtxm0320.exceptionhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling2 {
    public static void main(String[] args) {
        String message = null;

        // br은 처리가 끝나면 자동으로 close()를 호출
        // JDK 1.7에서 추가된 문법
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            message = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
    }
}
