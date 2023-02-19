import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> pocketMonsters = new HashMap<String, String>();

        for (int i = 1; i <= N; i++) {
            pocketMonsters.put(br.readLine(), String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String value = br.readLine();

            if (pocketMonsters.containsKey(value)) {
                System.out.println(pocketMonsters.get(value));
                continue;
            }

            for (Map.Entry<String, String> entry : pocketMonsters.entrySet()) {
                if (entry.getValue().equals(value)) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
