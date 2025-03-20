package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sudoku_2239 {

    private static int[][] map = new int[9][9];
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        backtrack(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static boolean backtrack(int count) {

        if (count == list.size()) {
            return true;
        }

        int x = list.get(count)[0];
        int y = list.get(count)[1];

        for (int i = 1; i < 10; i++) {
            map[x][y] = i;
            if (possible(x, y) && backtrack(count + 1))
                return true;
        }
        
        // 원복하고 false 반환
        map[x][y] = 0;
        return false;
    }

    private static boolean possible(int x, int y) {

        for (int i = 0; i < 9; i++) {
            
            // 같은 행에 같은 숫자가 있다면 false 반환
            if (y != i && map[x][y] == map[x][i])
                return false;
            // 같은 열에 같은 숫자가 있다면 false 반환
            if (x != i && map[x][y] == map[i][y])
                return false;
        }
        
        // (x, y)가 포함되는 3x3 정사각형 내에 같은 숫자가 있으면 false 반환
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (i != x && j != y && map[i][j] == map[x][y])
                    return false;
            }
        }
        
        return true;
    }

}
