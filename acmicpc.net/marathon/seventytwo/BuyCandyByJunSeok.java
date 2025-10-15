package marathon.seventytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuyCandyByJunSeok {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] candies = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;

        for (int i = 0; i < N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            total += candies[i];
        }

        if (total % 2 == 0) {
            System.out.println(total);
            return;
        }

        Arrays.sort(candies);

        for (int i = 0; i < N; i++) {
            if (candies[i] % 2 == 1) {
                total -= candies[i];
                System.out.println(total);
                break;
            }
        }
    }

}
