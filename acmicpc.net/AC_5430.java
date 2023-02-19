import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC_5430 {

    public static Deque<String> strToDeque(String str, int n) {
        Deque<String> deque = new ArrayDeque<>();
        str = str.substring(1, str.length() - 1);
        String[] elements = str.split(",");
        for (int i = 0; i < n; i++) {
            deque.addLast(elements[i]);
        }
        return deque;
    }

    public static void deleteWithMode(Deque<String> deque, boolean mode) {
        if (mode) {
            deque.pollFirst();
        } else {
            deque.pollLast();
        }
    }

    public static boolean convertMode(boolean mode) {
        return !mode;
    }

    public static StringBuilder makeRes (Deque<String> deque, boolean mode) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = deque.size();
        for (int i = 0; i < size - 1; i++) {
            if (mode) {
                sb.append(deque.pollFirst()).append(",");
            } else {
                sb.append(deque.pollLast()).append(",");
            }

        }
        if (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        sb.append("]").append("\n");
        return sb;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Deque<String> deque;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            boolean mode = true;
            String[] cmd = br.readLine().split("");
            int intNum = Integer.parseInt(br.readLine());
            boolean flag = true;

            deque = strToDeque(br.readLine(), intNum);
            for (String cmdEl : cmd) {
                switch (cmdEl) {
                    case "R":
                        mode = convertMode(mode);
                        break;
                    case "D":
                        if (deque.isEmpty()) {
                            flag = false;
                            break;
                        }
                        deleteWithMode(deque, mode);
                        break;
                }
            }
            if (flag) {
                sb.append(makeRes(deque, mode));
            } else {
                sb.append("error\n");
            }
        }
        System.out.println(sb);
    }
}
