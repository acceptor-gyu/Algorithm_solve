import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 파이프옮기기_17070 {

    private static Deque<Node> queue;
    private static int[][] map;
    private static int N;
    private static int M;

    private static class Node {
        int r;
        int c;
        int direction;

        public Node(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new ArrayDeque<>();
        int res = bfs(new Node(1, 2, 0));

        System.out.println(res);

    }

    private static int bfs(Node node) {
        int res = 0;
        queue.addLast(node);

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            if (now.r == N && now.c == N) {
                res++;
                continue;
            }

            if (now.direction == 0) {
                if (check(now, 0)) {
                    queue.add(new Node(now.r, now.c + 1, 0));
                }
                if (check(now, 2)) {
                    queue.add(new Node(now.r + 1, now.c + 1, 2));
                }
            }

            if (now.direction == 1) {
                if (check(now, 1)) {
                    queue.add(new Node(now.r + 1, now.c, 1));
                }
                if (check(now, 2)) {
                    queue.add(new Node(now.r + 1, now.c + 1, 2));
                }
            }

            if (now.direction == 2) {
                if (check(now, 0)) {
                    queue.add(new Node(now.r, now.c + 1, 0));
                }
                if (check(now, 1)) {
                    queue.add(new Node(now.r + 1, now.c, 1));
                }
                if (check(now, 2)) {
                    queue.add(new Node(now.r + 1, now.c + 1, 2));
                }
            }
        }

        return res;
    }

    private static boolean check(Node node, int direction) {
        if (direction == 0) {
            return node.c + 1 <= N && map[node.r][node.c + 1] != 1;
        }
        if (direction == 1) {
            return node.r + 1 <= N && map[node.r + 1][node.c] != 1;
        }
        if (direction == 2) {
            return node.r +1 <= N && node.c + 1 <= N && map[node.r][node.c + 1] != 1 && map[node.r + 1][node.c] != 1 && map[node.r + 1][node.c + 1] != 1;
        }
        return false;
    }
}
