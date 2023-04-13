import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];
        Deque<Node> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line[j - 1]));
            }
        }

        queue.addLast(new Node(1, 1));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // for문 4번 돌면서 상하좌우 탐색! (순서를 고려해야 한다면 rx, ry를 적절히 조정한다.
            for (int i = 0; i < 4; i++) {
                int next_r = now.r + rx[i];
                int next_c = now.c + ry[i];

                if (next_r < 1 || next_c < 1 || next_r > N || next_c > M) {   // 맵 밖으로 나가는 경우
                    continue;
                }

                if (map[next_r][next_c] == 0) { // 벽이 있는 경우
                    continue;
                }

                if (!visited[next_r][next_c]) {
                    visited[next_r][next_c] = true; // 가장 중요!
                    map[next_r][next_c] = map[now.r][now.c] + 1;
                    queue.addLast(new Node(next_r, next_c));
                }
            }
        }

        System.out.println(map[N][M]);

    }
}
