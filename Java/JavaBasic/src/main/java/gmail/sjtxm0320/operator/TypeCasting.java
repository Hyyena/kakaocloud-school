package gmail.sjtxm0320.operator;

public class TypeCasting {
    public static void main(String[] args) {
        double d = 37.4;

        // 실수를 정수에 직접 대입하면 에러가 발생
        // 실수가 정수보다 크기 때문이다.
        // 강제 형 변환을 이용하면 대입 가능
        int n = (int)d;

        // 실수를 정수로 강제 형 변환하면 소수가 버려진다.
        System.out.println("n: " + n);

        // 정수 2개의 평균을 실수로 구하고자 하는 경우
        int score1 = 91;
        int score2 = 90;

        double avg = (score1 + score2) / 2;
        System.out.println(avg);
    }
}
