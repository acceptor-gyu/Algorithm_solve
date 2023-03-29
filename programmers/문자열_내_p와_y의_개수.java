public class 문자열_내_p와_y의_개수 {

    class Solution {
        boolean solution(String s) {

            int numOfP = 0;
            int numOfY = 0;

            char[] string = s.toUpperCase().toCharArray();

            for (char el : string) {
                if (el == 'P') {
                    numOfP++;
                }
                if (el == 'Y') {
                    numOfY++;
                }
            }

            return numOfP == numOfY;
        }
    }
}
