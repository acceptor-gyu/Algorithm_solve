package marathon.seventeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SectionBiggerThanK_14246 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] numbers = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());

        }

        int k = Integer.parseInt(br.readLine());

        long answer = 0;

        int start = 0;
        int end = 0;
        long sum = numbers[end];

        while (end < n) {

           if (sum > k) {
               answer += n - end;

               sum -= numbers[start];
               start++;

               if (start > end) {
                   end++;

                   if (end == n) break;
                   sum += numbers[end];
               }
               continue;
           }
           end++;
           if (end == n) break;
           sum += numbers[end];
        }

        System.out.println(answer);
    }
}
