import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실_배정_1931 {

    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Meeting> meetings = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end) {
                return Integer.compare(o1.start, o2.start);
            }
            return Integer.compare(o1.end, o2.end);
        });

        int count = 0;
        int preEnd = 0;

        for (int i = 0; i < N; i++) {
            if (preEnd <= meetings.get(i).start) {
                preEnd = meetings.get(i).end;
                count++;
            }
        }

        System.out.println(count);

    }
}
