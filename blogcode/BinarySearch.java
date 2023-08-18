public class BinarySearch {

    private static final int ANS = 17;

    public static void main(String[] args) {

        int left = 1;   // 답으로 나올 수 있는 최소값
        int right = 50; // 답으로 나올 수 있는 최대값

        while (left < right) {

            int mid = (left + right) / 2;
            System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);

            if (isPossible(mid)) {
                right = mid;
            } else {
                left = mid + 1; // mid가 답이 될 수 없다는 뜻이므로 mid + 1을 left에 할당
            }
        }
    }

    private static boolean isPossible(int mid) {

        if (mid >= ANS) {
            return true;    // 답이 될 수 있거나 입력으로 들어온 mid보다 정답이 작으면 true를 반환
        }

        return false;
    }
}
