import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {

    static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {

            int photoSize = photo.length;
            Map<String, Integer> yearningMap = new HashMap<>();

            for (int i = 0; i < name.length; i ++) {
                yearningMap.put(name[i], yearning[i]);
            }

            int[] answer = new int[photoSize];

            for (int i = 0; i < photoSize; i++) {
                answer[i] = sumOfYearning(photo[i], yearningMap);
            }

            return answer;
        }

        private int sumOfYearning(String[] photoLine, Map<String, Integer> yearningMap) {
            int sum = 0;

            for (String name : photoLine) {
                if (yearningMap.containsKey(name)) {
                    sum += yearningMap.get(name);
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };

        int[] res = s.solution(name, yearning, photo);
        System.out.println(Arrays.toString(res));
    }
}
