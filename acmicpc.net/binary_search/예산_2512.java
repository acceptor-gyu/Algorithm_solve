package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int max = 0;

        for (int budget : budgets) {
            if (budget > max) {
                max = budget;
            }
        }

        int left = 0;
        int right = max;

        while (left <= right) {

            int mid = (left + right) / 2;

            int sum = 0;

            for (int budget : budgets) {
                if (budget > mid) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }

            if (sum <= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
