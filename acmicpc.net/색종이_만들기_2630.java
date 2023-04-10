import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기_2630 {

    private static int numOfWhite;
    private static int numOfBlue;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numOfWhite = 0;
        numOfBlue = 0;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);


        System.out.println(numOfWhite);
        System.out.println(numOfBlue);
    }

    private static void solve(int row, int col, int size) {
        if (areSameColor(row, col, size)) {
            if (paper[row][col] == 0) {
                numOfWhite++;
                return;
            }
            if (paper[row][col] == 1) {
                numOfBlue++;
                return;
            }
        }

        size /= 2;

        solve(row, col, size);
        solve(row + size, col, size);
        solve(row, col + size, size);
        solve(row + size, col + size, size);
    }

    private static boolean areSameColor(int row, int col, int size) {

        int prev = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                int now = paper[i][j];
                if (prev != now) {
                    return false;
                }
                prev = now;
            }
        }

        return true;
    }
}
