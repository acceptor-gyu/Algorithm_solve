package marathon.sixtyeight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChristmasParty {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        int[] scores = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (targets[i] == Integer.parseInt(st.nextToken())) {
                    scores[j]++;
                } else {
                    scores[targets[i] - 1]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(scores[i]);
        }
    }
}
