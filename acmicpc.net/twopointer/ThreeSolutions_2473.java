package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeSolutions_2473 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] solutions = new int[N];

        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        long min = Long.MAX_VALUE;

        out : for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {

                long result  = (long) solutions[i] + solutions[left] + solutions[right];

                if (min > Math.abs(result)) {
                    min = Math.abs(result);
                    r1 = i;
                    r2 = left;
                    r3 = right;
                }

                if (result == 0) {
                    break out;
                }

                if (result > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }

        System.out.println(solutions[r1] + " " + solutions[r2] + " " + solutions[r3]);
    }
}
