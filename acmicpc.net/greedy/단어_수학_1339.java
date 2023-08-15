package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어_수학_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        // 단어의 최대 길이가 8이기 때문에 Integer 범위를 넘어가지 않는다.
        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            int length = word.length();

            for (int i = 0; i < length; i++) {
                char alphabet = word.charAt(i);
                map.put(alphabet, map.getOrDefault(alphabet, 0) + (int) Math.pow(10, length - i - 1));
            }
        }

        int[] numbers = new int[map.size()];
        int index = 0;

        for (int value : map.values()) {
            numbers[index++] = value;
        }

        Arrays.sort(numbers);

        int result = 0;
        int num = 10 - numbers.length;
        for (int number : numbers) {
            result += number * num++;
        }

        System.out.println(result);
    }
}
