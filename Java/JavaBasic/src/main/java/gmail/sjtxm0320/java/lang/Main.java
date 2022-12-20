package gmail.sjtxm0320.java.lang;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        String[] nicknames = {"최예나", "김채원"};

        // 인스턴스 생성
        Data original = new Data(1, "hyyena", nicknames);

        // 인스턴스의 참조 복사
        // 참조 대상이나 원본이 내부 데이터를 변경하면 영향을 준다.
        Data data = original;
        System.out.println(original);

        // 참조를 복사한 경우 data의 변경이 곧 original의 변경이 된다.
        data.setNum(2);
        System.out.println(original);

        // 자바는 복제를 이용하고자 하는 경우 clone의 메서드를 재정의 해야 한다.
        // 재정의 할 때, Cloneable 인터페이스를 implements 하는 것을 권장
        Data copy = original.clone();
        System.out.println(original);
        copy.setNum(3);
        System.out.println(original);
        String[] names = copy.getNicknames();
        names[0] = "yena";
        System.out.println(original);

        Data data1 = new Data(1, "유연", null);
        Data data2 = new Data(1, "유연", null);

        // ==는 참조를 비교하는 연산자
        // 2개의 인스턴스는 각각 생성자를 호출해서 만들기 때문에 참조가 다르다.
        // 내용이 같은지 확인하고자 할 때는 equals 메서드를 재정의해서 사용
        System.out.println(data1 == data2);
        System.out.println(data1.equals(data2));

        // Wrapper 클래스 사용
        Double d = new Double(13.67);

        // 기본형을 대입하면 new Double(17.23)으로 변환
        d = 17.23;

        // toString이 재정의되어 있으므로 출력은 참조로 가능
        System.out.println(d);

        // 기본형 데이터로 변환
        double x = d;
        System.out.println(x);

        double d1 = 1.6000000000000000;
        double d2 = 0.1000000000000000;
        System.out.println(d1 + d2); // 1.7이 아님

        // 정확한 산술 연산
        // BigDecimal로 데이터를 만들고, 연산을 수행하는 메서드를 호출하면 정확한 결과를 만들 수 있다.
        BigDecimal b1 = new BigDecimal("1.6000000000000000");
        BigDecimal b2 = new BigDecimal("0.1000000000000000");
        System.out.println(b1.add(b2)); // 1.7

        String str = "Hello";
        System.out.println(System.identityHashCode(str));

        // String은 데이터 수정아 안되기 때문에
        // 새로운 공간에 기존 문자열을 복사 후 작업을 수행하고, 그 참조를 다시 리턴
        // 기존의 데이터가 저장된 공간은 메모리 낭비가 될 수 있다.
        str += "Java";
        System.out.println(System.identityHashCode(str));

        // StringBuilder는 변경 가능한 문자열을 저장할 수 있다.
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(System.identityHashCode(sb));

        // 문자열을 추가하면 현재 저장된 공간에 이어붙이기를 수행
        sb.append("Java");

        // 해시코드가 이전 데이터와 동일
        System.out.println(System.identityHashCode(sb));

        // 여러 데이터를 가지고 하나의 문자열 생성
        double lat = 12.789;
        double lng = 24.2987;

        // 위의 데이터를 가지고 위도: 12.789, 경도: 24.289 문자열로 생성
        String msg = String.format("위도: %.3f 경도: %.3f\n", lat, lng);
        System.out.println(msg);

        String str1 = "하이";

        try {
            // 바이트 배열로 문자열 변환
            // 동일한 프로그램이 아닌 시스템과 채팅을 할 때는 문자열을 직접 전송하지 않고 바이트 배열을 만들어 전송
            byte[] bytes = str1.getBytes("MS949");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        // 운영체제 이름 가져오기
        String os = System.getProperty("os.name");

        // 자바 버전 확인
        String version = System.getProperty("java.version");
        System.out.println(os);
        System.out.println(version);

        // 코드 수행시간 측정
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
        }

        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

        // Runtime 클래스의 인스턴스 생성
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();

        // Singleton 패턴으로 디자인돼서 해시코드가 동일
        System.out.println(System.identityHashCode(r1));
        System.out.println(System.identityHashCode(r2));

        // 프로세스 실행
        // Mac은 open 파일경로 형태로 입력
        // Windows는 프로세스 이름만 사용하면 된다.
        // try {
        //     r1.exec("notepad");
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }

        // 기본값인 0을 가지고 1000000개의 데이터를 가진 배열 생성
        // int[] arr = new int[1000000];
        //
        // long start1 = System.currentTimeMillis();
        //
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        //
        // long end1 = System.currentTimeMillis();
        //
        // System.out.println((end1 - start1) + "ms");

        // Generics가 적용된 클래스의 인스턴스를 만들 때는 실제 자료형을 결정지어야 경고가 발생하지 않는다.
        Generic<String> obj1 = new Generic<>("최예나", "김채원", "조유리");
        obj1.disp();

        // 기본형은 Generics에 적용할 수 없다.
        // Generic<int> obj2 = new Generic<>();

        // 옵션 사용을 위해 예전에는 final 상수를 이용
        final int MAN = 0;
        final int WOMAN = 1;

        // int로 만들면 아래와 같이 정의하지 않은 값을 대입하는 게 가능
        int gender = MAN;
        gender = 3;

        // Gender가 enum이므로 Gender.MAN이나 Gender.WOMAN만 가능
        Gender t = Gender.MAN;
    }

    enum Gender {
        MAN, WOMAN,
    }
}
