import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> neverHeardSeen = new HashMap<>();
        HashMap<String, Integer> neverHeard = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            neverHeard.put(br.readLine(), i);
        }

        for (int i = 0; i < M; i++) {
            String value = br.readLine();
            if (neverHeard.containsKey(value)) {
                neverHeardSeen.put(value, i);
            }
        }

        List<String> list = new ArrayList<>(neverHeardSeen.keySet());

        Collections.sort(list);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
