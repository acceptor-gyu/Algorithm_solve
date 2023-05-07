import java.util.ArrayDeque;

public class BFS_ROR {

    // 방문한 정점에서 상하좌우 탐색을 위한 배열
    private int[] rx = {1, -1, 0, 0};
    private int[] ry = {0, 0, 1, -1};

    private class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        // 큐에 넣으면서 방문했음을 저장
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {   // 상하좌우 탐색
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 맵 밖으로 나가는 경우 또는 이동하지 못하는 경우 예외 처리
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {   // 맵 밖으로 나가는 경우
                    continue;
                }

                if (maps[nr][nc] == 0) { // 이동하지 못하는 경우
                    continue;
                }

                if (!visited[nr][nc]) { // 방문한 정점이 아니면
                    // 큐에 넣으면서 방문했음을 저장
                    queue.addLast(new Node(nr, nc));
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}
