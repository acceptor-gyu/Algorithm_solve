import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치_7568 {

    public static int rank(int[][] list, int n) {
        int count = 1;
        for (int i = 0; i < list.length; i++) {
            if (list[n][0] < list[i][0] && list[n][1] < list[i][1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][3];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < list.length; i++) {
            list[i][2] = rank(list, i);
            sb.append(list[i][2]).append(" ");
        }
        System.out.println(sb);
    }
}
