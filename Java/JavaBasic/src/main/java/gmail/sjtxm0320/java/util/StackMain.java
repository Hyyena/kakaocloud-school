package gmail.sjtxm0320.java.util;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 스택에 데이터 추가
        stack.push("최예나");
        stack.push("김채원");
        stack.push("조유리");
        stack.push("노지선");

        // 데이터는 List처럼 순차적으로 삽입
        System.out.println(stack);

        // pop을 하면 가장 마지막에 삽입된 데이터를 삭제하면서 리턴
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
