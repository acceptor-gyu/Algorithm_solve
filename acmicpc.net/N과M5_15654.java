import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5_15654 {

    private static int N, M;
    private static StringBuilder sb;
    private static int[] numbers;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        sb = new StringBuilder();

        backtrack(0, "");

        System.out.println(sb);

    }

    private static void backtrack(int len, String ans) {

        if (len == M) {
            sb.append(ans.trim()).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(len + 1, ans + " " + numbers[i]);
                used[i] =  false;
            }
        }
    }
}
