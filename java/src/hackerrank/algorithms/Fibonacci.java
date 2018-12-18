package hackerrank.algorithms;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 40;
//        int fib = fibonacci(n);
//        System.out.println(fib);
        int fib = fibonacci(n, new int[n + 1]);
        System.out.println(fib);
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static int fibonacci(int n, int[] memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] == 0) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        }
        return memo[n];
    }
}
