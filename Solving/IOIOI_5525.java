import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * substring 메서드는 시간복잡도가 O(N)이기 때문에
 * substring 메서드를 사용하면 50점 밖에 맞지 못한다.
 */

public class IOIOI_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int patterSize = N * 2 + 1;

        char[] S = br.readLine().toCharArray();
        char[] P = new char[patterSize];

        for (int i = 0; i < patterSize; i++) {
            if (i % 2 == 0) {
                P[i] = 'I';
            } else {
                P[i] = 'O';
            }
        }

        int Shash = 0;
        int Phash = 0;
        int base = 1;
        int count = 0;

        for (int i = patterSize - 1; i >= 0; i--) {
            Shash = Shash + S[i] * base;
            Phash = Phash + P[i] * base;

            if (i > 0) {
                base *= 2;
            }
        }

        for (int i = 0; i < M - patterSize + 1; i++) {

            if (i > 0) {
                Shash = (Shash - S[i - 1] * base) * 2 + S[patterSize - 1 + i];
            }

            if (Phash == Shash) {

                boolean finded = true;

                for (int j = 0; j < patterSize; j++) {
                    if (S[i + j] != P[j]) {
                        finded = false;
                        break;
                    }
                }

                if (finded) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
