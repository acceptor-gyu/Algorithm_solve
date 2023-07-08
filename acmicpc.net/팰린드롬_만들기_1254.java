import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬_만들기_1254 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string = br.readLine().toCharArray();

        int left = 0;
        int right = string.length - 1;
        int count = 0;
        int stamp = 0;

        while (left <= right) {

            if (string[left] == string[right]) {
                left++;
                right--;
            } else {
                count++;
                left = count;
                stamp = left;
                right = string.length - 1;
            }
        }

        System.out.println(string.length + stamp);

    }
}
