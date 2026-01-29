package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame_3085 {
    static int n;
    static char[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 1. 초기 상태 체크 (안 하면 틀릴 수 있음)
        for (int i = 0; i < n; i++) {
            checkRow(i);
            checkCol(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 가로 교환: 해당 행 + 바뀐 두 열 체크
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    checkRow(i);
                    checkCol(j);
                    checkCol(j + 1);
                    swap(i, j, i, j + 1);
                }
                // 세로 교환: 해당 열 + 바뀐 두 행 체크
                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    checkCol(j);
                    checkRow(i);
                    checkRow(i + 1);
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    static void checkRow(int r) {
        int cnt = 1;
        for (int j = 0; j < n - 1; j++) {
            if (board[r][j] == board[r][j + 1]) cnt++;
            else { max = Math.max(max, cnt); cnt = 1; }
        }
        max = Math.max(max, cnt);
    }

    static void checkCol(int c) {
        int cnt = 1;
        for (int i = 0; i < n - 1; i++) {
            if (board[i][c] == board[i + 1][c]) cnt++;
            else { max = Math.max(max, cnt); cnt = 1; }
        }
        max = Math.max(max, cnt);
    }
}
