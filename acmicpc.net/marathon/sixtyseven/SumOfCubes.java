package marathon.sixtyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfCubes {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 1부터 N까지의 합
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);

        // 1부터 N까지 합의 제곱
        System.out.println(sum * sum);

        // 1부터 N까지 수의 세제곱의 합
        sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i * i;
        }

        System.out.println(sum);
    }

}
