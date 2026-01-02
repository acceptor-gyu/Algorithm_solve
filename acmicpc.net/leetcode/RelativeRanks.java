package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRanks {

    public static void main(String[] args) {

        int[] scores = new int[]{5, 4, 3, 2, 1};

        String[] result = findRelativeRanks(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        int[] scores2 = new int[]{10, 3, 8, 9, 4};

        result = findRelativeRanks(scores2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static String[] findRelativeRanks(int[] score) {

        HashMap<Integer, String> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = score.length;

        for (int i = 0; i < n; i++) {
            pq.add(score[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                map.put(pq.poll(), "Gold Medal");
            }
            if (i == 1) {
                map.put(pq.poll(), "Silver Medal");
            }
            if (i == 2) {
                map.put(pq.poll(), "Bronze Medal");
            }
            if (i > 2) {
                map.put(pq.poll(), String.valueOf(i + 1));
            }
        }

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = map.get(score[i]);
        }

        return result;
    }

}
