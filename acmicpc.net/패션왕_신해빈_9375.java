import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 패션왕_신해빈_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                int count;
                if (hashMap.containsKey(type)) {
                    count = hashMap.get(type);
                    count++;
                    hashMap.put(type, count);
                    continue;
                }
                hashMap.put(type, 1);
            }
            int res = 1;
            for (String s : hashMap.keySet()) {
                res = res * (hashMap.get(s) + 1);
            }
            sb.append(res - 1).append("\n");
            hashMap.clear();
        }
        System.out.println(sb);
    }
}
