package gmail.sjtxm0320.operator;

public class Unary {
    public static void main(String[] args) {
        int n1 = 20;
        int n2 = -20;

        // 정수 데이터가 2진수로 저장된 구조를 출력
        System.out.println("n1: " + Integer.toBinaryString(n1));
        System.out.println("n2: " + Integer.toBinaryString(n2));

        // 1의 보수 구하기 : +21
        System.out.println("~n2: " + Integer.toBinaryString(~n2));

        int n = 20;
        System.out.println(n++); // 명령에 먼저 사용: 20
        System.out.println(++n); // 증감 후 명령에 사용: 22

        short s1 = 20;
        short s2 = 30;

        // short 사이의 덧셍이고, 결과도 50이기 때문에 short로 저장 가능하지만 이 문장은 에러이다.
        // 자바의 산술연산의 최소 단위는 int이기 때문
        // 자바는 s1과 s2를 int로 변환해서 연산을 수행하므로
        // 결과는 int가 되기 때문에 short에 저장할 수 없다.
        // short result = s1 + s2;
        int result = s1 + s2;

        // 실수의 산술 연산 결과
        double d = 0.1;
        double tot = 0.0;

        for (int i = 0; i < 100; i++) {
            tot += d;
        }

        // 0.1을 100번 더했는데 10이 아니고 9.99999999999998
        System.out.println("tot: " + tot);

        // 나누기 연산에서의 나누는 수 확인
        // 0으로 나누는 것이 에러가 아닐 수 있다.
        System.out.println(5 / 0.0);
    }
}
