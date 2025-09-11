package marathon.sixtyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascent {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");

        int min = -1000000;

        for (int i = 0; i < numbers.length; i++) {
            if (min <= Integer.parseInt(numbers[i])) {
                min = Integer.parseInt(numbers[i]);
                if (i == numbers.length - 1) {
                    System.out.println("Good");
                }
            } else {
                System.out.println("Bad");
                break;
            }
        }
    }
}
