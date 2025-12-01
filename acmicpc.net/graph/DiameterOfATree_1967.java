package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DiameterOfATree_1967 {

    private static class Node {
        int index;
        int count;

        Node (int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private static ArrayList<Node>[] list;
    private static int n;
    private static int max = 0;
    private static boolean[] visited;
    private static int maxOfIndex = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {

            String[] target = br.readLine().split(" ");

            int parent = Integer.parseInt(target[0]);
            int child = Integer.parseInt(target[1]);
            int weight = Integer.parseInt(target[2]);

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[maxOfIndex] = true;
        dfs(maxOfIndex, 0);

        System.out.println(max);
    }

    public static void dfs(int index, int count) {

        if (max < count) {
            max = count;
            maxOfIndex = index;
        }

        for (Node node : list[index]) {
            if (!visited[node.index]) {
                visited[node.index] = true;
                dfs(node.index, count + node.count);
            }
        }
    }
}
