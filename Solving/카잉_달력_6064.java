import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테스트 케이스의 제한이 주어지지 않았다...
 * -> O(1)로 풀어야 한다?
 * -> for문을 돌면서 year를 구하는 것이 아니라 M, N, x, y를 통해 year를 구할 수 있나?
 *
 * 무엇을 의미하는 지를 봐야한다!
 * x' = x + 1
 * <=> x' - 1 = x !!!
 * => (x' - 1, y' - 1)의 결과 + 1 == (x', y')의 결과
 *
 * 문제 안에 힌트가 있을 수 있다
 * -> x와 x'의 관계가 괜히 나온 게 아닐 수 있다!
 */

public class 카잉_달력_6064 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int year = 0;
            boolean exist = false;
            for (int j = x; j <= M * N; j += M) {
                if (x == 1 && y == 1) {
                    exist = true;
                    year = 1;
                    break;
                }

                if (M == x && N == y) {
                    exist = true;

                }

                if (j % N == y || N == 1) {
                    exist = true;
                    year = j;
                    break;
                }
            }
            if (exist) {
                sb.append(year).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}