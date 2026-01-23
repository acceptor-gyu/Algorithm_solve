package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SnakeAndLadderGame_16928 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int switches = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        // 2열은 주사위를 던진 횟수를 표시
        int[][] map = new int[2][101];

        for (int i = 1; i <= 100; i++) {
            map[0][i] = i;
        }

        for (int i = 0; i < switches; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[0][from] = to;
        }

        int now = 1;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(now);

        while (!queue.isEmpty() && map[1][100] == 0) {

            now = queue.pollFirst();

            for (int i = 1; i <= 6; i++) {

                if (now + i > 100) {
                    continue;
                }

                if (map[1][now + i] != 0 || map[1][map[0][now + i]] != 0) {
                    continue;
                }

                queue.addLast(map[0][now + i]);
                map[1][now + i] = map[1][now] + 1;
                // 뱀 또는 사다리라면 이동된 칸도 업데이트
                map[1][map[0][now + i]] = map[1][now] + 1;
            }
        }

        System.out.println(map[1][100]);
    }
}
