import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IQTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int numOfEven = 0;
        int evenTarget = 0;
        int numOfOdd = 0;
        int oddTarget = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                numOfEven++;
                evenTarget = i + 1;
            } else {
                numOfOdd++;
                oddTarget = i + 1;
            }
        }

        if (numOfEven == 1) {
            System.out.println(evenTarget);
        }
        if (numOfOdd == 1) {
            System.out.println(oddTarget);
        }
    }
}
