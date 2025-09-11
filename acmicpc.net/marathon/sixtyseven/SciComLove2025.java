package marathon.sixtyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SciComLove2025 {

    private static final char[] answer = "SciComLove".toCharArray();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = br.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < answer.length; i++) {
            if (target[i] != answer[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
