import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {

    private static int N;
    private static int[] location;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        location = new int[N];

        backtrack(0);

        System.out.println(count);
    }

    private static void backtrack(int placed) {

        if (placed == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            location[placed] = i;

            if (placeable(placed)) {
                backtrack(placed + 1);
            }
        }
    }

    private static boolean placeable(int placed) {

        for (int i = 0; i < placed; i++) {
            if (location[placed] == location[i]) {
                return false;
            }
            if (Math.abs(placed - i) == Math.abs(location[placed] - location[i])) {
                return false;
            }
        }

        return true;
    }
}
