package marathon.seventytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DORO {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String target = br.readLine();
        String answer = target.replace(" ", "DORO ");

        System.out.println(answer + "DORO");
    }
}
