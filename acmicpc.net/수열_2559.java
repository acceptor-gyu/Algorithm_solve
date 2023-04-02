import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += nums[i];
        }

        int answer = sum;
        int left = 0;
        int right = K;

        for (int i = K; i < N; i++) {
            sum += nums[right];
            sum -= nums[left];
            right += 1;
            left += 1;
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
