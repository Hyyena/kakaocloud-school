package gmail.sjtxm0320.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class KakaoBookSearch {
    public static void main(String[] args) {
        // 카카오 도서 검색 API
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Connection 만들기
                try {
                    // url 만들기
                    // GET 방식에서 파라미터는 반드시 인코딩돼야 한다.
                    String address = "http://dapi.kakao.com/v3/search/book?target=title";
                    address += "&query=";
                    address += URLEncoder.encode("오늘도 개발자가 안 된다고 말했다", StandardCharsets.UTF_8);

                    URL url = new URL(address);

                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    con.setConnectTimeout(30000);
                    con.setUseCaches(false);
                    con.setRequestMethod("GET");

                    // 키 설정
                    con.setRequestProperty("Authorization", "KakaoAK REST_API_KEY");

                    // 데이터 읽어오기
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    StringBuilder sb = new StringBuilder();

                    while (true) {
                        String tmp = br.readLine();

                        if (tmp == null) {
                            break;
                        }

                        sb.append(tmp + "\r\n");
                    }
                    String result = sb.toString();
                    System.out.println(result);

                    br.close();
                    con.disconnect();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }).start();
    }
}
