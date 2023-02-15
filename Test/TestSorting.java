import java.util.Arrays;

public class TestSorting {

    private static class Emp implements Comparable<Emp> {
        int age, height;

        public Emp(int age, int height) {
            this.age = age;
            this.height = height;
        }

        @Override
        public String toString() {
            return "age = " + this.age + " / height = " + this.height;
        }

        /**
         * 정렬 2
         * @param o the object to be compared.
         * @return
         */
        @Override
        public int compareTo(Emp o) {
            if (this.age == o.age) {
                return Integer.compare(this.height, o.height);
            }
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) {
        Emp[] emps = new Emp[5];

        emps[0] = new Emp(30, 170);
        emps[1] = new Emp(25, 165);
        emps[2] = new Emp(25, 175);
        emps[3] = new Emp(25, 170);
        emps[4] = new Emp(30, 160);


        /**
         * 정렬 1
         */
        Arrays.sort(emps, (o1, o2) -> {
            if (o1.age == o2.age) {
                return Integer.compare(o1.height, o2.height);
            }
            return Integer.compare(o1.age, o2.age);
        });

        /**
         * 정렬2
         * implements comparable<Emp>
         */
        Arrays.sort(emps);

        for (Emp emp : emps) {
            System.out.println("emp = " + emp);
        }
    }
}
