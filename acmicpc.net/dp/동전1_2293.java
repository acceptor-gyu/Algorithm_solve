package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모든 금액을 만들어간다.
 *
 */
public class 동전1_2293 {

    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            dp[i + 1][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k ; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
