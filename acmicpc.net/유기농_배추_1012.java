import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 유기농_배추_1012 {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Deque<Node> queue;
    private static int[][] map;
    private static boolean[][] visited;
    private static int cnt;
    private static int N;
    private static int M;

    private static class Node {
        int r;
        int c;

        public Node(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cnt = 0;
            queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                map[row][col] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        bfs(new Node(j, k));
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Node node) {
        queue.addLast(node);

            while (!queue.isEmpty()) {
                Node now = queue.pollFirst();

                // for문 4번 돌면서 상하좌우 탐색! (순서를 고려해야 한다면 rx, ry를 적절히 조정한다.
                for (int i = 0; i < 4; i++) {
                    int next_r = now.r + dx[i];
                    int next_c = now.c + dy[i];

                    if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {   // 맵 밖으로 나가는 경우
                        continue;
                    }

                    if (map[next_r][next_c] == 0) { // 벽이 있는 경우
                        continue;
                    }

                    if (!visited[next_r][next_c]) {
                        visited[next_r][next_c] = true; // 가장 중요!
                        queue.addLast(new Node(next_r, next_c));
                    }
                }
        }
    }
}
