import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 숨바꼭질2_12851 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        int[] map = new int[100_001];
        Deque<Integer> queue = new ArrayDeque<>();

        if (subin >= sister) {
            System.out.println(subin - sister);
            System.out.println(1);
            return;
        }

        queue.addLast(subin);
        int time = 100_001;
        int count = 0;
        int next = 0;
        map[subin] = 1;

        while (!queue.isEmpty()) {

            int now = queue.pollFirst();

            for (int i = 0; i < 3; i++) {

                if (time < map[now]) {
                    break;
                }

                if (i == 0) {
                    next = now + 1;
                }
                if (i == 1) {
                    next = now - 1;
                }
                if (i == 2) {
                    next = now * 2;
                }

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (map[next] == 0 || map[next] == map[now] + 1) {
                    queue.addLast(next);
                    map[next] = map[now] + 1;
                }

                if (next == sister) {
                    time = map[now];
                    count++;
                }
            }
        }

        System.out.println(time);
        System.out.println(count);

    }
}
