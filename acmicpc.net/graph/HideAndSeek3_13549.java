package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class HideAndSeek3_13549 {

    private static boolean[] visited = new boolean[100001];

    private static class Subin {

        int point;
        int time;

        Subin(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Subin> queue = new ArrayDeque<>();
        queue.add(new Subin(N, 0));
        visited[N] = true;

        if (N == K) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {

            Subin now = queue.pollFirst();
            visited[now.point] = true;
            if (now.point == K) {
                System.out.println(now.time);
                return;
            }
            if (now.point * 2 <= 100000 && !visited[now.point * 2]) {
                queue.add(new Subin(now.point * 2, now.time));
            }
            if (now.point - 1 >= 0 && !visited[now.point - 1]) {
                queue.add(new Subin(now.point - 1, now.time + 1));
            }
            if (now.point + 1 <= 100000 && !visited[now.point + 1]) {
                queue.add(new Subin(now.point + 1, now.time + 1));
            }
        }
    }
}
