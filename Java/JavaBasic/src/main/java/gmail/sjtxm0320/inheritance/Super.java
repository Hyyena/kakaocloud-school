package gmail.sjtxm0320.inheritance;

public class Super {
    protected String name;
    // 상속은 되지만 하위 클래스에서 접근 불가
    private int num;

    public Super() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Super [num = " + num + ", name = " + name + "]";
    }
}
