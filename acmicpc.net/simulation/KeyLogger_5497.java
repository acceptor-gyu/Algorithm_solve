package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class KeyLogger_5497 {

    public static void main(String[] args) throws IOException {

        /**
         * 두 개의 deque를 준비한다. (큐의 add, poll은 시간복잡도 O(N))
         *
         * 문자가 입력되면 1번 deque의 뒤에 넣는다
         * < 가 입력되면 1번 deque의 뒤에서 꺼내 2번 deque의 앞에 넣는다
         * > 가 입력되면 2번 deque의 앞에서 꺼내 1번 deque의 뒤에 넣는다
         * -가 입력되면 1번 Deque의 뒤에서 꺼내 버린다.
         *
         * 꺼낼 떄 empty() 검사 필수
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Deque<Character> forward;
        Deque<Character> backward;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            char[] keyLog = br.readLine().toCharArray();
            forward = new ArrayDeque<>();
            backward = new ArrayDeque<>();
            for (char key : keyLog) {
                if (key == '<') {
                    if (!forward.isEmpty()) {
                        backward.addFirst(forward.pollLast());
                    }
                    continue;
                }
                if (key == '>') {
                    if (!backward.isEmpty()) {
                        forward.addLast(backward.pollFirst());
                    }
                    continue;
                }
                if (key == '-') {
                    if (!forward.isEmpty()) {
                        forward.pollLast();
                    }
                    continue;
                }
                forward.addLast(key);
            }

            for (Character c : forward) {
                sb.append(c);
            }
            for (Character c : backward) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
