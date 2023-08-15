package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기_1715 {

    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N - 1; i++) {
            operate(pq);
        }

        System.out.println(sum);
    }

    private static PriorityQueue<Integer> operate(PriorityQueue<Integer> pq) {

        int now = pq.poll();
        int next = pq.poll();

        sum += now + next;
        pq.add(now + next);

        return pq;
    }
}
