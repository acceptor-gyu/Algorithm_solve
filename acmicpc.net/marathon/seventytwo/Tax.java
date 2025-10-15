package marathon.seventytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tax {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double general = 1 - 0.22;
        double special = 1 - 0.2 * 0.22;

        System.out.println((int) (N * general) + " " + (int) (N * special));
    }

}
