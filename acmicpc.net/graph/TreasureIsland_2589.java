package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class TreasureIsland_2589 {

    static int r;
    static int c;
    static int max = 0;
    static int[][] distance;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = line[j];
            }
        }

        distance = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    initDistance();
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {

        Deque<int[]> queue  = new ArrayDeque<>();
        queue.addLast(new int[] {x, y});

        distance[x][y] = 0;

        while (!queue.isEmpty()) {

            int[] now = queue.pollFirst();
            int nowR = now[0];
            int nowC = now[1];

            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= r || nextC >= c) {
                    continue;
                }

                if (map[nextR][nextC] == 'W') {
                    continue;
                }

                if (distance[nextR][nextC] != -1) {
                    continue;
                }

                queue.addLast(new int[] {nextR, nextC});
                distance[nextR][nextC] = distance[nowR][nowC] + 1;
                max = Math.max(distance[nextR][nextC], max);
            }
        }
    }

    private static void initDistance() {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                distance[i][j] = -1;
            }
        }
    }
}
