package gmail.sjtxm0320.datatype;

public class FormatDisplay {
    public static void main(String[] args) {
        int n = 37;
        double d = 23.768952;
        String name1 = "hyyena";
        String name2 = "yena";

        System.out.printf("n:%d\n", n);

        // 10자리를 확보해서 출력
        System.out.printf("n:%10d\n", n);

        // 남는 자리는 0을 추가해서 출력
        System.out.printf("n:%010d\n", n);

        // 소수 6번째 자리까지 출력
        System.out.printf("d:%f\n", d);

        // 소수 3번째 자리까지 출력
        System.out.printf("d:%.3f\n", d);

        // %s는 문자열을 출력하는 것이 아니다.
        // 원래 %s는 시작 위치부터 바이트 단위로 데이터를 가져와서
        // 문자로 변환 후 출력하는 것으로 null을 만날때까지 출력
        System.out.printf("name1:%10s\n", name1);
        System.out.printf("name2:%10s\n", name2);
    }
}
