package gmail.sjtxm0320.oop;

public class MethodClass {
    public int score = 100;

    // static: 인스턴스를 생성할 필요가 없음
    // 매개변수가 없음
    // MethodClass.noArgsMethod()로 호출
    public static void noArgsMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println("noArgsMethod");
        }
    }

    // 매개변수가 정수 1개인 메서드
    // MethodClass.oneArgsMethod(3);
    public static void oneArgsMethod(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("oneArgsMethod");
        }
    }

    // 매개변수가 2개인 메서드
    // 매개변수가 2개 이상인 경우 순서대로 대입해야 한다.
    public static void twoArgsMethod(int n, String msg) {
        System.out.println(msg);
    }

    // 매개변수가 기본형 1개
    // 내부에서 매개변수의 값을 수정해도 넘겨준 데이터는 변경되지 않는다.
    public static void callByValue(int n) {
        n += 1;
        System.out.println("n: " + n);
    }

    // 매개변수가 참조형인 경우
    public static void callByReference(int[] arr) {
        arr[0] += 1;
        System.out.println("arr[0]: " + arr[0]);
    }

    // 리턴이 없는 메서드는 연속해서 호출하는 것이 불가능
    // 2개의 정수를 받아서 더해주는 메서드
    // 인스턴스.addWithInteger(정수1, 정수2)
    public int addWithInteger(int first, int second) {
        // 2개의 매개변수를 더한 결과 리턴
        return (first + second);
    }

    // 메서드 오버로딩
    public void display() {

    }

    // 매개변수의 개수가 달라서 오벼로딩
    public void display(int a) {

    }

    // 매개변수의 개수는 같지만 자료형이 달라서 오버로딩
    public void display(double a) {

    }

    public void thisMethod() {
        int score = 200;

        // scope의 법칙: 가까이에서 만든 것을 사용
        System.out.println("score: " + score); // 200

        // 인스턴스가 가진 score 호출
        // this가 붙으면 메서드 안에서 찾지 않는다.
        System.out.println("this.score: " + this.score);
    }
}
