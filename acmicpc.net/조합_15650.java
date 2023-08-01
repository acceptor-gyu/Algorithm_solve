import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_15650 {

    private static int N, M;
    private static boolean[] used;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];
        sb = new StringBuilder();
        backtrack(0, 0, "");

        System.out.println(sb);
    }

    private static void backtrack(int x, int len, String ans) {
        if (len == M) {
            sb.append(ans.trim()).append("\n");
            return;
        }

        for (int i = x + 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(i, len + 1, ans + " " + i);
                used[i] = false;
            }
        }

    }

}