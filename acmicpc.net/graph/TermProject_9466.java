package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TermProject_9466 {

    private static boolean[] visited;
    private static boolean[] completed;
    private static int[] desired;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());
            desired = new int[n + 1];
            visited = new boolean[n + 1];
            completed = new boolean[n + 1];
            answer = 0;

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                desired[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!completed[j]) {
                    dfs(j);
                }
            }

            System.out.println(n - answer);
        }
    }

    private static void dfs(int now) {

        if (visited[now]) {
            completed[now] = true;
            answer++;
        }

        if (!visited[now]) {
            visited[now] = true;
        }

        if (!completed[desired[now]]) {
            dfs(desired[now]);
        }

        visited[now] = false;
        completed[now] = true;
    }
}
