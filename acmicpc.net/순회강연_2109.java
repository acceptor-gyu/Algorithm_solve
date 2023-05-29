import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 순회강연_2109 {

    private static class Lecture {
        int value;
        int timeline;

        public Lecture(int value, int timeline) {
            this.value = value;
            this.timeline = timeline;
        }

        public int getValue() {
            return value;
        }

        public int getTimeline() {
            return timeline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        boolean[] scheduled = new boolean[10001];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Comparator<Lecture> lectureComparator = Comparator.comparing(Lecture::getValue)
                .thenComparing(Lecture::getTimeline).reversed();

        Collections.sort(lectures, lectureComparator);

        int sum = 0;

        for (int i = 0; i < lectures.size(); i++) {
            for (int j = lectures.get(i).timeline; j >= 1; j--) {
                if (!scheduled[j]) {
                    scheduled[j] = true;
                    sum += lectures.get(i).value;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
