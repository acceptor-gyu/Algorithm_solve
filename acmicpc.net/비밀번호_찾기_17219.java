import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호_찾기_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> pwMap = new HashMap<String, String>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pwMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(pwMap.get(br.readLine()));
        }


    }
}
