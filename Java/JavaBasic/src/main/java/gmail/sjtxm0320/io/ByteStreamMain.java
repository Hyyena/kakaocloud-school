package gmail.sjtxm0320.io;

public class ByteStreamMain {
    public static void main(String[] args) {
        /*
        // 버퍼 단위로 기록
        try
            (PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\user\\Documents\\", true))) {

            String msg = "Hello Stream";

            // write는 바이트 단위 기록
            ps.write(msg.getBytes());

            // print는 문자열을 스스로 바이트로 변환해서 기록
            ps.println(msg);
            ps.flush();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        try (BufferedInputStream bis = new BufferedInputStream(
            new FileInputStream("C:\\Users\\user\\Documents\\", true))) {
            while (true) {
                // 16 바이트 단위로 읽어오기
                // 일반적으로 128 또는 128의 배수를 많이 이용
                byte[] b = new byte[16];

                int len = bis.read(b, 0, b.length);

                if (len <= 0) {
                    break;
                }

                // 받을 내용을 가지고 작업
                // 다운로드라면 파일에 기록
                // 문자열이라면 하나로 모아서 읽어야 한다.
                System.out.println(new String(b));
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        */
    }
}
