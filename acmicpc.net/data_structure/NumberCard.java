package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NumberCard {

    public static void main(String[] args) throws IOException {

        int n, m;
        int[] cards;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            set.add(cards[i]);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        // binary search


        Arrays.sort(cards);
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.print(binarySearch(cards, target) + " ");
            if (set.contains(target)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }

    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }

}
