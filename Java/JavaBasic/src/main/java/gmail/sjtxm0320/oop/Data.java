package gmail.sjtxm0320.oop;

public class Data {
    private static int sequence;

    static {
        sequence = 0;
    }

    private final int num;
    private String name;

    public Data() {
        super();

        // sequence를 1 증가시킨 후 num에 대입
        num = ++sequence;
    }

    public Data(String name) {
        super();
        this.num = ++sequence;
        this.name = name;
    }
}
