package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class NamingApartment_2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않았지만 집인 경우 새로운 단지
                if (map[i][j] == 1 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int count : result) {
            System.out.println(count);
        }
    }

    private static int bfs(int x, int y) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.addLast(new int[]{nextX, nextY});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
