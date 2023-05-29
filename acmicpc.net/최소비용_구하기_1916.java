import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용_구하기_1916 {

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
    private final static int INF = 1000 * 100_000 + 1;  // 정점의 최대 개수 * 최대 비용 + 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.cost, o2.cost)
        );

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : adjList[now.end]) {
                if (dist[next.end] > now.cost + next.cost) {
                    dist[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }

            }
        }
    }
}
