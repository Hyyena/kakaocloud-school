package gmail.sjtxm0320.persistence;

// 인스턴스를 생성해주는 Factory 클래스
public class RepositoryFactory {
    // create 대신 newInstance를 사용해도 같은 의미
    // 매번 인스턴스를 생성해서 제공
    public static ItemRepository create() {
        return new ItemRepository();
    }
}
