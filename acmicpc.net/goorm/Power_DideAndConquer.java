package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Power_DideAndConquer {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // f(n) == 2 * f(n - 2) (n번째 가는 방법은 (n-2)번째에서 바로 n으로 가는 방법 + (n-1)번째를 들렀다 가는 방법)
        // -> f(n) - > 2^(n-2)
        // overflow를 고려해 *2 마다 % 1000000007

        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        // 밑
        long base = 2;
        long mod = 1_000_000_007;

        n = n - 2;
        long result = 1;
        base %= mod;

        // O(logN)
        while (n > 0) {
            // n이 홀수인 경우 현재까지의 base를 결과에 곱함.
            if (n % 2 == 1) {
                result = (result * base) % mod;
            }
            // n을 절반으로 줄이고 base를 제곱 (divide and conquer)
            base = (base * base) % mod;
            n /= 2;
        }

        System.out.println(result);
    }
}
