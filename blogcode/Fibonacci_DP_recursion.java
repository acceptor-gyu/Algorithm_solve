import java.util.Arrays;

public class Fibonacci_DP_recursion {
    // 1, 1, 2, 3, 5, 8, 13, 21, ...

    private static long cnt = 0;
    private static long[] dp = new long[51];
    private static long fibo(int n) {

        cnt++;

        if (dp[n] > 0) {
            return dp[n];
        }

        if (n <= 2) {
            return dp[n] = 1;
        }

        return dp[n] = fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("fibo(50): " + fibo(50));
        System.out.println("answers: " + Arrays.toString(dp));
        System.out.println("cnt: " + cnt);
    }
}
