import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼_더하기5_15990 {

    private static final int HELPER = 1_000_000_009;
    private static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] finishOne = new int[100001];
        int[] finishTwo = new int[100001];
        int[] finishThree = new int[100001];

        finishOne[1] = 1;
        finishTwo[1] = 0;
        finishThree[1] = 0;

        finishOne[2] = 0;
        finishTwo[2] = 1;
        finishThree[2] = 0;

        finishOne[3] = 1;
        finishTwo[3] = 1;
        finishThree[3] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 3;

        for (int i = 4; i <= 100000; i++) {
            finishOne[i] = (finishTwo[i - 1] + finishThree[i - 1]) % HELPER;
            finishTwo[i] = (finishOne[i - 2] + finishThree[i - 2]) % HELPER;
            finishThree[i] = (finishTwo[i - 3] + finishOne[i - 3]) % HELPER;

            dp[i] = (((finishOne[i] + finishTwo[i]) % HELPER) + finishThree[i]) % HELPER;
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
