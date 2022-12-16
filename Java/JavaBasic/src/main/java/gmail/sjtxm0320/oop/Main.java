package gmail.sjtxm0320.oop;

public class Main {
    public static void main(String[] args) {
        /*
        // Student 클래스의 인스턴스 생성
        Student student = new Student();

        // 자신의 속성에 접근
        student.num = 1;
        student.name = "예나";
        student.kor = 25;
        student.eng = 19;
        student.mat = 40;

        Student student1 = new Student();
        student1.num = 2;
        
        // 인스턴스 속성은 인스턴스별로 별도로 소유
        System.out.println(student.num);
        System.out.println(student1.num);

        // Java는 static 속성에 인스턴스가 접근 가능하다.
        student.schoolName = "명덕고등학교";
        student1.schoolName = "제일중학교";

        // static 속성은 모든 인스턴스가 공유하므로 동일한 데이터가 출력된다.
        System.out.println(student.schoolName);
        System.out.println(student1.schoolName);

        // static method는 클래스 이름으로 호출 가능
        MethodClass.method1();

        // 클래스 이름을 가지고 메서드 호출 불가능
        // MethodClass.method2();

        // 인스턴스 메서드 호출
        MethodClass methodClass = new MethodClass();
        methodClass.method2();

        // 자바는 인스턴스를 이용해서 static 메서드 호출 가능
        MethodClass.method1();

        // 참조형 변수를 만들지 않고, 인스턴스를 만들어서 메서드 호출
        // 한 번만 사용하는 인스턴스는 이름을 만들지 않는 것이 좋다.
        new MethodClass().method2();
        */

        MethodClass.noArgsMethod();
        MethodClass.oneArgsMethod(3);
        MethodClass.twoArgsMethod(2, "Message");

        MethodClass obj = new MethodClass();
        int result = obj.addWithInteger(10, 30);
        System.out.println("Result: " + result);

        int x = 10;
        MethodClass.callByValue(x);
        System.out.println("x: " + x);

        int[] brr = {10, 20, 30};
        MethodClass.callByReference(brr);
        // 배열을 메서드에게 넘기면 배열의 내용이 변경될 수도 있다.
        // 메서드의 리턴이 없는 경우, pring 메서드를 제외하고 원본을 변경해주는 것이다.
        System.out.println("brr[0]: " + brr[0]);
    }
}
