package gmail.sjtxm0320.controlstatement;

public class While {
    public static void main(String[] args) {
        // 데이터를 가지고 배열 생성
        String[] fromis = {"노지선", "박지원", "송하영"};

        // 배열의 데이터 순회
        int len = fromis.length;

        for (int i = 0; i < len; i++) {
            String tmp = fromis[i];
            System.out.println(tmp);
        }
    }
}
