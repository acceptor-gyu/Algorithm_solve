package marathon.eighty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sangsu_2908 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        StringBuilder invertedA = new StringBuilder();
        StringBuilder invertedB = new StringBuilder();

        for (int i = 1; i <= A.length(); i++) {
            invertedA.append(A.charAt(A.length() - i));
            invertedB.append(B.charAt(B.length() - i));
        }

        System.out.println(Math.max(Integer.parseInt(invertedA.toString()), Integer.parseInt(invertedB.toString())));
    }

}
