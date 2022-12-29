package gmail.sjtxm0320.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student(1, "최예나", "여자", "컴퓨터공학과", 80),
            new Student(2, "김채원", "여자", "기계공학과", 92),
            new Student(3, "조유리", "여자", "컴퓨터공학과", 87),
            new Student(4, "노지선", "여자", "컴퓨터공학과", 85),
            new Student(5, "박지원", "여자", "전자공학과", 78));

        list.stream()
            .peek(word -> System.out.println(word))
            .mapToInt(Student::getScore)
            .sum();

        // 여자만 추출해서 List로 변환
        List<Student> womanList = list.stream()
            .filter(student -> student.getGender().equals("여자")).collect(Collectors.toList());

        System.out.println(womanList);

        // gender별로 그룹화해서 score의 평균 구하기
        Map<String, Double> genderMap = list.stream()
            .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getScore)));

        System.out.println(genderMap);
        System.out.println(genderMap.get("여자"));
    }
}
