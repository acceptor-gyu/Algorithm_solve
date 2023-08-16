package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 선_긋기_2170 {

    private static class Line {

        int x, y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Line> pq;

        Comparator<Line> comparator = Comparator.comparing(Line::getX)
                .thenComparing(Line::getY);

        pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Line(x, y));
        }

        int res = 0;
        int start = pq.peek().getX();
        int end = pq.peek().getY();

        while (!pq.isEmpty()) {
            Line line = pq.poll();

            if (line.getX() <= end) {
                end = Math.max(end, line.getY());
            } else {
                res += end - start;
                start = line.getX();
                end = line.getY();
            }
        }

        res += end - start;

        System.out.println(res);
    }
}
