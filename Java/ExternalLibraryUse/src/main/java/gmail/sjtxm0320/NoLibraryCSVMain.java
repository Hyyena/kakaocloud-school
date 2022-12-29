package gmail.sjtxm0320;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoLibraryCSVMain {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("sample/girlgroups.csv")))) {
            // 파일의 경로 확인을 위해서 작성
            System.out.println(br);

            // 첫 줄은 데이터가 아니므로 첫 줄을 배제하기 위한 변수
            boolean flag = false;

            // 파싱한 결과를 저장하기 위한 List
            List<Member> list = new ArrayList<>();
            while (true) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                // 첫 줄을 읽지 않기 위함
                if (!flag) {
                    flag = true;
                    continue;
                }

                System.out.println(line);

                // , 단위로 분할
                String[] arr = line.split(",");
                System.out.println(arr[0]);

                Member member = new Member();
                member.setName(arr[0]);
                member.setAge(Integer.parseInt(arr[1]));

                String birth = arr[2];

                // 위의 문자열을 Date 타입으로 변환해서 대입
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(birth);
                member.setBirth(date);

                member.setEmail(arr[3]);
                member.setNickname(arr[4]);

                // 리스트에 추가
                list.add(member);
            }

            for (Member member : list) {
                System.out.println(member);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
