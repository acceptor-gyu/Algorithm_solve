import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 쉬운_최단거리_14940 {

    private static int[] rx = {1, -1, 0, 0};
    private static int[] ry = {0, 0, 1, -1};

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

        Deque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 2) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    now = dist[i][j] = 0;
                }
                dist[i][j] = now;
            }
        }

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (dist[nr][nc] == 0) {
                    continue;
                }

                if (!visited[nr][nc]) {
                    queue.addLast(new Node(nr, nc));
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == 1 && !visited[i][j]) {
                    dist[i][j] = -1;
                }
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
