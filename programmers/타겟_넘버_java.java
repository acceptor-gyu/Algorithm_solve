import java.util.ArrayDeque;
import java.util.Queue;

public class 타겟_넘버_java {

    public int solution(int[] numbers, int target) {

        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        for (int i = 0; i < numbers.length; i++) {

            int size = queue.size();

            for (int j = 0; j < size; j++) {

                int now = queue.poll();

                queue.add(now + numbers[i]);
                queue.add(now - numbers[i]);
            }
        }

        while (!queue.isEmpty()) {

            if (queue.poll() == target) {
                answer++;
            }
        }

        return answer;
    }
}
