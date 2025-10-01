package programmers;

public class NumberStringEnglish {

    public static void main(String[] args) {

        String[] s = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};

        for (int i = 0; i < 4; i++) {
            System.out.println(solution(s[i]));
        }
    }

    private static int solution(String s) {
        String[] strNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine"};

        for (int i = 0; i < strNum.length; i++) {
            s = s.replace(strNum[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}

