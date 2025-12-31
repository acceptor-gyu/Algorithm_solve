package marathon.eightythree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CovenienceStore_20155 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] brands = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int brand = Integer.parseInt(st.nextToken());
            brands[brand]++;
        }

        int max = 0;
        for (int i = 1; i <= M; i++) {
            max = Math.max(max, brands[i]);
        }
        System.out.println(max);
    }

}
