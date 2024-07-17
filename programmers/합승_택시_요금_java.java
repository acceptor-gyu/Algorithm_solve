import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 합승_택시_요금_java {

    private static List<List<Node>> adjList;
    private static boolean[] visited;

    private static class Node {

        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {

        adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {

            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            adjList.get(start).add(new Node(end, cost));
            adjList.get(end).add(new Node(start, cost));
        }

        int[] hitchhiking = dijkstra(s, n);
        int[] aCost = dijkstra(a, n);
        int[] bCost = dijkstra(b, n);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            if (answer > hitchhiking[i] + aCost[i] + bCost[i]) {
                answer = hitchhiking[i] + aCost[i] + bCost[i];
            }
        }

        return answer;
    }

    private static int[] dijkstra(int start, int n) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (dist[now.dest] < now.cost) {
                continue;
            }

            for (Node next : adjList.get(now.dest)) {

                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist;
    }

}
