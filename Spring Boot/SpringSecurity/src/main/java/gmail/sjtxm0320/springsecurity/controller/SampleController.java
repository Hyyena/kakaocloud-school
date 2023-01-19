package gmail.sjtxm0320.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/")
    public String index() {
        log.info("Main");
        return "/index";
    }

    @GetMapping("/sample/all")
    public void main() {
        log.info("모두 허용");
    }

    // 로그인 한 유저만 접속 가능
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/sample/member")
    public void member() {
        log.info("멤버만 허용");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/sample/admin")
    public void admin() {
        log.info("관리자만 허용");
    }
}
