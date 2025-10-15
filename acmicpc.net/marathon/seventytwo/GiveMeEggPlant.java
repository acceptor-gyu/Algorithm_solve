package marathon.seventytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GiveMeEggPlant {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] eggPlants = new String[10][10];

        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                eggPlants[i][j] = st.nextToken();
            }
        }

        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < 10; i++) {
            rowCount = 0;
            colCount = 0;
            for (int j = 1; j < 10; j++) {
                // 행
                if (eggPlants[i][j].equals(eggPlants[i][j - 1])) {
                    rowCount++;
                }
                if (rowCount == 9) {
                    System.out.println(1);
                    return;
                }

                // 열
                if (eggPlants[j][i].equals(eggPlants[j - 1][i])) {
                    colCount++;
                }
                if (colCount == 9) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }

}
