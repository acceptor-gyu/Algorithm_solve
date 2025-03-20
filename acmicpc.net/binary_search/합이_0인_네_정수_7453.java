package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 풀이 1. HashMap 활용
 *
 * 풀이 2. two pointer
 */

public class 합이_0인_네_정수_7453 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(C[i] + D[j])) {
                    map.put(C[i] + D[j], map.get(C[i] + D[j]) + 1);
                } else {
                    map.put(C[i] + D[j], 1);
                }
            }
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(-A[i] - B[j])) {
                    answer += map.get(-A[i] - B[j]);
                }
            }
        }

        System.out.println(answer);
    }

    // two pointer
    private static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int left = 0;
        int right = n * n - 1;

        while (left < n * n && right >= 0) {

            int sum = AB[left] + CD[right];

            if (sum < 0) {
                left++;
                continue;
            } else if (sum > 0) {
                right--;
                continue;
            } else {
                long leftCount = 1;
                long rightCount = 1;

                // 합이 같은 동안 계속 이동
                while (left < n * n - 1 && AB[left] == AB[left + 1]) {
                    leftCount++;
                    left++;
                }

                while (right > 0 && CD[right] == CD[right - 1]) {
                    rightCount++;
                    right++;
                }

                answer += leftCount * rightCount;
                left++;
                right--;
            }
        }

        System.out.println(answer);
    }
}
