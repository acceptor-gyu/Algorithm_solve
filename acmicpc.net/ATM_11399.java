import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] person = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);

        for (int i = 1; i < N; i++) {
            person[i] = person[i] + person[i - 1];
        }

        int wait = 0;
        for (int i = 0; i < N; i++) {
            wait += person[i];
        }
        System.out.println(wait);
    }
}
