package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JewelThief_1202 {

    private static class Jewel {
        int mass;
        int value;

        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 가방별 들어갈 수 있는 보석 중 가장 가격이 비싼 것 찾기
        // 무게 오름차순 정렬, 같다면 가격 내림차순 정렬
        Arrays.sort(jewels, (j1, j2) -> {
            if (j1.mass == j2.mass) {
                return j2.value - j1.value;
            }
            return j1.mass - j2.mass;
        });

        int[] bags = new int[K];

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 가방이 담을 수 있는 보석 무게 오름차순 정렬
        Arrays.sort(bags);

        // 가격 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;

        for (int i = 0, j = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석들을 우선순위 큐에 삽입
            // 이후에 무게는 작지만 가격이 높은 보석이 존재할 수 있기 떄문에.
            while (j < N && jewels[j].mass <= bags[i]) {
                pq.add(jewels[j++].value);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}
