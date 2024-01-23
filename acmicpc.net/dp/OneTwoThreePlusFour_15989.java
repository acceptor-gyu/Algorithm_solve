package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreePlusFour_15989 {

    public static void main(String[] args) throws IOException {

        // dp[1][N]: dp[1][N-1]
        // dp[2][N]: dp[1][N-2] + dp[2][N - 2] (N - 2의 1로 끝나는 경우 + 2로 끝나는 경우)
        // dp[3][N]: dp[1][N-3] + dp[2][N-3] + dp[3][N-3] (N - 3의 1로 끝나는 경우 + 2로 끝나는 경우 + 3으로 끝나는 경우)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 10001;

        int[][] dp = new int[4][max];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[2][2] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < max; i++) {
            dp[1][i] = dp[1][i - 1];
            dp[2][i] = dp[1][i - 2] + dp[2][i - 2];
            dp[3][i] = dp[1][i - 3] + dp[2][i - 3] + dp[3][i - 3];
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[1][n] + dp[2][n] + dp[3][n]).append("\n");
        }

        System.out.println(sb);
    }
}
