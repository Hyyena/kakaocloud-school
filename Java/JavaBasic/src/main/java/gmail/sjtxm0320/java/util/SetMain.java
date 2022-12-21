package gmail.sjtxm0320.java.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("최예나");
        set.add("김채원");
        set.add("조유리");
        set.add("노지선");
        set.add("박지원");
        set.add("송하영");

        // 동일한 데이터를 삽입
        // equals 메서드로 비교해서 true이면 삽입하지 않는다.
        // Set은 데이터 삽입에 실패하면 false를 리턴하고, 성공하면 true를 리턴한다.
        set.add("최예나");

        System.out.println(set);

        set.add("카리나");
        System.out.println(set);

        // 로또 번호 생성기처럼
        // 1 ~ 45까지의 숫자 6개를 입력받아서 저장한 후 출력
        // 입력을 받을 때, 1 ~ 45 사이의 숫자가 아니면 다시 입력하도록
        // 중복되는 숫자를 입력하면 다시 입력하도록 한다.
        // 데이터를 출력할 때는 정렬 후 출력

        // 숫자 6개를 저장할 공간 생성
        // 중복 검사가 수월하고, 정렬을 수행하면서 삽입하는 TreeSet을 이용
        Scanner sc = new Scanner(System.in);

        // 중복된 데이터를 저장하지 않고 데이터를 정렬해서 저장하는 자료구조 클래스
        Set<Integer> treeSet = new TreeSet<>();

        // treeSet에 6개의 데이터가 저장되지 않은 경우
        while (treeSet.size() < 6) {
            System.out.println("로또 번호 입력");

            int tmp = sc.nextInt();
            if (tmp < 1 || tmp > 45) {
                System.out.println("1부터 45사이의 숫자를 입력하세요");
                continue;
            }

            // 중복 검사
            boolean result = treeSet.add(tmp);

            // 삽입에 실패하면(중복된 데이터라면)
            if (!result) {
                System.out.println("중복된 숫자입니다!");
            }
        }

        System.out.println(treeSet);

        // 스캐너 정리
        sc.close();

        /* 배열을 이용하는 경우
        // 입력받기 위한 인스턴스 생성
        Scanner sc = new Scanner(System.in);

        // 6개의 정수를 저장할 배열 생성
        int[] lotto = new int[6];

        int len = lotto.length;
        for (int i = 0; i < len; i++) {
            try {
                System.out.println("로또 번호 입력");
                lotto[i] = sc.nextInt();

                // 1부터 45 사이의 숫자만 입력받도록 하기
                if (lotto[i] < 1 || lotto[i] > 45) {
                    i--;
                    System.out.println("1 ~ 45 사이의 숫자만 입력하세요!");

                    // 중복검사를 하지 않고 패스하기 위해서
                    continue;
                }

                // 데이터 중복 검사
                // 첫 번째부터 현재 데이터 앞까지 비교
                boolean flag = false;

                for (int j = 0; j < i; j++) {
                    // 두 개의 데이터가 같을 때
                    if (lotto[i] == lotto[j]) {
                        flag = true;
                        break;
                    }
                }

                // 중복된 경우
                if (flag) {
                    i--;
                    System.out.println("중복된 숫자입니다!");
                }
            } catch (Exception e) {
                // 이번은 무효(인덱스를 뒤로)
                i--;

                sc.nextLine();
                System.out.println("숫자를 입력해주세요!");
            }
        }

        // 배열의 데이터 정렬
        Arrays.sort(lotto);

        // 배열의 데이터 출력
        System.out.println(Arrays.toString(lotto));

        // 스캐너 정리
        sc.close();

         */
    }
}
