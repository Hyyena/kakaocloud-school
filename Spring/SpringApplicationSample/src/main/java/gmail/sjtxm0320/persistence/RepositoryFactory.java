package gmail.sjtxm0320.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//인스턴스를 생성해주는 Factory 클래스
//팩토리 클래스 라는 어노테이션
@Configuration
public class RepositoryFactory {
	//create 대신에 newInstance 사용해도 같은 의미
	//매번 인스턴스를 생성해서 제공
	//인스턴스를 만들어주는 메서드
	@Bean
	public static ItemRepository create() {
		return new ItemRepository();
	}
}
