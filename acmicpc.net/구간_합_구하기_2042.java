import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_2042 {

    private static long[] tree;     // 세그먼트 트리 데이터 저장
    private static int s_idx;   // 리프 노드 시작 위치

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 리포 노드의 수 계산
        s_idx = 1;
        while (s_idx < N) {
            s_idx *= 2;
        }

        tree = new long[s_idx * 2];

        // 리프 노드 시작 위치 보정
        s_idx--;

        for (int i = 1; i <= N; i++) {
            long x = Long.parseLong(br.readLine());
            update(i, x);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            }
            if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                long result = query(b, c);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long query(int left, int right) {
        left += s_idx;
        right += s_idx;

        long sum = 0;

        while (left <= right) {
            if (left % 2 == 1)
                sum += tree[left];

            if (right % 2 == 0)
                sum += tree[right];

            left = (left + 1) / 2;
            right = (right - 1) / 2;
        }
        return sum;
    }

    private static void update(int idx, long num) {
        idx += s_idx;

        tree[idx] = num;
        idx /= 2;

        while (idx > 0) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx /= 2;
        }
    }
}
