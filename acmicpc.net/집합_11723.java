import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 집합_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] S = new int[21];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    S[j] = j;
                }
                continue;
            }

            if (cmd.equals("empty")) {
                Arrays.fill(S, 0);
                continue;
            }

            int x = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case "add" :
                    if (S[x] != 0) {
                        break;
                    }
                    S[x] = x;
                    break;
                case "remove" :
                    if (S[x] == 0) {
                        break;
                    }
                    S[x] = 0;
                    break;
                case "check" :
                    if (S[x] == 0) {
                        sb.append("0\n");
                        break;
                    }
                    sb.append("1\n");
                    break;
                case "toggle" :
                    if (S[x] == 0) {
                        S[x] = x;
                        break;
                    }
                    S[x] = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
