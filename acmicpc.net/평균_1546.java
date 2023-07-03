import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균_1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        double sum = 0;

        for (int score : scores) {
            sum += (double) score / max * 100;
        }

        double avg = sum / N;

        System.out.println(avg);
    }
}
