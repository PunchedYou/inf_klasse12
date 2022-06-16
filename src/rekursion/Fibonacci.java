package rekursion;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(10));
    }

    public int fib(int n) {
        if (n <= 1) {
            if (n == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
