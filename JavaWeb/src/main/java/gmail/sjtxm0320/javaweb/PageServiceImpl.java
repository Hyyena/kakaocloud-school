package gmail.sjtxm0320.javaweb;

public class PageServiceImpl implements PageService {
    // Java이면 싱글톤 패턴 작성 코드를 추가(Spring에서는 불필요)

    @Override
    public int add(int first, int second) {
        return first + second;
    }
}
