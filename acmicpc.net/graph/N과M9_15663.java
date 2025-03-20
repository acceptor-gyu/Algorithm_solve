package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N과M9_15663 {

    private static int N, M;
    private static int[] numbers;
    private static boolean[] visited;
    private static HashSet<String> set = new HashSet<>();
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();

        Arrays.sort(numbers);

        backtrack(0, "");

        System.out.println(sb);
    }

    private static void backtrack(int len, String answer) {

        if (len == M) {
            answer = answer.trim();
            if (set.contains(answer)) {
                return;
            }
            set.add(answer);
            sb.append(answer).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(len + 1, answer + " " + numbers[i]);
                visited[i] = false;
            }
        }
    }
}
