package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 정해진 좌표에 M개의 건물을 배치했을 때,
 * 건물 사이의 가장 작은 거리가 최대가 되도록
 * =>>>>>>>>>> 가장 작은 ~~ 중 최대인 ~~ => 이분 탐색 생각!
 *
 * 이분 탐색 + 그리디 (parametric search)
 */
public class PlaceBuildings_parametric_bianary_search {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N <= 200_000 -> O(N^2) 불가능
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }

        // 왼쪽부터 순서대로 확인하기 위해 좌표 정렬
        Arrays.sort(pos);

        // 이분 탐색 범위: 최소 거리가 가능한 범위
        int low = 0;   // 최소 1
        int high = pos[N - 1] - pos[0];  // 최대 양 끝 거리
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canPlace(pos, M, mid)) {
                // mid 거리로 M개 배치 가능 -> 더 큰 거리도 되는지 시도
                answer = mid;
                low = mid + 1;
            } else {
                // 불가능 -> 거리를 줄여야 함
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // 인접 거리를 최소 distance 이상 유지하면서 M개 배치가 가능한지 검증
    private static boolean canPlace(int[] pos, int M, int distance) {

        // 선택할 떄마다 last 업데이트
        int count = 1;
        int last = pos[0];

        for (int i = 1; i < pos.length; i++) {
            // 마지막 선택 초소로부터 distance 이상 떨어진 초소를 만나면 선택
            if (pos[i] - last >= distance) {
                count++;
                last = pos[i];
            }
        }
        // M개 이상 배치가 가능하면 true
        return count >= M;
    }

}
