import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중_우선순위_큐_7662 {

    private static void insertToHashMap(HashMap<Integer, Integer> hashMap, int n) {
        if (hashMap.containsKey(n)) {
            int temp = hashMap.get(n);
            hashMap.put(n, temp + 1);
        } else {
            hashMap.put(n, 1);
        }
    }

    private static void deleteFromHashMap(HashMap<Integer, Integer> hashMap, int n) {
        if (hashMap.get(n) > 1) {
            int temp = hashMap.get(n);
            hashMap.put(n, temp - 1);

        } else {
            hashMap.remove(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> asecPq = new PriorityQueue<>();
        PriorityQueue<Integer> dsecPq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            StringTokenizer st;
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "I" :
                        insertToHashMap(hashMap, num);
                        asecPq.add(num);
                        dsecPq.add(num);
                        break;
                    case "D" :
                        if (hashMap.isEmpty()) {
                            break;
                        }
                        if (num == 1) {
                            int n = dsecPq.poll();
                            while (!hashMap.containsKey(n)) {
                                n = dsecPq.poll();
                            }
                            deleteFromHashMap(hashMap, n);
                            break;
                        }
                        if (num == -1) {
                            int n = asecPq.poll();
                            while (!hashMap.containsKey(n)) {
                                n = asecPq.poll();
                            }
                            deleteFromHashMap(hashMap, n);
                            break;
                        }
                }
            }
            if (hashMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int n = dsecPq.poll();
                int m = asecPq.poll();
                while (!hashMap.containsKey(n)) {
                    n = dsecPq.poll();
                }
                while (!hashMap.containsKey(m)) {
                    m = asecPq.poll();
                }
                sb.append(n).append(" ").append(m).append("\n");
            }
            hashMap.clear();

        }
        System.out.println(sb);
    }
}
