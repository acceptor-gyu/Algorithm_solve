import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] positions = new int[100001];
        int subin = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>(); // 비어있는 큐(팀색을 위한 큐, 정점의 번호)
        queue.addLast(subin);

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            int next = now;

            if (now == target) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = now - 1;
                }

                if (i == 1) {
                    next = now + 1;
                }

                if (i == 2) {
                    next = now * 2;
                }

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (positions[next] == 0) {
                    queue.addLast(next);
                    positions[next] = positions[now] + 1;
                }
            }
        }
        System.out.println(positions[target]);
    }
}
