import java.util.Arrays;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int lux = 0, luy = 0, rdx = 0, rdy = 0;
        lux = wallpaper.length;
        luy = wallpaper[0].toCharArray().length;
        rdx = 0;
        rdy = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            char[] line = wallpaper[i].toCharArray();

            for (int j = 0; j < line.length; j++) {
                if (line[j] == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;

        return answer;
    }
}

public class 바탕화면_정리 {

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        int[] res = s.solution(wallpaper);
        System.out.println(Arrays.toString(res));
    }
}
