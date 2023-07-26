import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 적록색약_10026 {

    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static Deque<Node> queue;
    private static char[][] map;
    private static boolean[][] visited;
    private static int N;

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
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
            }
        }

        int common = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    commonBfs(new Node(i, j), map[i][j]);
                    common++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        int weakness = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    weaknessBfs(new Node(i, j), map[i][j]);
                    weakness++;
                }
            }
        }

        System.out.println(common + " " + weakness);


    }

    private static void commonBfs(Node node, char identifier) {

        queue.addLast(node);
        visited[node.r][node.c] = true;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // for문 4번 돌면서 상하좌우 탐색! (순서를 고려해야 한다면 rx, ry를 적절히 조정한다.
            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dx[i];
                int nextC = now.c + dy[i];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {   // 맵 밖으로 나가는 경우
                    continue;
                }

                if (map[nextR][nextC] != identifier) {
                    continue;
                }

                if (!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.addLast(new Node(nextR, nextC));
                }
            }
        }
    }

    private static void weaknessBfs(Node node, char identifier) {

        queue.addLast(node);
        visited[node.r][node.c] = true;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // for문 4번 돌면서 상하좌우 탐색! (순서를 고려해야 한다면 rx, ry를 적절히 조정한다.
            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dx[i];
                int nextC = now.c + dy[i];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {   // 맵 밖으로 나가는 경우
                    continue;
                }


                if (map[nextR][nextC] != identifier) {
                    continue;
                }

                if (!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.addLast(new Node(nextR, nextC));
                }
            }
        }
    }
}
