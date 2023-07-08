import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문_17609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int left, right;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {

            char[] target = br.readLine().toCharArray();

            left = 0;
            right = target.length - 1;

            while (left <= right) {
                if (target[left] == target[right]) {

                    if (right - left <= 1) {
                        sb.append(0).append("\n");
                    }

                    left++;
                    right--;
                    continue;
                }

                if (isPalindrome(left + 1, right, target) || isPalindrome(left, right - 1, target)) {
                    sb.append(1).append("\n");
                    break;
                }

                sb.append(2).append("\n");
                break;
            }
        }

        System.out.println(sb);
    }

    private static boolean isPalindrome (int left, int right, char[] target) {

        while (left <= right) {

            if (target[left] != target[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
