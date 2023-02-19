import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순정렬_10814 {

    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    private static void printPerson(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(person.age).append(" ").append(person.name);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Person> list = new ArrayList<>();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.age - o2.age;
        });

        for (Person p : list) {
            printPerson(p);
        }
    }
}
