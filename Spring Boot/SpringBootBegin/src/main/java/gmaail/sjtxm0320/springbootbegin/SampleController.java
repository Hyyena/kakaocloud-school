package gmaail.sjtxm0320.springbootbegin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// View 대신 문자열(csv)이나 JSON을 리턴하는 컨트롤러를 만들고자 할 떄 사용하는 어노테이션
@RestController
public class SampleController {
    // hello라는 요청을 GET 방식으로 요청한 경우
    @GetMapping("/hello")
    // String을 리턴하면 일반 문자열로 출력
    // VO나 List를 리턴하면 JSON 문자열로 출력
    public String[] hello() {
        return new String[] {"STS", "IntelliJ"};
    }
}
