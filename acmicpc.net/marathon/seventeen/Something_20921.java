package marathon.seventeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Something_20921 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int acc = 0;
        int cur = N - 1;
        boolean[] numbers = new boolean[N];

        while (cur > 0) {
            if (acc == K) {
                break;
            }

            if (acc + cur <= K) {
                acc += cur;
                numbers[cur] = true;
            }
            cur--;
        }

        for (int i = N - 1; i >= 0 ; i--) {
            if (numbers[i]) {
                System.out.print((i + 1) + " ");
            }
        }

        for (int i = 0; i < N; i++) {
            if (!numbers[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
