package gmail.sjtxm0320.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// JPA의 변화를 감시하겠다는 Annotation
@EnableJpaAuditing
public class GuestBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestBookApplication.class, args);
    }

}
