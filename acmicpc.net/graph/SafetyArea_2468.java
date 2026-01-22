package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SafetyArea_2468 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        int height;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }

        int maxCount = 0;
        int count;

        for (int k = 0; k < maxHeight; k++) {
            visited = new boolean[N][N];
            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        bfs(i, j, k);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }

    private static void bfs(int x, int y, int height) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {

                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (map[nextX][nextY] > height && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.addLast(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }
}
