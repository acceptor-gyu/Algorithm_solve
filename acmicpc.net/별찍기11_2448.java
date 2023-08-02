import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기11_2448 {

    private static char[][] stars;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stars = new char[N][2 * N - 1];

        draw(0, N - 1, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                if (stars[i][j] != '*') {
                    stars[i][j] = ' ';
                }
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void draw(int r, int c, int N) {

        if (N == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = '*';
            stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = '*';
            stars[r + 2][c - 1] = '*';
            stars[r + 2][c] = '*';
            stars[r + 2][c + 1] = '*';
            stars[r + 2][c + 2] = '*';
            return;
        }

        int divide = N / 2;
        draw(r, c, divide);
        draw(r + divide, c - divide, divide);
        draw(r + divide, c + divide, divide);
    }

}
