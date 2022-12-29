package gmail.sjtxm0320;

public class Main {
    public static void main(String[] args) {
        // MySQL 드라이버 로딩
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
