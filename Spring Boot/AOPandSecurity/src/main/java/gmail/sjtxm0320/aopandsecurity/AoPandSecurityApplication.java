package gmail.sjtxm0320.aopandsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AoPandSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AoPandSecurityApplication.class, args);
    }

}
