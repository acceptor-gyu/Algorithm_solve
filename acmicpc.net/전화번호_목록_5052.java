import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * NlogN
 */

public class 전화번호_목록_5052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] numbers = new String[n];

            for (int j = 0; j < n; j++) {
                numbers[j] = br.readLine();
            }

            Arrays.sort(numbers);

            sb.append(checkConsistency(numbers)).append("\n");
        }

        System.out.println(sb);
    }

    private static String checkConsistency(String[] numbers) {

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i].startsWith(numbers[i - 1])) {
                return "NO";
            }
        }
        return "YES";
    }
}
