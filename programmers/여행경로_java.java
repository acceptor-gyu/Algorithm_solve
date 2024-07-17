import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.stream.IntStream;

public class 여행경로_java {

    private class Node {

        String now;
        String visited;
        boolean[] checked;

        public Node(String now, String visited, boolean[] checked) {
            this.now = now;
            this.visited = visited;
            this.checked = checked;
        }
    }

    public String[] solution(String[][] tickets) {

        ArrayList<String> answer = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node("ICN", "ICN", new boolean[tickets.length]));

        while (!queue.isEmpty()) {

            Node now = queue.poll();
            long count = 0;
            for (int i = 0; i < now.checked.length; i++) {
                if (!now.checked[i]) {
                    count++;
                }
            }

            if (count == 0) {
                answer.add(now.visited);
                continue;
            }

            for (int i = 0; i < tickets.length; i++) {

                boolean[] checked = Arrays.copyOf(now.checked, now.checked.length);

                if (!checked[i] && tickets[i][0].equals(now.now)) {
                    checked[i] = true;
                    queue.add(new Node(tickets[i][1], now.visited + "," + tickets[i][1], checked));
                }
            }

        }

        Collections.sort(answer);

        return answer.get(0).split(",");
    }
}
