package gmail.sjtxm0320;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void testMethod1() {
        System.out.println(new Source().add(100, 200));
    }

    @Test
    public void testMethod2() {
        Source source = new Source();

        // 메서드의 수행 결과 찾아오기
        int result = source.add(200, 300);

        // 기댓값과 비교
        // 일치하면 정상 수행
        // 일치하지 않으면 예외 발생
        Assertions.assertEquals(result, 500);
    }
}
