package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GearWheel_14891 {

    static int[][] gears;
    static int[] point;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1번 기어 -> 0번쨰 행, 2번 기어 -> 1번쨰 행, ...
        gears = new int[4][8];
        // 기어별 이동 방향
        point = new int[4];

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                // 문자 타입의 숫자(e.g. '1', '2', ...)를 정수 타입의 숫자로 변경
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            rotate(target, direction);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][pointBalancing(i, 0)] == 1) {
                // 비트 연산으로 1부터 i만큼 * 2
                answer += (1 << i);
            }
        }
        System.out.println(answer);
    }

    private static void rotate(int target, int direction) {

        int[] directions = new int[4];
        directions[target] = direction;

        // 왼쪽으로 전파 (target -> 0)
        for (int i = target; i > 0; i--) {
            if (gears[i][pointBalancing(i, 6)] != gears[i - 1][pointBalancing(i - 1, 2)]) {
                directions[i - 1] = -directions[i];
            } else {
                break;
            }
        }
        // 오른쪽으로 전파 (target -> 3)
        for (int i = target; i < 3; i++) {

            if (gears[i][pointBalancing(i, 2)] != gears[i + 1][pointBalancing(i + 1, 6)]) {
                directions[i + 1] = -directions[i];
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            point[i] -= directions[i];
        }
    }

    private static int pointBalancing(int target, int pos) {
        // 음수를 양수로 조정 (-1과 7은 같고 -2와 6은 같고, ...)
        return (pos + point[target] + 104) % 8;
    }
}
