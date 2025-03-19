package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분수열5_14003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] index = new int[N];
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        list.add(A[0]);

        int target;
        int searchedIndex;

        /**
         * list의 크기(현재까지 가장 긴 증가하는 부분 수열의 길이)
         * list의 가장 마지막 요소의 크기가 target보다 작다면 target을 list에 추가
         * list의 가장 마지막 요소의 크기가 target보다 크다면 target으로 대체하고 해당 인덱스를 저장
         *
         */
        //
        for (int i = 1; i < N; i++) {
            target = A[i];

            if (list.get(list.size() - 1) < target) {
                list.add(target);
                index[i] = list.size() - 1;
            } else {
                searchedIndex = getLowerBound(list, target);
                list.set(searchedIndex, target);
                index[i] = searchedIndex;
            }
        }

        StringBuilder sb = new StringBuilder();
        // LIS(가장 긴 증가하는 부분 수열)의 길이 출력
        sb.append(list.size() + "\n");
        int lastIndex = list.size() - 1;

        for (int i = N - 1; lastIndex >= 0 && i >= 0 ; i--) {

            // LIS(가장 긴 증가하는 부분 수열)의 일부가 아니므로 건너뜀
            if (index[i] != lastIndex) continue;

            lastIndex--;
            stack.addLast(A[i]);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast() + " ");
        }

        System.out.println(sb);
    }

    /**
     * list에서 target 보다 큰 수가 가장 처음 위치한 곳을 반환
     *
     * @param list
     * @param target
     * @return
     */
    private static int getLowerBound(List<Integer> list, int target) {
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
