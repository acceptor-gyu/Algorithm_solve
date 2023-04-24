import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_평범한배낭 {

    private static class Goods {
        int weight;
        int value;

        public Goods(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물건의 수
        int K = Integer.parseInt(st.nextToken());   // 가방의 무게

        Goods[] goods = new Goods[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            goods[i] = new Goods(weight, value);
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            Goods now = goods[i];
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];    // 직전까지 구해놓은 답이 여전히 답이 될 수 있기 때문에 일단 복사해온다.
                if (j >= now.weight) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - now.weight] + now.value);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
