package gmail.sjtxm0320;

public class GoodMain {
    public static void main(String[] args) {
        // Singleton 확인
        GoodDAO dao1 = GoodDAOImpl.getInstance();
        GoodDAO dao2 = GoodDAOImpl.getInstance();

        System.out.println(System.identityHashCode(dao1));
        System.out.println(System.identityHashCode(dao1));

        // 전체 데이터 가져오기
        GoodDAO dao = GoodDAOImpl.getInstance();
        System.out.println(dao.getAll());

        // 기본키를 가지고 조회하면 존재하는 경우 데이터가 리턴
        // 없는 경우 null 리턴
        System.out.println(dao.getGood("1"));
        System.out.println(dao.getGood("20"));

        Good good = new Good();
        good.setCode("10");
        good.setName("과자");
        good.setManufacture("서울");
        good.setPrice(19);

        int r = dao.insertGood(good);
        if (r == 1) {
            System.out.println("Insert Success");
        } else {
            System.out.println("Insert Failure");
        }

        System.out.println(dao.likeGood("국"));
        System.out.println(dao.likeGood("단"));
    }
}
