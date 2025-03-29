package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수의_연속합_1644 {

    private static boolean[] isPrime;
    private static List<Integer> primes = new ArrayList<>();;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        makePrimes(N);

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (start <= end && end < primes.size()) {
            if (sum < N) {
                sum += primes.get(end);
                end++;
            } else {
                if (sum == N) {
                    count++;
                }
                sum -= primes.get(start);
                start++;
            }
        }

        System.out.println(count);
    }

    private static void makePrimes(int N) {

        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        // 소수의 끝
        primes.add(0);
    }

}
