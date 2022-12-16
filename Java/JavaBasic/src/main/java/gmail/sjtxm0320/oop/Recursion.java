package gmail.sjtxm0320.oop;

public class Recursion {
    public static int recursionFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursionFibonacci(n - 1) + recursionFibonacci(n - 2);
    }
}
