package marathon.eightythree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class POT_11772 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int target;
        long answer = 0;
        int square;
        int number;
        long temp;

        for (int i = 0; i < N; i++) {
            target = Integer.parseInt(br.readLine());
            temp = 1;
            square = target % 10;
            number = target / 10;

            for (int j = 0; j < square; j++) {
                temp *= number;
            }
            answer += temp;
        }
        System.out.println(answer);
    }

}
