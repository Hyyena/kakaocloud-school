package gmail.sjtxm0320;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MariaDB {
    public static void main(String[] args) {
        // 데이터베이스 접속에 필요한 정보 불러오기
        String driver = null;
        String url = null;
        String id = null;
        String password = null;

        // 읽어올 파일 생성
        File file = new File("/properties/db.properties");

        try (FileInputStream is = new FileInputStream(file)) {
            // 파일의 내용을 properties에 저장
            Properties properties = new Properties();
            properties.load(is);

            // 읽어온 내용을 변수에 저장
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            id = properties.getProperty("id");
            password = properties.getProperty("password");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        /*
         * 1. 데이터베이스 드라이버 로드
         * 드라이버 의존성을 설정하지 않거나 클래스 이름이 틀리면 예외 발생
         */
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Loaded Driver");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        // 2. 데이터베이스 접속 (java.sql.Connection)
        try (Connection con = DriverManager.getConnection(url, id, password)) {
            System.out.println(con);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
