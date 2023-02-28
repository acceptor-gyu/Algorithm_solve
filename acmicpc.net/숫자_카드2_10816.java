import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 시간 제한: 1초
 *
 * 1 <= N <= 500_000
 * 1 <= M <= 500_000
 * 들어오는 입력값은 int 타입으로 해결 가능
 * 합 또는 곱을 구하다가 int 타입에서 오버플로우가 날 수 있나? -> 없을 것같다.
 */

public class 숫자_카드2_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(now)) {
                int temp = hashMap.get(now);
                temp++;
                hashMap.put(now, temp);
            } else {
                hashMap.put(now, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(now)) {
                sb.append(hashMap.get(now)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
