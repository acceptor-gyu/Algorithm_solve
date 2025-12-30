package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] distances = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] gasPrices = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gasPrices[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int min = gasPrices[0];

        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, gasPrices[i]);
            result += (long) min * distances[i];
        }

        System.out.println(result);
    }
}
