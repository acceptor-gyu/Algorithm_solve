package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2_9252 {

    private static char[] string1;
    private static char[] string2;
    private static int[][] dp;
    private static StringBuilder sb;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        string1 = br.readLine().toCharArray();
        string2 = br.readLine().toCharArray();

        dp = new int[string1.length + 1][string2.length + 1];

        for (int i = 0; i < string1.length; i++) {
            for (int j = 0; j < string2.length; j++) {
                if (string1[i] == string2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        sb = new StringBuilder();
        answer = 0;
        countAndMakeString(string1.length, string2.length);

        System.out.println(answer);
        System.out.println(sb.toString());
    }

    private static void countAndMakeString(int i, int j) {

        if (dp[i][j] == 0) {
            return;
        }

        if (string1[i - 1] == string2[j - 1]) {
            countAndMakeString(i - 1, j - 1);
            sb.append(string1[i - 1]);
            answer++;
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                countAndMakeString(i - 1, j);
            } else {
                countAndMakeString(i, j - 1);
            }
        }
    }

}
