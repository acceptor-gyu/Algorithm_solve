package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner_14503 {

    // 0 ~ 3: 북 -> 동 -> 남 -> 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int direction;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;

        while (true) {

            if (!visited[r][c] && map[r][c] == 0) {
                visited[r][c] = true;
                count++;
            }

            if (step2(r, c)) {
                // 후진 ==> (direction + 2) % 4
                r = r + dr[(direction + 2) % 4];
                c = c + dc[(direction + 2) % 4];
                if (map[r][c] == 1) {
                    break;
                }
                continue;
            }

            // 반시계 방향으로 회전
            direction = (direction + 3) % 4;
            // 다음 칸이 청소되지 않은 칸이라면 이동
            if (!visited[r + dr[direction]][c + dc[direction]]) {
                r = r + dr[direction];
                c = c + dc[direction];
            }
        }

        System.out.println(count);
    }

    // 모두 깨끗하면 return true;
    private static boolean step2(int r, int c) {
        // 주변 빈 칸 체크
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            // 맵 밖으로 나가는 경우
            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) {
                continue;
            }

            // 청소 O
            if (visited[nextR][nextC]) {
                continue;
            }
            return false;
        }

        return true;
    }
}
