package gmail.sjtxm0320.nestedclass;

public class Main {
    public static void main(String[] args) {
        // 외부 클래스의 인스턴스 생성
        InstanceInner instanceInner = new InstanceInner();

        // 내부 클래스의 인스턴스 생성 (Instance Inner인 경우)
        /*
        InstanceInner.Inner inner = instanceInner.new Inner();
         */

        // Static Inner Class의 인스턴스 생성
        InstanceInner.Inner obj = new InstanceInner.Inner();

        // 인스턴스 생성
        // 인스턴스를 만드는 경우 대부분 변수나
        // 상위 클래스나 인터페이스로 만들어진 변수에 하위 클래스의 인스턴스 참조를 대입할 수 있다.
        // 이렇게 만들어진 변수는 상위 클래스나 인터페이스에 존재하는 이름만 호출 가능하다.
        // 실제 호출되는 것은 생성자를 따라간다.
        SampleAble instance = new SampleAbleImpl();

        // 메서드 호출
        instance.method();

        // Anonymous Class 사용
        SampleAble anonymous = new SampleAble() {
            @Override
            public void method() {
                System.out.println("Anonymous 사용");
            }
        };

        // 메서드 호출
        anonymous.method();

        // 메서드를 한번만 호출할 거라면 변수를 생성하지 않고 가능
        new SampleAble() {
            @Override
            public void method() {
                System.out.println("변수 생성 없이 Anonymous 사용");
            }
        }.method();

        // public 클래스에 public static 속성은 어느곳에서나 호출 가능
        GlobalData.global = 10;

        Singleton singleton1 = Singleton.sharedInstance();
        Singleton singleton2 = Singleton.sharedInstance();

        // 해시코드 확인
        System.out.println(System.identityHashCode(singleton1));
        System.out.println(System.identityHashCode(singleton2));

        Table row1 = new Table();
        System.out.println(row1.getNum());

        Table row2 = new Table();
        System.out.println(row2.getNum());
    }
}
