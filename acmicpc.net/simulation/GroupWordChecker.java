package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWordChecker {

    static int numberOfAlphabet = 26;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        String target;
        boolean[] checker;

        for (int i = 0; i < N; i++) {
            checker = new boolean[numberOfAlphabet];
            target = br.readLine();

            if (check(checker, target)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(boolean[] checker, String target) {

        checker[target.charAt(0) - 'a'] = true;

        for (int j = 1; j < target.length(); j++) {

            if (target.charAt(j) == target.charAt(j - 1)) {
                continue;
            }
            // 이전 알파벳과 다르면서 이전에 사용한 알파벳이라면 정답 X
            if (checker[target.charAt(j) - 'a']) {
                return false;
            }

            checker[target.charAt(j) - 'a'] = true;
        }

        return true;
    }

}
