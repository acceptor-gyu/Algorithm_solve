import java.util.ArrayList;

public class 전력망을_둘로_나누기 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int N, answer;

    public static int solution(int n, int[][] wires) {

        N = n;
        answer = n - 1;

        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        visited = new boolean[n + 1];

        dfs(1);
        return answer;
    }

    private static int dfs(int now) {

        visited[now] = true;
        int sum = 0;

        for (int next : adjList[now]) {

            if (!visited[next])  {

                int res = dfs(next);
                answer = Math.min(answer, Math.abs(N - res * 2)); // 양쪽 노드 개수의 차이를 구하기 위해 res를 두 번 뺌
                sum += res;
            }
        }

        return sum + 1; // 현재 노드 추가
    }
}
