package gmail.sjtxm0320.springdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class DBTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() {
        try {
            System.out.println(dataSource);
            Connection con = dataSource.getConnection();

            // 예외 발생 시 이름을 틀렸거나 의존성 설정이 잘못된 것
            // Class.forName("org.mariadb.jdbc.Driver");

            // 연결
            // Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hyyena", "root", "3359");

            System.out.println(con);
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
