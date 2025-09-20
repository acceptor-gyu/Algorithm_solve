package marathon.sixtyeight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NthLargestNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int size = 10;
        int n = 3;

        StringTokenizer st;
        int[] A = new int[size];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            System.out.println(A[size - n]);
        }
    }

}
