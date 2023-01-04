package gmail.sjtxm0320;

import gmail.sjtxm0320.domain.Item;
import gmail.sjtxm0320.persistence.ItemRepository;

public class Main {
    public static void main(String[] args) {
        // 다른 패키지에서 인스턴스를 생성하지 못하도록 했기 때문에 에러가 난다.
        ItemRepository itemRepository = new ItemRepository();

        // 인스턴스 생성을 다른 팩토리 클래스를 이용해서 생성
        // 다른 클래스의 메서드를 이용해서 인스턴스를 생성하는 것을
        // Factory Method Pattern이라고 한다.
        // ItemRepository itemRepository = RepositoryFactory.create();

        // 스프링이 인스턴스를 생성
        // ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryFactory.class);

        // RepositoryFactory클래스의 create 메서드를 호출해서
        // ItemRepository 클래스의 인스턴스를 생성
        // ItemRepository itemRepository = context.getBean("create", ItemRepository.class);

        Item item = itemRepository.get();
        System.out.println(item);

        // ItemRepository itemRepository1 = context.getBean("create", ItemRepository.class);

        // 스프링은 싱글톤 패턴으로 생성하므로 2개의 해시코드는 일치
        System.out.println(System.identityHashCode(itemRepository));
        // System.out.println(System.identityHashCode(itemRepository1));

        // context.close();
    }
}
