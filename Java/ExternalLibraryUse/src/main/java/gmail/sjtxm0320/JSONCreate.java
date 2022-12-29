package gmail.sjtxm0320;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONCreate {
    public static void main(String[] args) {
        ToDoVO vo1 = new ToDoVO(1, 1, "예나", true);
        ToDoVO vo2 = new ToDoVO(2, 11, "채원", false);

        // 저장할 JSON 파일 생성
        File file = new File("sample/todo.json");

        // JSON 기록을 위한 인스턴스 생성
        ObjectMapper mapper = new ObjectMapper();

        try {
            // 기록
            mapper.writeValue(file, Arrays.asList(vo1, vo2));
        } catch (Exception e) {
            System.out.println("Failed to write down");
        }
    }
}
