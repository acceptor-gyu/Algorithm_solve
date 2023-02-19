import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> origin = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            origin.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            res.add(origin.get(i));
        }

        Collections.sort(res);

        int count = 0;
        for (int i : res) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Integer integer : origin) {
            sb.append(hashMap.get(integer)).append(" ");
        }

        System.out.println(sb);
    }
}
