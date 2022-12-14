package gmail.sjtxm0320.operator;

public class RelationOperator {
    public static void main(String[] args) {
        System.out.println(10 > 3);

        // 정수끼리는 자료형이 달라도 크기 비교는 가능
        System.out.println(10 > 10L);
        System.out.println(10L > 10);

        // 실수는 크기 비교에서도 정확한 결과를 만들어내지 못할 수 있다.
        System.out.println((1.0 - 0.8) >= 0.2);

        // 문자열의 경우 리터럴으로 만들었는지
        // 외부에서 입력을 받는지에 따라 다른 결과가 만들어 질 수 있다.
        String s1 = "hyyena";
        String s2 = "yena";
        System.out.println(s1 == s2);
    }
}
