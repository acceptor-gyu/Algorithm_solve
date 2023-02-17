import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기4_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] given = new int[N];
        int[] acc = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            given[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                acc[i] = given[i];
            } else {
                acc[i] = given[i] + acc[i - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == 1) {
                System.out.println(acc[end - 1]);
            } else {
                System.out.println(acc[end - 1] - acc[start - 2]);
            }
        }
    }
}
