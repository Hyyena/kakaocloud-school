package gmail.sjtxm0320.aopandsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import gmail.sjtxm0320.aopandsecurity.aop.MeasuringInterceptor;
import lombok.extern.log4j.Log4j2;

// 웹 설정 클래스
@Configuration
@Log4j2
public class WebMvcConfig implements WebMvcConfigurer {
    // 인터셉터 설정 메서드
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.warn("설정 확인");
        // 인터셉터가 적용될 URL
        registry.addInterceptor(new MeasuringInterceptor()).addPathPatterns("/user");
    }
}
