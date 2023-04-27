import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String target = br.readLine();

            int size = target.length();

            if (size <= 10) {
                sb.append(target).append("\n");
                continue;
            }

            char[] characters = target.toCharArray();
            sb.append(characters[0]).append(size - 2).append(characters[size - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
