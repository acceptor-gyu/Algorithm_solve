package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형_1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j];
            }
        }

        System.out.println(triangle[0][0]);
    }
}
