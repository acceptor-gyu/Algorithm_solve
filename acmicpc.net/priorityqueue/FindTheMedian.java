package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindTheMedian {

    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // maxHeap에는 중앙값보다 작거나 같은 값 삽입 (e.g. 3, 2, 1)
        // minHeap에는 중앙값보다 크거나 같은 값 삽입 (e.g. 4, 5, 6)
        // -> 총 원소의 개수가 홀수인 경우, 크기가 큰 heap의 루트가 중앙값
        for (int i = 0; i < T; i++) {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();

            int M = Integer.parseInt(br.readLine());
            sb.append(M / 2 + 1).append("\n");
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                addNumber(Integer.parseInt(st.nextToken()));
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                if (j % 2 == 1) {
                    sb.append(maxHeap.peek()).append(" ");
                }
                if (j % 20 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void addNumber(int number) {

        if (maxHeap.isEmpty() || number <= maxHeap.peek()) {
            maxHeap.add(number);
        } else {
            minHeap.add(number);
        }

        // 두 큐의 크기 조정
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
