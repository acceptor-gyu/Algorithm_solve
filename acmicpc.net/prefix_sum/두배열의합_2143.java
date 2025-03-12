package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 두배열의합_2143 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> prefixMapOfA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                prefixMapOfA.put(sum, prefixMapOfA.getOrDefault(sum, 0) + 1);
            }
        }

        Map<Integer, Integer> prefixMapOfB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                prefixMapOfB.put(sum, prefixMapOfB.getOrDefault(sum, 0) + 1);
            }
        }

        long result = 0;

        for (Integer keyA : prefixMapOfA.keySet()) {
            if (prefixMapOfB.containsKey((T - keyA))) {
                result += (long) prefixMapOfA.get(keyA) * prefixMapOfB.get(T - keyA);
            }
        }

        System.out.println(result);
    }

}
