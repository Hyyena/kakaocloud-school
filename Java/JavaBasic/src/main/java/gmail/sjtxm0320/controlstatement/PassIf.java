package gmail.sjtxm0320.controlstatement;

import java.util.Scanner;

public class PassIf {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("점수 입력: ");
            int score = sc.nextInt();

            if (score >= 60) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

