import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {

    private static int N;
    private static boolean[][] location;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        location = new boolean[N][N];

        backtrack(0, 0, 0);

        System.out.println(count);
    }

    private static void backtrack(int r, int c, int placed) {

        if (placed == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!location[i][j]) {
                    unableToPlace(i, j);
                    backtrack(i, j, placed + 1);
                    ableToPlace(i, j);
                }
            }
        }
    }

    private static void unableToPlace(int r, int c) {

        for (int i = 0; i < N; i++) {
            location[r][i] = true;
            location[i][c] = true;
        }

        int nextR = r;
        int nextC = c;

        while (true) {
            if ((nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)) {
                break;
            }
            location[nextR++][nextC++] = true;
        }

        nextR = r;
        nextC = c;

        while (true) {
            if ((nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)) {
                break;
            }
            location[nextR++][nextC--] = true;
        }
    }

    private static void ableToPlace(int r, int c) {

        for (int i = 0; i < N; i++) {
            location[r][i] = false;
            location[i][c] = false;
        }

        int nextR = r;
        int nextC = c;

        while (true) {
            if ((nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)) {
                break;
            }
            location[nextR++][nextC++] = false;
        }

        nextR = r;
        nextC = c;

        while (true) {
            if ((nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)) {
                break;
            }
            location[nextR++][nextC--] = false;
        }
    }
}
