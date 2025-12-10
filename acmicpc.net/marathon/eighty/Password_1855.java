package marathon.eighty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password_1855 {

    /**
     k = 3
     0 1 2
     5 4 3
     6 7 8
     11 10 9
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String crypted = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < crypted.length() / k; j++) {
                if (j % 2 == 0) {
                    sb.append(crypted.charAt(j * k + i));
                } else {
                    sb.append(crypted.charAt(j * k + k - 1 - i));
                }
            }
        }
        System.out.println(sb);
    }
}
