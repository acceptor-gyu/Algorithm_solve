package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 블록 캐기 -> 2초
 * 블록 놓기 -> 1초
 * N: 가로, M: 세로, B: 초기 블록 개수 / H <= 256 / (1 <= N, M <= 500)
 * 500 * 500 * 256 = 64,000,000 (= 6.4 * 10^7)
 *
 * 땅 고르게 만들기!
 *
 * return Pair(최소 시간, 높이) - 답이 여러 개라면 최대 높이
 */
public class Minecraft_18111 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 500 * 500 맵을 높이 256에서 높이 0로 만드는 경우 -> 500 * 500 * 256 * 2 = 128,000,000
        int min = 500 * 500 * 256 * 2;
        int[][] map = new int[N][M];
        int minHeight = 0;
        int maxHeight = 256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < minHeight) minHeight = map[i][j];
                if (map[i][j] > maxHeight) maxHeight = map[i][j];
            }
        }

        int height = minHeight;
        int resultHeight = 0;

        while (minHeight <= height && height <= maxHeight) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff =  map[i][j] - height;

                    // 목표 높이가 현재 (i, j)의 높이보다 작으면 캐기 (time += 2)
                    if (diff > 0) {
                        time += diff * 2;
                        inventory += Math.abs(diff);
                    } else {
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            // 완성했지만 inventory가 음수라면 불가능
            if (inventory >= 0) {
                if (min >= time) {
                    min = time;
                    resultHeight = height;
                }
            }
            height++;
        }

        System.out.println(min + " " + resultHeight);
    }
}
