package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class MovingOfKnight_7562 {

    static int I;
    static int[][] distance;
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {

            I = Integer.parseInt(br.readLine());
            distance = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetR = Integer.parseInt(st.nextToken());
            int targetC = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startR, startC, targetR, targetC));
        }

    }

    private static int bfs(int r, int c, int targetR, int targetC) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {r, c});
        distance[r][c] = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int nowR = now[0];
            int nowC = now[1];

            if (nowR == targetR && nowC == targetC) {
                return distance[nowR][nowC] == -1 ? 0 : distance[nowR][nowC] + 1;
            }

            for (int i = 0; i < 8; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= I || nextC >= I) {
                    continue;
                }

                // 거리가 0이 아니라면 방문한 위치이므로 continue
                if (distance[nextR][nextC] != 0) {
                    continue;
                }

                distance[nextR][nextC] = distance[nowR][nowC] + 1;
                queue.addLast(new int[] {nextR, nextC});
            }
        }

        // 도달하지 못하는 케이스 (존재하지 않음)
        return -1;
    }
}
