package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M4_15652 {

    private static int N;
    private static int M;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        backtrack(1, 0, "");

        System.out.println(sb);
    }

    private static void backtrack(int num, int len, String answer) {

        if (len == M) {
            sb.append(answer.trim()).append("\n");
            return;
        }

        for (int i = num; i <= N; i++) {
            backtrack(i, len + 1, answer + " " + i);
        }
    }

}
