package marathon.seventeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber_21144 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] numbers = br.readLine().toCharArray();

        int sequence = 1;

        for (int i = 0; i < numbers.length;) {

            char[] temp = Integer.toString(sequence).toCharArray();

            for (int j = 0; j < temp.length; j++) {
                if (numbers[i] != temp[j]) {
                    System.out.println(sequence);
                    return;
                }
                i++;
            }
            sequence++;
        }
        System.out.println(sequence);
    }
}
