import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 오큰수_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] answer = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= num[i]) {
                stack.pollLast();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();

            stack.addLast(num[i]);
        }

        for (int i : answer) {
            bw.write(i + " ");
        }

        bw.flush();
    }
}