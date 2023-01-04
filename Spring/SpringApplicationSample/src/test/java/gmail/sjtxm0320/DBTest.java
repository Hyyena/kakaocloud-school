package gmail.sjtxm0320;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class DBTest {
    @Test
    public void testConnection() {
        try {
            // 예외 발생 시 이름을 틀렸거나 의존성 설정이 잘못된 것
            Class.forName("org.mariadb.jdbc.Driver");
            
            // 연결
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hyyena", "root", "3359");
            System.out.println(con);
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
