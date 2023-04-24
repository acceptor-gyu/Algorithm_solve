import java.util.Arrays;

public class Fibonacci_DP_for {
    // 1, 1, 2, 3, 5, 8, 13, 21, ...

    private static long[] dp = new long[51];

    public static void main(String[] args) {

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= 50; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[50]);
        System.out.println("answers: " + Arrays.toString(dp));
    }
}
