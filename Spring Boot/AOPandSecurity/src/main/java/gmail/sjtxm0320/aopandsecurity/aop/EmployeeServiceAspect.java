package gmail.sjtxm0320.aopandsecurity.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
// bean을 자동으로 생성해주는 Annotation
// Controller, Service, Repository, RestController, Configuration
@Component
public class EmployeeServiceAspect {
    @Before(value = "execution(* gmail.sjtxm0320.aopandsecurity.service.EmployeeService.*(..)) and args(empId, firstName, secondName)")
    public void beforeAdvice(JoinPoint joinPoint, String empId, String firstName, String secondName) {
        System.out.println("메서드를 호출하기 전에 호출");
    }

    @After(value = "execution(* gmail.sjtxm0320.aopandsecurity.service.EmployeeService.*(..)) and args(empId, firstName, secondName)")
    public void afterAdvice(JoinPoint joinPoint, String empId, String firstName, String secondName) {
        System.out.println("메서드를 호출하여 수행한 후 호출");
    }
}
