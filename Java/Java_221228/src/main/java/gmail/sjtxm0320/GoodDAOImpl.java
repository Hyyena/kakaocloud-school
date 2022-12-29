package gmail.sjtxm0320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodDAOImpl implements GoodDAO {
    // 참조를 저장할 변수를 static으로 설정
    private static GoodDAO goodDAO;

    // static 초기화(클래스가 로드될 때 한 번만 수행)
    // static 속성만 사용 가능
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Laded Driver");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private Connection connection; // 데이터베이스 연결
    private PreparedStatement pstmt; // sql 실행
    private ResultSet rs; // select 구문의 결과

    // 초기화(생성자를 호출할 때마다 먼저 호출됨)
    // 이 영역은 init이라는 메서드로 생성
    // 모든 속성 사용이 가능
    {
        // 데이터베이스 접속 (java.sql.Connection)
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hyyena", "root", "3359");
            System.out.println(connection);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // Singletone을 만들기 위한 코드(중요하지 않음)
    // 외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설계
    private GoodDAOImpl() {
    }

    // 변수가 null이면 생성 후 리턴, null이 아니면 바로 리턴
    public static GoodDAO getInstance() {
        if (goodDAO == null) {
            goodDAO = new GoodDAOImpl();
        }
        return goodDAO;
    }

    @Override
    public List<Good> getAll() {
        // List는 조회할 데이터가 없더라도 인스턴스를 생성
        // 조회할 데이터가 없다는 사실은 size()가 0이다.
        List<Good> list = new ArrayList<>();

        try {
            // SQL 실행 클래스의 인스턴스를 생성
            pstmt = connection.prepareStatement("select * from goods");

            // SQL 실행
            rs = pstmt.executeQuery();

            // 데이터를 하나의 행 씩 읽어서 DTO 객체로 변환해서 list에 대입
            while (rs.next()) {
                Good good = new Good();

                good.setCode(rs.getString("code"));
                good.setName(rs.getString("name"));
                good.setManufacture(rs.getString("manufacture"));
                good.setPrice(rs.getInt("price"));

                list.add(good);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return list;
    }

    // goods 테이블에서 code를 가지고 데이터 조회
    public Good getGood(String code) {
        // 조회가 안 된 경우 null
        Good good = null;

        try {
            pstmt = connection.prepareStatement("select * from goods where code =?");

            // ?에 바인딩
            // ?에 바인딩할 인덱스는 1부터 시작
            pstmt.setString(1, code);

            rs = pstmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return good;
    }

    @Override
    public List<Good> likeGood(String content) {
        List<Good> list = new ArrayList<>();

        try {
            pstmt = connection.prepareStatement("select * from goods " + "where name like ? or manufacture like ?");

            pstmt.setString(1, "%" + content + "%");
            pstmt.setString(2, "%" + content + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Good good = new Good();
                good.setCode(rs.getString("code"));
                good.setName(rs.getString("name"));
                good.setManufacture(rs.getString("manufacture"));
                good.setPrice(rs.getInt("price"));
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return list;
    }

    @Override
    public int insertGood(Good good) {
        int result = 0;

        // 삽입 작업이르모 트랜잭션 고려
        try {
            connection.setAutoCommit(false);

            pstmt = connection.prepareStatement("insert into goods values(?, ?, ?, ?)");

            pstmt.setString(1, good.getCode());
            pstmt.setString(2, good.getName());
            pstmt.setString(2, good.getManufacture());
            pstmt.setInt(4, good.getPrice());

            result = pstmt.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            try {
                connection.rollback();
            } catch (Exception exception) {
            }
            e.printStackTrace();
        }

        return result;
    }
}
