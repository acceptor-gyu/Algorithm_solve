import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 연결_요소의_개수_11724 {

    private static Deque<Integer> queue;
    private static boolean[] visited;
    private static ArrayList<Integer>[] map;
    private static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        map = new ArrayList[N + 1];
        int from;
        int to;

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            map[from].add(to);
            map[to].add(from);
        }

        cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            bfs(i);
        }

        System.out.println(cnt);
    }

    private static void bfs(int head) {
        queue.addLast(head);
        visited[head] = true;
        cnt++;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();

            for (int i = 0; i < map[now].size(); i++) {
                if (visited[map[now].get(i)]) {
                    continue;
                }

                visited[map[now].get(i)] = true;
                queue.addLast(map[now].get(i));
            }
        }
    }
}
