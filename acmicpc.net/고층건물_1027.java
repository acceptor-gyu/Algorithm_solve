import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물_1027 {

    private static int[] buildings;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        buildings = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, getVisibleBuildings(i));
        }

        System.out.println(max);
    }

    private static int getVisibleBuildings(int now) {

        double temp = 0;
        int visibleBuildings = 0;

        for (int i = now - 1; i >= 0; i--) {
            double inclination = (double) (buildings[now] - buildings[i]) / (double) (now - i);

            if (i == now - 1 || temp > inclination) {
                visibleBuildings++;
                temp = inclination;
            }
        }

        for (int i = now + 1; i < N ; i++) {
            double inclination = (double) (buildings[now] - buildings[i]) / (double) (now - i);

            if (i == now + 1 || temp < inclination) {
                visibleBuildings++;
                temp = inclination;
            }
        }

        return visibleBuildings;
    }
}
