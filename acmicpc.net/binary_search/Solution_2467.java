package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2467 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 용액들의 성분 (알칼리 ~ 산)
        int[] acid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            acid[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 배열이 주어짐 (정렬 불필요)
        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int finalL = left;
        int finalR = right;

        while (left != right) {

            int sum = acid[left] + acid[right];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                finalL = left;
                finalR = right;
            }
            System.out.println(sum);
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(acid[finalL] + " " + acid[finalR]);
    }
}
