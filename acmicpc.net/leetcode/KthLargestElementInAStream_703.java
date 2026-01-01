package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {

    private static class KthLargest {
        int k;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.k = k;

            for(int num : nums) pq.add(num);

            while(pq.size() > k) pq.poll();
        }

        public int add(int val) {
            pq.add(val);

            if(pq.size() > k) pq.poll();

            return pq.peek();
        }
    }

    public static void main(String[] args) {

        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));

        KthLargest obj2 = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
        System.out.println(obj2.add(2));
        System.out.println(obj2.add(10));
        System.out.println(obj2.add(9));
        System.out.println(obj2.add(9));
    }
}
