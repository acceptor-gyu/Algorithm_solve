import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_폭발_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String explosion = br.readLine();

        String[] modified;
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (origin.contains(explosion)) {
                sb.setLength(0);
                modified = origin.split(explosion);

                for (int i = 0; i < modified.length; i++) {
                    sb.append(modified[i]);
                }
                origin = sb.toString();
                continue;
            }
            break;
        }
        if (origin.equals("")) {
            System.out.println("FRULA");
        } else {
            System.out.println(origin);
        }

    }
}
