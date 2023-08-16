package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 강의실_배정_11000 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] lecture = br.readLine().split(" ");

            lectures[i][0] = Integer.parseInt(lecture[0]);
            lectures[i][1] = Integer.parseInt(lecture[1]);
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }

            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i][0]) {
                pq.poll();
            }

            pq.add(lectures[i][1]);
        }

        System.out.println(pq.size());
    }
}
