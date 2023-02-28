import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한: 2초
 *
 * 8 <= N, M <= 50
 */

public class 체스판_다시_칠하기_1018 {

    private static boolean[][] board;
    private static int min = 64;

    private static void find(int x, int y) {
        int X = x + 8;
        int Y = y + 8;
        int count = 0;

        boolean now = board[x][y];

        for (int i = x; i < X; i++) {
            for (int j = y; j < Y; j++) {
                if (board[i][j] != now) {
                    count++;
                }
                now = !now;
            }
            now = !now;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int row = N - 7;
        int col = M - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }
}
