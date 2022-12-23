package gmail.sjtxm0320.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableMain {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sample.dat", true))) {
            // 기록할 인스턴스 생성
            Data data = new Data(1, "Hyyena", "최예나");
            oos.writeObject(data);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample.dat"))) {
            // 기록할 인스턴스 생성
            Data data = new Data(1, "Hyyena", "최예나");
            System.out.println(data);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
