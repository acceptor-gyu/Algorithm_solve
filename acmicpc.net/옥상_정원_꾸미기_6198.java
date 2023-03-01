import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 시간 제한: 1초
 *
 * 1 <= N <= 80_000
 * 1 <= h <= 1_000_000_000
 *
 * h는 시간 복잡도에 영향을 주지 않을 것이다.
 * O(N log N) 이하로 풀면 될 것아다.
 *
 * - count 오버 플로우 주의.....!!!!!
 */

public class 옥상_정원_꾸미기_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long count = 0;

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            while (true) {
                if (stack.isEmpty()) {
                    stack.addLast(now);
                    break;
                }
                int prev = stack.peekLast();

                if (prev > now) {
                    count += stack.size();
                    stack.addLast(now);
                    break;
                } else {
                    stack.pollLast();
                }
            }
        }

        System.out.println(count);
    }
}
