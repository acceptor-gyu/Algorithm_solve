import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] key = new String[N + 1];
        int[] value = new int[N + 1];
        Map<String, Integer> pocketMonsters = new HashMap<String, Integer>();

        for (int i = 1; i <= N; i++) {
            key[i] = br.readLine();
            value[i] = i;
            pocketMonsters.put(key[i], i);
        }

        for (int i = 0; i < M; i++) {
            String whatNum = br.readLine();
            if (pocketMonsters.containsKey(whatNum)) {
                System.out.println(pocketMonsters.get(whatNum));
                continue;
            }

            int whatMonster = Integer.parseInt(whatNum);

            System.out.println(key[whatMonster]);
        }
    }
}
