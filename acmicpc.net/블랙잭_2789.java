import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 조건
 * - 시간 제한: 1초
 *
 * 3 <= N <= 100
 * 10 <= M <= 300_000
 */

public class 블랙잭_2789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int temp = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    temp = numbers[i] + numbers[j] + numbers[k];
                    if (temp <= M && answer < temp) {
                        answer = temp;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
