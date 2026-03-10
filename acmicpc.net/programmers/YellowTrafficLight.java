package programmers;

public class YellowTrafficLight {

    /**
     * LCM 풀이
     */

    public int solution(int[][] signals) {

        int n = signals.length;
        int[] cycle = new int[n];

        // cycle 계산
        for (int i = 0; i < n; i++) {
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        int lcm = cycle[0];
        for (int i = 1; i < n; i++) {
            lcm = lcm(lcm, cycle[i]);
        }

        int g0 = signals[0][0];
        int y0 = signals[0][1];
        int cycle0 = cycle[0];

        // 첫 신호등의 노란색 구간만 탐색
        for (int start = g0; start <= lcm; start += cycle0) {

            for (int t = start; t < start + y0 && t <= lcm; t++) {

                boolean ok = true;

                // 다른 신호등 노란불 여부 확인
                for (int i = 0; i < n; i++) {

                    int g = signals[i][0];
                    int y = signals[i][1];

                    int time = t % cycle[i];

                    if (time < g || time >= g + y) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    return t + 1;
                }
            }
        }

        return -1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
