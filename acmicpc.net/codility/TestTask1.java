package codility;

import java.util.Arrays;
import java.util.HashSet;

public class TestTask1 {

    public static void main(String[] args) {

        int[] A = {1, 3, 5, 4, 1, 2};

        HashSet<Integer> numbers = new HashSet<>();

        for (int i : A) {
            numbers.add(i);
        }

        A = new int[numbers.size()];

        int index = 0;
        for (Integer number : numbers) {
            A[index++] = number;
        }

        Arrays.sort(A);

        for (int i = 1; i <= A.length; i++) {

            if (A[i - 1] != i) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(A.length);
    }
}
