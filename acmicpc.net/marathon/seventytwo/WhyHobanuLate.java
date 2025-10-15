package marathon.seventytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhyHobanuLate {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;

        for (int i = 0; i < 4; i++) {
            total += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(Integer.parseInt(st.nextToken()) * 4 - total, 0));
    }
}
