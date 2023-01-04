package gmail.sjtxm0320;

import org.springframework.context.support.GenericXmlApplicationContext;

import domain.Item;

public class Main {

	public static void main(String[] args) {
		//ItemRepository itemRepository = new ItemRepository();
		
		//인스턴스 생성을 다른 팩토리 클래스를 이용해서 생성
		//다른 클래스의 메서드를 이용해서 인스턴스를 생성하는 것을
		//Factory Method Pattern 이라고 합니다.
		//ItemRepository itemRepository = RepositoryFactory.create();
		
		//스프링이 인스턴스를 생성 - 어노테이션을 이용한 생성
		/*
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(
						RepositoryFactory.class);
				//RepositoryFactory 클래스의 create 메서드를 호출해서
		//ItemRepository 클래스의 인스턴스를 생성
		ItemRepository itemRepository = 
				context.getBean("create", ItemRepository.class);
		Item item = itemRepository.get();
		System.out.println(item);
		ItemRepository itemRepository1 = 
				context.getBean("create", ItemRepository.class);
		//스프링은 싱글톤 패턴으로 생성하므로 2개의 해시코드는 일치
		System.out.println(System.identityHashCode(itemRepository));
		System.out.println(System.identityHashCode(itemRepository1));
		
		context.close();
						*/
		
		//XML을 이용한 bean 생성
		try(GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(
					"applicationContext.xml")){
			//bean 태그의 id 와 클래스 이름을 기재
			/*
			ItemRepository itemRepository = 
					context.getBean("itemRepository",
							ItemRepository.class);
			Item item = itemRepository.get();
			System.out.println(item);
			*/
			
			Item item = context.getBean("item", Item.class);
			System.out.println(item);
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
