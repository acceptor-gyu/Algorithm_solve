package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoredPaper {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfColoredPaper = Integer.parseInt(br.readLine());
        boolean[][] colored = new boolean[100][100];
        StringTokenizer st;

        for (int i = 0; i < numberOfColoredPaper; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    colored[j - 1][k - 1] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (colored[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
