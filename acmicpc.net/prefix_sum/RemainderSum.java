package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemainderSum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[M];

        st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            prefixSum[sum]++;
        }

        long result = prefixSum[0];

        for (int i = 0; i < M; i++) {
            result += (long) prefixSum[i] * (prefixSum[i] - 1) / 2;
        }

        System.out.println(result);
    }

}
