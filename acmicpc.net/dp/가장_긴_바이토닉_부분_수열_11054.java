package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_긴_바이토닉_부분_수열_11054 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lisDp = new int[N];
        int[] ldsDp = new int[N];

        for (int i = 0; i < N; i++) {

            lisDp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lisDp[i] < lisDp[j] + 1) {
                    lisDp[i] = lisDp[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {

            ldsDp[i] = 1;

            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && ldsDp[i] < ldsDp[j] + 1) {
                    ldsDp[i] = ldsDp[j] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            if (lisDp[i] + ldsDp[i] > max) {
                max = lisDp[i] + ldsDp[i];
            }
        }

        System.out.println(max - 1);
    }
}
