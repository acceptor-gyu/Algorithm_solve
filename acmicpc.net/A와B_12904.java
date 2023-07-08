import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A와B_12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (Character c : T.toCharArray()) {
            deque.addLast(c);
        }

        boolean forward = true;

        while (deque.size() > S.length()) {

            if (forward) {
                if (deque.peekLast() == 'A') {
                    deque.pollLast();
                } else {
                    deque.pollLast();
                    forward = false;
                }
            } else {
                if (deque.peekFirst() == 'A') {
                    deque.pollFirst();
                } else {
                    deque.pollFirst();
                    forward = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = deque.size();

        if (forward) {
            for (int i = 0; i < size; i++) {
                sb.append(deque.pollFirst());
            }
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(deque.pollLast());
            }
        }

        if (sb.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
