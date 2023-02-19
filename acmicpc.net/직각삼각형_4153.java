import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직각삼각형_4153 {

    public static boolean isRight(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (isRight(a, b, c) || isRight(a, c, b) || isRight(c, b, a)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }

        }
        System.out.println(sb);
    }
}
