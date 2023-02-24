import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class 쇠막대기_10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> deque = new ArrayDeque<>();

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');

        char[] input = br.readLine().toCharArray();

        int count = 0;
        char prev = input[0];
        deque.addLast(prev);
        for (int i = 1; i < input.length ; i++) {
            if (hashMap.containsKey(input[i])) {
                deque.addLast(input[i]);
            }
            if (prev == '(' && input[i] == ')'){
                deque.pollLast();
                count += deque.size();
            }
            if (prev == ')' && input[i] == ')') {
                deque.pollLast();
                count += 1;
            }

            prev = input[i];

        }

        System.out.println(count);
    }
}