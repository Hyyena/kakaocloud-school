package gmail.sjtxm0320.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesMain {
    public static void main(String[] args) {
        // 현재 디렉토리 위치
        File f = new File(("./"));
        System.out.println(f.getAbsolutePath());

        File file = new File("config.properties");

        try (FileInputStream fis = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(fis);
            System.out.println(properties.getProperty("password"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
