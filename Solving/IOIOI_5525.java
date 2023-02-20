import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * substring 메서드는 시간복잡도가 O(N)이기 때문에
 * substring 메서드를 사용하면 50점 밖에 맞지 못한다.
 */

public class IOIOI_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int switched = 0;
        int count = 0;

        for (int i = 0; i < s.length; i++) {

        }




        System.out.println(count);
    }
}
