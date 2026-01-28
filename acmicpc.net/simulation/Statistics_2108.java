package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistics_2108 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int average = getAverage(numbers);
        int middle = getMiddleNumber(numbers);
        int mode = getMode(numbers); // 최빈값
        int range = getRange(numbers);

        System.out.println(average);
        System.out.println(middle);
        System.out.println(mode);
        System.out.println(range);
    }

    private static int getAverage(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += numbers[i];
        }

        return (int) Math.round((double) sum / N);
    }

    private static int getMiddleNumber(int[] numbers) {

        Arrays.sort(numbers);
        return numbers[N /2];
    }

    private static int getMode(int[] numbers) {

        // -4,000 ~ 4,000 (-4,000 -> index 0 ~ ...)
        int[] counts = new int[8001];
        int max = 0;

        for (int i = 0; i < N; i++) {
            counts[numbers[i] + 4000]++;
            if (counts[numbers[i] + 4000] > max) {
                max = counts[numbers[i] + 4000];
            }
        }

        int mode = 0;
        int count = 0;

        for (int i = 0; i < 8001; i++) {
            if (counts[i] == max) {
                mode = i - 4000;
                count++;
                // 최빈값이 여러 개인 경우, 두 번째로 작은 값
                if (count == 2) {
                    break;
                }
            }
        }

        return mode;
    }

    private static int getRange(int[] numbers) {

        Arrays.sort(numbers);
        return numbers[N -1] - numbers[0];
    }
}
