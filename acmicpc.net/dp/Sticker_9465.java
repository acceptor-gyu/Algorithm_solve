package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker_9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());

            // 각 행, 열에 주어진 점수
            int[][] score = new int[2][n];

            // 메모할 것: N번 째 열에서 최대 점수
            int[][] dp = new int[2][n];

            StringTokenizer firstRowSt = new StringTokenizer(br.readLine());
            StringTokenizer secondRowSt = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                score[0][j] = Integer.parseInt(firstRowSt.nextToken());
                score[1][j] = Integer.parseInt(secondRowSt.nextToken());
            }

            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];

            int max = Math.max(dp[0][0], dp[1][0]);

            for (int j = 1; j < n; j++) {

                if (j == 1) {
                    dp[0][j] = dp[1][j - 1] + score[0][j];
                    dp[1][j] = dp[0][j - 1] + score[1][j];

                    max = Math.max(dp[0][j], dp[1][j]);
                    continue;
                }

                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + score[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + score[1][j];

                max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
