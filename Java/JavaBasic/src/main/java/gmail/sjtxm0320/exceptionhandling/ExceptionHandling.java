package gmail.sjtxm0320.exceptionhandling;

public class ExceptionHandling {
    public static void main(String[] args) {
        int i = 0;
        int j = 4;
        try {
            System.out.println(i / j);

            // catch가 여러 개이면 일치하는 catch 블럭의 내용을 처리하고, 다른 catch는 모두 pass

            // 상위 클래스의 참조형 변수에는 하위 클래스 인스턴스 참조를 저장할 수 있기 때문에
            // catch를 여러 개 작성할 때 주의해야 한다.

            // 상위 클래스의 예외처리 구문을 먼저 만들고,
            // 아래에 하위 클래스의 예외처리 구문을 만들면 컴파일 에러
            // 아래 외예 처리 구문이 Dead Code가 된다.
        } // catch (Exception e) {}
        catch (NullPointerException e) {
            System.out.println("NULL이 속성이나 메서드를 호출하면 예외 발생");
        } catch (ArithmeticException e) {
            // 예외가 발생했을 때 수행할 내용
            // 예외가 발생하지 않으면 수행되지 않는다.
            System.out.println("0으로 나눌 수 없습니다.");
        } finally {
            // 예외 발생 여부에 상관없이 수행
            System.out.println("예외 발생 여부에 상관없이 수행");
        }
    }
}
