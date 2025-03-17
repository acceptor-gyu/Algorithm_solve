package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리2_17404 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 1_000 * 1_000;
        int answer = max;
        int[][] costs = new int[N][3];
        int[][] dp = new int[N][3];

        // 0->R   1->G   2->B
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int color = 0; color < 3; color++) {
            for (int selectedColor = 0; selectedColor < 3; selectedColor++) {
                if (color == selectedColor) {
                    dp[0][selectedColor] = costs[0][color];
                } else {
                    dp[0][selectedColor] = max;
                }
            }

            for (int row = 1; row < N; row++) {
                dp[row][0] = Math.min(dp[row - 1][1], dp[row - 1][2]) + costs[row][0];
                dp[row][1] = Math.min(dp[row - 1][2], dp[row - 1][0]) + costs[row][1];
                dp[row][2] = Math.min(dp[row - 1][0], dp[row - 1][1]) + costs[row][2];
            }

            for (int selectedColor = 0; selectedColor < 3; selectedColor++) {
                if (color != selectedColor) {
                    answer = Math.min(answer, dp[N - 1][selectedColor]);
                }
            }
        }
        System.out.println(answer);
    }
}
