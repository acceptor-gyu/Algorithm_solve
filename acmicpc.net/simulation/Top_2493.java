package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Top_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        /**
         * 5
         * 6 9 5 7 4
         * 입력이 들어오면 (6, 1), (9, 2), ... 방식으로 관리한다.
         */
        Deque<int[]> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
        }


        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peekLast()[0] <= numbers[i]) {
                stack.pollLast();
            }
            int ans = stack.isEmpty() ? 0 : stack.peekLast()[1];
            sb.append(ans).append(" ");
            stack.addLast(new int[] {numbers[i], i + 1});
        }
        System.out.println(sb);
    }
}
