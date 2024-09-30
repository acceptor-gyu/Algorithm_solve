package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PalindromeQuestionMark_10942 {

    private static int[][] dp;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N][N];
        numbers = new int[N];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], - 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int start;
        int end;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            sb.append(memorize(start - 1, end - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static int memorize(int start, int end) {

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // S와 E가 같으면 반드시 true
        if (start == end) {
            return dp[start][end] = 1;
        }

        // 2자리인 경우 처음과 다음이 같으면 true
        if (start + 1 == end) {
            if (numbers[start] == numbers[end]) {
                return dp[start][end] = 1;
            }
        }

        if (numbers[start] != numbers[end]) {
            return dp[start][end] = 0;
        }

        return dp[start][end] = memorize(start + 1, end - 1);
    }
}
