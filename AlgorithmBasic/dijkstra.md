# dijkstra algorithm

> 본 내용은 `coding study with jordy`에서의 내용을 기반으로 작성했습니다.

## 다익스트라 (Dijkstra)
- 어떤 `시작 정점(x)`에서 다른 `모든` 정점까지의 `최단 거리`를 구하는 알고리즘
- 현재 시점에서 가장 최선의 선택을 하는 그리디(탐욕적) 알고리즘에 속한다.
- 우선순위 큐(Priority Queue)를 사용해 구현하면 시간 복잡도는 O(E log V)이다.
  - E: Edge(간선의 개수), V: Vertex(정점의 개수) => 따라서 간선의 수가 시간 복잡도에 큰 영향을 준다.
- 음의 가중치를 갖는 간선이 있는 경우 정확한 최단 거리를 구할 수 없거나 혹은 시간 복잡도가 O(N^2)까지 증가할 수 있다.

> 다익스트라 알고리즘에서는 다음 두 가지가 중요합니다.
> 1. `시작 정점`이 존재한다.
> 2. `모든 정점`까지의 최단거리를 구한다.

- 추가적으로 음의 가중치를 갖는 간선이 있는 경우는 크게 두 가지로 나눠볼 수 있습니다.
  1. 음의 사이클이 있는 경우
     1. 무한 루프에 빠지게되어 다익스트라 알고리즘을 사용하는 것이 적합하지 않습니다.
  2. 음의 사이클이 없는 경우
     1. 이 경우에도 다익스트라 알고리즘을 권장하지 않지만, 구현을 할 수는 있고 이 때의 시간 복잡도는 O(N^2)이 될 수 있습니다.
  > 음의 가중치를 갖는 간선이 있는 경우 벨만 포드 알고리즘이 적합할 것입니다. (벨만 포드 알고리즘은 다루지 않겠습니다.)

## 다익스트라 알고리즘 원리
1. 시작 정점부터 최단 거리가 몇인지를 저장할 배열을 만듭니다.
   1. 처음에는 무한대로 초기화를 합니다.
   2. 다익스트라 알고리즘이 끝나고 여전히 무한대라면 길을 찾지 못하는, 도달할 수 없는 정점입니다.
2. 최단 거리가 갱신이 된다면. 즉, 더 짧은 경로를 발견했다면 Priority Queue에 넣습니다.
3. 방문한 정점은 재방문하지 않습니다.
4. 우선순위 큐(Priority Queue)는 거리를 기준으로 오름차순 정렬합니다.
5. 현재 정점에서 갈 수 있는 경로를 다 찾아보면 다음 정점을 우선순위 큐에서 꺼내면서 방문합니다. 

> 무한대로 초기화 할 때 주의하면 좋은 것
> - 자바에서 INTEGER.MAX_VALUE를 사용할 때 해당 값에 +1을 하는 연산이 있으면 오버플로우가 발생하기 때문에, 문제의 조건을 보고 최단 거리로 나올 수 없는 수를 최대값으로 설정하면 좋을 것입니다.

## 다익스트라 알고리즘 예제 코드
- [백준 최단 경로](https://www.acmicpc.net/problem/1753)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    private static ArrayList<Node>[] adjList;
    private static int[] dist;
    private static boolean[] visited;
    private final static int INF = 200_000 * 10 + 1;    // 최대(무한대)를 (정점의 최대 개수) * (가중치의 최대)로 잡으면 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        adjList = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
    }

    private static void dijkstra(int start) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF); // 무한대 값으로 초기화

        // 정렬되는 조건 추가!
        // cost 기준으로 오름차순 정렬되는 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.cost, o2.cost)
        );

        dist[start] = 0;    // 갱신이 일어났다. -> pq에 넣는다.
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {    // 방문을 했으면 continue
                continue;
            }

            visited[now.end] = true;

            for (Node next : adjList[now.end]) {
                //  > 현재 정점 까지의 최단거리 + 현재 정점에서 다음 정점까지의 거리
                if (dist[next.end] > now.cost + next.cost) {
                    dist[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end, dist[next.end])); // 거리에 갱신이 일어나면 pq에 넣는다.
                }
            }
        }

    }
}
``` 

visited 배열을 사용하지 않고 구현하면 아래와 같습니다.
- 위의 코드에서 `visited`가 들어간 부분을 모두 제거하고
- 방문 체크를 하는 코드를 아래와 같이 수정하면 될 것입니다.
> ```java
> if (dist[now.end] < now.cost) {
>   continue;
> }
> 
> ```
- visited 배열을 사용하지 않고 구현하게 되면 음의 가중치를 갖는 간선이 있는 경우 중, 음의 사이클이 없는 경우에도 가능할 것입니다.

