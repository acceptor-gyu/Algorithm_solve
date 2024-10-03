package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BeadEscape2_13460 {

    private static char[][] map;
    private static boolean[][][][] visited;
    private static int holeX, holeY;
    private static Bead red, blue;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Bead {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        Bead(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    red = new Bead(i, j, 0, 0, 0);
                    continue;
                }
                if (map[i][j] == 'B') {
                    blue = new Bead(0, 0, i, j, 0);
                    continue;
                }
                if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        ArrayDeque<Bead> queue = new ArrayDeque<>();
        queue.add(new Bead(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while (!queue.isEmpty()) {
            Bead bead = queue.pollFirst();

            int curRx = bead.rx;
            int curRy = bead.ry;
            int curBx = bead.bx;
            int curBy = bead.by;
            int count = bead.count;

            if (count > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nextRx = curRx;
                int nextRy = curRy;
                int nextBx = curBx;
                int nextBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while (map[nextRx + dx[i]][nextRy + dy[i]] != '#') {
                    nextRx += dx[i];
                    nextRy += dy[i];

                    // 구멍에 빠지는 경우
                    if (nextRx == holeX && nextRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                while (map[nextBx + dx[i]][nextBy + dy[i]] != '#') {
                    nextBx += dx[i];
                    nextBy += dy[i];

                    // 구멍에 빠지는 경우
                    if (nextBx == holeX && nextBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) {
                    continue;
                }

                if (isRedHole && !isBlueHole) {
                    return count;
                }

                // 빨간 구슬과 파란 구슬이 같은 위치인 경우
                if (nextRx == nextBx && nextRy == nextBy) {
                    if (i == 0) {
                        if (curRx > curBx) {
                            nextRx -= dx[i];
                        } else {
                            nextBx -= dx[i];
                        }
                    }

                    if (i == 1) {
                        if (curRx > curBx) {
                            nextBx -= dx[i];
                        } else {
                            nextRx -= dx[i];
                        }
                    }

                    if (i == 2) {
                        if (curRy > curBy) {
                            nextRy -= dy[i];
                        } else {
                            nextBy -= dy[i];
                        }
                    }

                    if (i == 3) {
                        if (curRy > curBy) {
                            nextBy -= dy[i];
                        } else {
                            nextRy -= dy[i];
                        }
                    }
                }

                if (!visited[nextRx][nextRy][nextBx][nextBy]) {
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.add(new Bead(nextRx, nextRy, nextBx, nextBy, count + 1));
                }
            }
        }

        return -1;
    }
}
