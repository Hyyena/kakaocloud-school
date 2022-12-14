package gmail.sjtxm0320.operator;

public class ShiftOperator {
    public static void main(String[] args) {
        int x = -29;

        System.out.println(x << 2); // 한 번 밀 때마다 2 곱하기
        System.out.println(x >> 3); // 한 번 밀 때마다 2 나누기
        System.out.println(x >>> 3); // 부호 변경
        System.out.println(x << 33);
        
        // 32로 나눈 나머지만큼 밀기
    }
}
