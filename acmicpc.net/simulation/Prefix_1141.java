package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prefix_1141 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int size = N;
        String now;
        String next;
        Arrays.sort(words);

        for (int i = 0; i < N - 1; i++) {
            now = words[i];
            next = words[i + 1];

            // 사전순으로 정렬했을 때, 다음 단어가 현재 단어부터 시작할 때 현재 단어를 제거하는 것처럼 동작
            if (next.startsWith(now)) {
                size--;
            }
        }

        System.out.println(size);
    }
}
