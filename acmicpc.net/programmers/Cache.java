package programmers;

import java.util.ArrayDeque;

public class Cache {

    public static void main(String[] args) {
        System.out.println(solution(3,
            new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul",
                "NewYork", "LA"}));
    }

    private static int solution(int cacheSize, String[] cities) {

        int answer = 0;
        ArrayDeque<String> queue = new ArrayDeque<>(cacheSize);

        for (String city : cities) {
            city = city.toUpperCase();
            // hit
            if (queue.contains(city)) {
                if (queue.remove(city))
                    ;
                queue.add(city);
                answer += 1;
            }
            // miss
            else {
                queue.add(city);
                if (queue.size() > cacheSize) {
                    queue.poll();
                }
                answer += 5;
            }
        }
        return answer;
    }
}
