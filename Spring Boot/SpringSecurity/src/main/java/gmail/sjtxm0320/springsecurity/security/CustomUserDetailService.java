package gmail.sjtxm0320.springsecurity.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    // 아이디를 입력하고 로그인 요청을 하게 되면, 아이디에 해당하는 데이터를 찾아오는 메서드
    // 로그인 처리를 해주어야 한다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + username);

        // 로그인에 성공한 경우 생성
        // 실제로는 데이터베이스에서 읽어서 설정해야 한다.
        UserDetails userDetails = User.builder()
            .username("hyyena")
            .password(passwordEncoder.encode("1111"))
            .authorities("ROLE_USER")
            .build();

        return userDetails;
    }
}
