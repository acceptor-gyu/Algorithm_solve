import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int prev = 1;
        int now;
        int res = 1;
        for (int i = 0; i < N; i++) {
            now = prev + 6 * i;
            if (N > prev && N <= now) {
                res = i + 1;
                break;
            }
            prev = now;
        }
        System.out.println(res);
    }
}
