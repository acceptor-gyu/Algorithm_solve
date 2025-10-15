package marathon.seventytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirrorOhMirror {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String s = br.readLine();

            if (s.equals("***")) {
                break;
            }

            sb.append(new StringBuilder(s).reverse());
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
