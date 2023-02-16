import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 처음 인덱스와, 중요도를 갖고 있는 클래스를 만들려고 헀다.
 * "문제에서 맨 왼족은 0번쨰라고 하자" 라는 문장이
 * "배열을 사용하면 편할 것이다."라고 말하는 것같았다.
 * 로직에는 큰 차이가 없지만 문제에서 주려고하는 힌트?를 사용하려고 했다.
 */

public class 프린터_큐_1966 {

    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N, M;
        int count = 0;
        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                deque.addLast(new int[]{j, Integer.parseInt(st.nextToken())});
            }

        }

    }
}
