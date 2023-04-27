import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Taxi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] groups = new int[n];
        int[] numOfEachGroups = new int[4];

        for (int i = 0; i < n; i++) {
            groups[i] = Integer.parseInt(st.nextToken());
            numOfEachGroups[groups[i] - 1]++;
        }

        int firstGroups = numOfEachGroups[3];   // 구성원이 4명인 그룹
        int secondGroups = numOfEachGroups[2];

        if (numOfEachGroups[2] >= numOfEachGroups[0]) {
            numOfEachGroups[0] = 0;
        } else {
            numOfEachGroups[0] -= secondGroups;
        }

        int thirdGroups = numOfEachGroups[1] / 2;

        if (numOfEachGroups[1] % 2 != 0) {
            thirdGroups++;
            if (numOfEachGroups[0] + 2 <= 4) {
                numOfEachGroups[0] = 0;
            } else {
                numOfEachGroups[0] -= 2;
            }
        }

        int fourthGroups = numOfEachGroups[0] / 4;
        if (numOfEachGroups[0] % 4 != 0) {
            fourthGroups++;
        }

        System.out.println(firstGroups + secondGroups + thirdGroups + fourthGroups);
    }
}
