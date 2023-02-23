import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 조건
 * - 시간 제한: 2초
 * - 1 <= N <= 1_000_000
 * -> O(N log N) 이하로 풀면 될 것이다.
 *
 * - 작은 수부터 for문을 돌면서 분해합과 N이 같으면 해당 수를 출력하면 된다.
 * - 없으면 0을 출력하면 된다.
 */

public class 분해합_2231 {

    private static int decomposition(int N) {
        for (int i = 1; i <= N; i++) {
            int sum = i;
            int j = i;
            while (j != 0) {
                sum += j % 10;
                j = j / 10;
            }

            if (sum == N) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int res;
        res = decomposition(N);

        System.out.println(res);
    }
}
