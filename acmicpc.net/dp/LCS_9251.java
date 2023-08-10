package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {

    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] result = lcs(str1, str2);

        int max = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                max = Math.max(max, result[i][j]);
            }
        }

        count += max;

        System.out.println(count);
    }

    public static int[][] lcs(char[] str1, char[] str2) {

        int m = str1.length;
        int n = str2.length;
        int start = 0;
        int mEnd = m - 1;
        int nEnd = n - 1;

        // 공통으로 겹치는 접두사 제거
        while (start <= mEnd && start <= nEnd && str1[start] == str2[start]) {
            count++;
            start++;
        }

        // 공통으로 겹치는 접미사 제거
        while (start <= mEnd && start <= nEnd && str1[mEnd] == str2[nEnd]) {
            count++;
            mEnd--;
            nEnd--;
        }

        int[][] C = new int[mEnd - start + 1][nEnd - start + 1];

        for (int i = start; i <= mEnd; i++) {
            for (int j = start; j <= nEnd; j++) {
                if (str1[i] == str2[j]) {
                    C[i - start][j - start] = 1 + getSafeValue(C, i - 1 - start, j - 1 - start);
                } else {
                    C[i - start][j - start] = Math.max(getSafeValue(C, i - 1 - start, j - start),
                            getSafeValue(C, i - start, j - 1 - start));
                }
            }
        }

        return C;
    }

    private static int getSafeValue(int[][] C, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return C[i][j];
    }
}
