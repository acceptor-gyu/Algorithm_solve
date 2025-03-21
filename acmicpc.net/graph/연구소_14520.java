package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 연구소_14520 {

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int N, M;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;
    private static ArrayDeque<Node> virus = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    virus.addLast(new Node(i, j));
            }
        }

        ArrayDeque<Node> block = new ArrayDeque<>();
        int answer = 0;

        // 벽 배치 완전 탐색 (bfs 반복)
        for (int i = 0; i < N * M - 2; i++) {
            // 벽을 세우려는 위치에 바이러스 또는 벽이 있다면 스킵
            if (map[i / M][i % M] != 0) {
                continue;
            }
            block.addLast(new Node(i / M, i % M));
            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) {
                    continue;
                }
                block.addLast(new Node(j / M, j % M));
                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) {
                        continue;
                    }
                    block.addLast(new Node(k / M, k % M));
                    answer = Math.max(answer, bfs(block));
                    block.pollLast();
                }
                block.pollLast();
            }
            block.pollLast();
        }

        System.out.println(answer);
    }

    private static int bfs(ArrayDeque<Node> block) {

        int[][] map2 = new int[N][M];

        // 벽을 배치한 하나의 경우마다 map 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map2[i][j] = map[i][j];
            }
        }

        // 3개의 벽을 배치
        for (Node node : block) {
            map2[node.r][node.c] = 1;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 시작 정점 3개(바이러스)를 queue에 넣는다.
        for (Node node : virus) {
            queue.addLast(node);
        }

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dy[i];
                int nc = now.c + dx[i];

                // 맵 밖으로 나가는 경우
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                // 벽인 경우
                if (map2[nr][nc] == 1) {
                    continue;
                }

                // 바이러스 감염
                if (map2[nr][nc] == 0) {
                    map2[nr][nc] = 2;
                    queue.addLast(new Node(nr, nc));
                }
            }
        }

        int count = 0;

        // 감염되지 않은 영역 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map2[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
