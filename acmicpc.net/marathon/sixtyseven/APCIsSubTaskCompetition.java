package marathon.sixtyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class APCIsSubTaskCompetition {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 문제 수, L: 역량, K: 풀 수 있는 문제 수
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] problems = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(problems, (a, b) -> {

            boolean aUnderL = a[1] <= L;
            boolean bUnderL = b[1] <= L;

            if (aUnderL && !bUnderL) return -1;
            if (!aUnderL && bUnderL) return 1;

            if (aUnderL && bUnderL) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int score = 0;

        for (int i = 0; i < N; i++) {
            if (problems[i][1] <= L) {
                score += 140;
                K--;
                if (K == 0) {
                    break;
                }
                continue;
            }

            if (problems[i][0] <= L) {
                score += 100;
                K--;
            }

            if (K == 0) {
                break;
            }
        }

        System.out.println(score);
    }
}
