package programmers;

public class SecretMap {

    private static Character[][] map;
    private static char wall = '#';
    private static char space = ' ';

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result;
        result = solution(n, arr1, arr2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);


        n = 6;
        int[] arr3 = {46, 3, 33, 22, 31, 50};
        int[] arr4 = {27, 56, 19, 14, 14, 10};

        result = solution(n, arr3, arr4);

        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {

        map = new Character[n][n];
        String[] binary = new String[n];
        int decimal;
        StringBuilder sb;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count = 0;
            sb = new StringBuilder();
            decimal = arr1[i];
            while (decimal > 0) {
                sb.append(decimal % 2);
                decimal /= 2;
                count++;
            }
            while (count < n) {
                sb.append('0');
                count++;
            }
            binary[i] = sb.reverse().toString();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = binary[i].charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            count = 0;
            sb = new StringBuilder();
            decimal = arr2[i];
            while (decimal > 0) {
                sb.append(decimal % 2);
                decimal /= 2;
                count++;
            }
            while (count < n) {
                sb.append('0');
                count++;
            }
            binary[i] = sb.reverse().toString();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '0') {
                    map[i][j] = binary[i].charAt(j);
                }
            }
        }

        String[] answer = new String[n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1') {
                    map[i][j] = wall;
                } else {
                    map[i][j] = space;
                }
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
