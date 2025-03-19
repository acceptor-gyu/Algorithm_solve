package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet_1987 {

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};

    private static char[][] map;

    private static int R, C;
    private static boolean[] used;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        used = new boolean['Z' - 'A' + 1];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        used[map[0][0] - 'A'] = true;
        backtrack(new Node(0, 0), 1);

        System.out.println(answer);
    }

    private static void backtrack(Node now, int count) {

        answer = Math.max(answer, count);
        for (int i = 0; i < 4; i++) {

            int nowR = now.r + ry[i];
            int nowC = now.c + rx[i];

            if (nowR < 0 || nowC < 0 || nowR >= R || nowC >= C) {
                continue;
            }

            if (used[map[nowR][nowC] - 'A']) {
                continue;
            }

            used[map[nowR][nowC] - 'A'] = true;
            backtrack(new Node(nowR, nowC), count + 1);
            used[map[nowR][nowC] - 'A'] = false;
        }
    }
}
