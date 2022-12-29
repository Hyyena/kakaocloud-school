package gmail.sjtxm0320;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMain {
    public static void main(String[] args) {
        // 데이터 다운로드
        // 다운로드 받은 문자열을 저장하기 위한 변수
        String json = null;

        try {
            // 다운로드 받기 위한 URL 생성
            // 한글이 포함돼있으면 포함된 부분은 URLEncoder.encode 메서드를 이용해 인코딩 한 후 생성
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/");

            // URL 연결
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            // 옵션 설정
            con.setRequestMethod("GET"); // 요청 방식
            con.setConnectTimeout(30000); // 접속 요청 제한 시간
            con.setUseCaches(false); // 캐싱된 데이터 사용 여부

            // Kakao와 같은 Open API는 key를 요구하는 경우가 있는데,
            // 아래 코드를 추가하면 된다.
            // con.addRequestProperty(키이름, 키);

            // 문자열을 읽기 위한 스트림 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // 많은 양의 문자열 읽기
            StringBuilder sb = new StringBuilder();

            while (true) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                sb.append(line + "\n");
            }

            json = sb.toString();
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Failed to download data");
            System.exit(0); // 프로그램 종료
            // main 종료
        }

        // 다운로드 받은 데이터 파싱
        List<ToDoVO> list = new ArrayList<>();
        try {
            if (json == null) {
                // 전체 문자열을 배열로 변환
                JSONArray arr = new JSONArray(json);
                System.out.println(arr);

                // 배열 순회
                for (int i = 0; i < arr.length(); i++) {
                    // 배열의 요소를 JSON 객체로 가져오기
                    JSONObject obj = arr.getJSONObject(i);
                    System.out.println(obj);

                    ToDoVO vo = new ToDoVO();

                    // 객체를 key를 이용해 가져온다
                    vo.setUserId(obj.getInt("userId"));
                    vo.setId(obj.getInt("id"));
                    vo.setTitle(obj.getString("title"));
                    vo.setCompleted(obj.getBoolean("completed"));

                    list.add(vo);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to parsing");
            System.out.println(e.getLocalizedMessage());
        }

        // 파싱한 결과를 사용(출려)
        for (ToDoVO vo : list) {
            System.out.println(vo);
        }
    }
}
