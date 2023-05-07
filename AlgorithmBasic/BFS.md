# BFS (Breadth First Search)

> 본 내용은 `coding study with jordy`에서의 내용을 기반으로 작성했습니다.

## BFS (Breadth First Search, 너비 우선 탐색)
- 탐색 시작점에서 가까운 정점들부터 방문하게 되는 탐색 방법
- 간선의 가중치가 전부 동일한 경우 최단 거리를 구할 수 있다.
- 일반적으로 큐(Queue) 자료구조를 사용해 구현한다.
- (*중요!) 동일한 정점을 재방문하지 않을 경우, 다음에 방문할 정점을 큐(Queue)에 넣을 때 해당 정점에 대해 방문처리를 한다.
- 방문처리 없이 동일한 정점을 재방문할 경우 시간초과가 발생할 수 있다.

> 위에 보이듯이 bfs에서 가장 중요한 것은 방문한 정점을 재방문하지 않는 것입니다.


## BFS(Breadth First Search) 구현 방
- 비어있는 큐(Queue), 방문 배열, 최단 거리(필요한 경우) 배열을 만든다.
- 시작 정점을 큐에 넣고, 방문 배열에 방문했음을 저장한다.
- 큐에 데이터가 남아있으면 아래 과정을 방문한다.
  - 큐에서 정점을 꺼낸다.
  - 해당 정점에서 방문 가능한 다음 정점을 큐에 넣는다. (이미 방문한 정점은 제외한다.)
    - (필요한 경우) 해당 정점이 유효한 정점인지 체크한다.
    - (필요한 경우) 해당 정점으로 이동이 가능한지 체크한다.
  - (필요한 경우) 해당 정점의 최단 거리에서 +1을 한 값을 다음 정점의 최단 거리로 저장한다.
  - 큐에 정점을 넣으면서 해당 정점에 대해 방문했음을 저장한다.

> bfs 구현 방법에서 가장 중요한 것은 마지막에 있는 `큐에 정점을 넣으면서 해당 정점에 방문했음을 저장한다.`입니다.
> - 큐에 정점을 넣으면서 방문했음을 저장하지 않으면 시간 복잡도가 달라질 수 있어 시간 초과가 날 수 있습니다.

## bfs 예시 문제
- [ROR](https://school.programmers.co.kr/learn/courses/30/lessons/1844)
- [연구소](https://www.acmicpc.net/problem/14502)

### ROR 문제 풀이
- 위에서 설명한 그대로 구현했습니다.

```java
import java.util.ArrayDeque;

class Solution {

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
        dist[0][0] = 1;

        // 큐에 넣으면서 방문했음을 저장
        queue.add(new Node(0, 0));
        visited[0][0] = true;

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

                if (!visited[nr][nc]) { // 방문하지 않은 정점이면
                    // 큐에 넣으면서 방문했음을 저장
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}

```
