import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최대 5자리의 수까지 검사하기 때문에 오버플로우를 걱정하지 않아도 된다.
 */

public class 팰린드롬수_1259 {

    public static String isPalindrome(int num) {

        int origin = num;
        int res = 0;

        while (num != 0) {
            res = res * 10 + num % 10;
            num = num / 10;
        }

        if (res == origin) {
            return "yes";
        }
        return "no";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        while (true) {
            T = Integer.parseInt(br.readLine());
            if (T == 0) {
                break;
            }
            System.out.println(isPalindrome(T));
        }
    }
}
