package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 0 ~ L 사이에서 M개의 휴게소를 세웠을 때 가장 인접한 두 휴게소 사이의 거리의 최댓값
 * -> M개의 휴게소를 세울 수 있는 최적값 찾기
 * -> 0 ~ L parametric search
 */

public class 휴게소_세우기_1477 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] rests = new int[N + 2];
        rests[0] = 0;

        for (int i = 1; i <= N; i++) {
            rests[i] = Integer.parseInt(st.nextToken());
        }

        rests[N + 1] = L;

        Arrays.sort(rests);

        int left = 1;
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 1; i < rests.length; i++) {
                sum += (rests[i] - rests[i - 1] - 1) / mid;
            }

            if (sum > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
