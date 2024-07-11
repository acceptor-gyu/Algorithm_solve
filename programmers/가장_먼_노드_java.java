import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 가장_먼_노드_java {

    private static ArrayDeque<Integer> queue = new ArrayDeque<>();
    private static int arr[];
    private static ArrayList<Integer>[] adjList;
    private static boolean visited[];

    public static int solution(int n, int[][] edge) {

        int answer = 0;
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }

        queue.addLast(1);

        visited[1] = true;
        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                int now = queue.pollFirst();

                for (int next : adjList[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.addLast(next);
                        arr[next] = arr[now] + 1;
                    }
                }
            }
        }

        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == max) {
                answer++;
                continue;
            }

            break;

        }
        return answer;
    }
}
