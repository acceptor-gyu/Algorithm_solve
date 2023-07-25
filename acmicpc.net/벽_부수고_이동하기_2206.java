import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기_2206 {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Deque<Node> queue;
    private static int[][] map;
    private static boolean[][] visited;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int cnt = N * M + 1;

        Deque<Node> walls = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                int el = Integer.parseInt(String.valueOf(line[j]));
                map[i][j] = el * -1;
                if (el == 1) {
                    walls.addLast(new Node(i, j));
                }
            }
        }

        while (!walls.isEmpty()) {

            visited = new boolean[N][M];
            queue = new ArrayDeque<>();

            Node crushedWall = walls.pollFirst();

            int[][] crushedMap = duplicateMap(map);
            crushedMap[crushedWall.r][crushedWall.c] = 0;
            queue.addLast(new Node(0, 0));

            int bfsCount = bfs(crushedMap, new Node(0, 0));

            if (bfsCount != 0 && bfsCount < cnt) {
                cnt = bfsCount;
            }
        }

        if (cnt == N * M + 1) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }

    private static int bfs(int[][] curMap, Node node) {
        queue.addLast(node);
        curMap[node.r][node.c] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // for문 4번 돌면서 상하좌우 탐색! (순서를 고려해야 한다면 rx, ry를 적절히 조정한다.
            for (int i = 0; i < 4; i++) {
                int next_r = now.r + dx[i];
                int next_c = now.c + dy[i];

                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {   // 맵 밖으로 나가는 경우
                    continue;
                }

                if (curMap[next_r][next_c] == -1) { // 벽이 있는 경우
                    continue;
                }

                if (!visited[next_r][next_c]) {
                    visited[next_r][next_c] = true; // 가장 중요!
                    curMap[next_r][next_c] = curMap[now.r][now.c] + 1;
                    queue.addLast(new Node(next_r, next_c));
                }
            }
        }

        return curMap[N - 1][M - 1];
    }

    private static int[][] duplicateMap(int[][] map) {

        int row = map.length;
        int col = map[0].length;

        int[][] duplicatedMap = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                duplicatedMap[i][j] = map[i][j];
            }
        }

        return duplicatedMap;
    }
}
