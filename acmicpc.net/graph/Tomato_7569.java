package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7569번 - 토마토 (3차원)
 *
 * 문제: 3차원 상자에 담긴 토마토들이 모두 익는데 걸리는 최소 일수 구하기
 * - 1: 익은 토마토, 0: 안 익은 토마토, -1: 토마토 없음
 * - 익은 토마토는 6방향(상하좌우전후)으로 익음을 전파
 *
 * 알고리즘: 3D BFS
 * 1. 초기에 익은 토마토들을 모두 큐에 넣음
 * 2. BFS로 6방향 탐색하며 안 익은 토마토를 익힘
 * 3. 모든 토마토가 익었는지 확인하고 최소 일수 출력
 */
public class Tomato_7569 {

    static int M, N, H; // 가로, 세로, 높이
    static int[][][] box; // 3차원 상자
    static Queue<Tomato> queue = new LinkedList<>();

    // 6방향: 상, 하, 좌, 우, 앞, 뒤
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dn = {-1, 1, 0, 0, 0, 0};
    static int[] dm = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 (열)
        N = Integer.parseInt(st.nextToken()); // 세로 (행)
        H = Integer.parseInt(st.nextToken()); // 높이 (층)

        box = new int[H][N][M];

        // 입력 받기 및 익은 토마토 위치를 큐에 추가
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new Tomato(h, n, m, 0));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            days = current.day;

            // 6방향 탐색
            for (int i = 0; i < 6; i++) {
                int nh = current.h + dh[i];
                int nn = current.n + dn[i];
                int nm = current.m + dm[i];

                // 범위 체크
                if (nh < 0 || nh >= H || nn < 0 || nn >= N || nm < 0 || nm >= M) {
                    continue;
                }

                // 안 익은 토마토만 익힘
                if (box[nh][nn][nm] == 0) {
                    box[nh][nn][nm] = 1;
                    queue.offer(new Tomato(nh, nn, nm, current.day + 1));
                }
            }
        }

        // 모든 토마토가 익었는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        return -1; // 익지 않은 토마토가 있음
                    }
                }
            }
        }

        return days;
    }

    static class Tomato {
        int h, n, m; // 높이, 세로, 가로
        int day; // 걸린 일수

        Tomato(int h, int n, int m, int day) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.day = day;
        }
    }
}
