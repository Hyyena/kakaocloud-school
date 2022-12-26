package gmail.sjtxm0320.network;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReductionOperator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("최예나", "김채원", "조유리", "노지선", "박지원", "송하영", "천현우");

        // 스트림 생성
        Stream<String> stream = list.stream();
        // stream.forEach((tmp) -> System.out.print(tmp + "\t"));

        // 2개 빼고 출력
        // stream.skip(2).forEach((tmp) -> System.out.print(tmp + "\t"));

        // 2개 건너뛰고 3개 사용
        // stream.skip(2).limit(3).forEach((tmp) -> System.out.print(tmp + "\t"));

        // 중복 제거
        // stream.distinct().forEach((tmp) -> System.out.print(tmp + "\t"));

        // 필터링
        // 매개변수가 1개이고, Boolean을 리턴하는 함수 대입
        // stream.filter(name -> name.charAt(0) == '최').forEach((tmp) -> System.out.print(tmp + "\t"));

        // ㅊ으로 시작하는
        stream.filter(name -> name.charAt(0) >= '차' && name.charAt(0) <= '카')
            .sorted().forEach((tmp) -> System.out.print(tmp + "\t"));
    }
}
