class 문자열_다루기_기본 {
    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (c - '0' > 9 || c - '0' < 0) {
                return false;
            }
        }

        return answer;
    }
}