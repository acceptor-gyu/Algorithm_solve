package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeAndQuery_15681 {

    private static ArrayList<Integer>[] linkedNodes;
    private static int[] countOfChildNodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        countOfChildNodes = new int[N + 1];
        Arrays.fill(countOfChildNodes, 1);
        linkedNodes = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            linkedNodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            linkedNodes[u].add(v);
            linkedNodes[v].add(u);
        }

        dfs(R, -1);

        for (int i = 0; i < Q; i++) {
            System.out.println(countOfChildNodes[Integer.parseInt(br.readLine())]);
        }
    }

    private static void dfs(int now, int pre) {

        for (int nextNode : linkedNodes[now]) {

            if (pre != nextNode) {
                dfs(nextNode, now);
            }
        }

        if (pre != -1) {
            countOfChildNodes[pre] += countOfChildNodes[now];
        }
    }
}
