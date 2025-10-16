package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FindParentsOfTree_11725 {

    private static boolean[] visited;
    private static int[] parents;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int root) {

        visited[root] = true;

        for (int next : adjList[root]) {
            if (!visited[next]) {
                parents[next] = root;
                dfs(next);
            }
        }
    }

}
