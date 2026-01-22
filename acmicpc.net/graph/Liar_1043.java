package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Liar_1043 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> friends = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        
        int numberOfFriends = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numberOfFriends; i++) {
            friends.add(Integer.parseInt(st.nextToken()));
        }


        int answer = 0;
        int number;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            answer++;

            for (int j = 0; j < number; j++) {
                int participator = Integer.parseInt(st.nextToken());

                if (friends.contains(participator)) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
