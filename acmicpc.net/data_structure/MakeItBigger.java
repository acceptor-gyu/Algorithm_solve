package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class MakeItBigger {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Character> stack = new ArrayDeque<>();

        char[] numbers = br.readLine().toCharArray();

        stack.addLast(numbers[0]);

        for (int i = 1; i < N; i++) {

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && K > 0 && stack.peekLast() < numbers[i]) {
                    stack.pollLast();
                    K--;
                }
            }

            stack.addLast(numbers[i]);
        }

        while (K > 0) {
            stack.pollLast();
            K--;
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pollFirst());
        }
    }
}
