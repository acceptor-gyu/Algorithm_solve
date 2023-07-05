import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 찾기_1786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        int[] patternNumbers = new int[P.length()];
        List<Integer> answers = new ArrayList<>();

        int patternSize = P.length();
        int idx = 0;

        for (int i = 1; i < patternSize; i++) {

            while (idx > 0 && P.charAt(i) != P.charAt(idx)) {
                idx = patternNumbers[idx - 1];
            }

            if (P.charAt(i) == P.charAt(idx)) {
                idx++;
                patternNumbers[i] = idx;
            }
        }

        int tSize = T.length();
        idx = 0;

        for (int i = 0; i < tSize; i++) {

            while (idx > 0 && T.charAt(i) != P.charAt(idx)) {
                idx = patternNumbers[idx - 1];
            }

            if (T.charAt(i) == P.charAt(idx)) {
                if (idx == patternSize - 1) {
                    answers.add(i - idx + 1);
                    idx = patternNumbers[idx];
                } else {
                    idx += 1;
                }
            }
        }

        System.out.println(answers.size());

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}
