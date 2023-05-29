import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {

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
    private final static int INF = 300_000 * 10 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        adjList = new ArrayList[V + 1];
        visited = new boolean[V + 1];

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
        System.out.println(sb);
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
