package gmail.sjtxm0320.springsecurity.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class CustomSecurityConfigTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String passowrd = "1111";
        String enPw = passwordEncoder.encode(passowrd);
        System.out.println("enPw: " + enPw);

        // 동일한 비밀번호이지만 인코딩 시 매번 다른 Hashing 기법을 사용
        enPw = passwordEncoder.encode(passowrd);
        System.out.println("enPw: " + enPw);

        boolean result = passwordEncoder.matches(passowrd, enPw);
        System.out.println("result: " + result);
    }
}
