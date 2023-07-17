import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class 괄호의_값_2504 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] parentheses = br.readLine().toCharArray();

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();

        int acc = 0;
        int temp = 1;

        for (int i = 0; i < parentheses.length; i++) {

            char now = parentheses[i];

            if (map.containsKey(now)) {
                stack.addLast(now);
                temp *= now == '(' ? 2 : 3;
            } else {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                if (now != map.get(stack.pollLast())) {
                    System.out.println(0);
                    return;
                }

                if (parentheses[i - 1] == '(' || parentheses[i - 1] == '[') {
                    acc += temp;
                }

                if (parentheses[i] == ')') {
                    temp /= 2;
                }
                if (parentheses[i] == ']') {
                    temp /= 3;
                }
            }

        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(acc);
    }
}
