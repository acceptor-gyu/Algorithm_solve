public class Fibonacci {
    // 1, 1, 2, 3, 5, 8, 13, 21, ...
    private static long cnt = 0;
    private static long fibo(int n) {

        cnt++;

        if (n <= 2) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("fibo(50): " + fibo(50));
        System.out.println("cnt: " + cnt);
    }
}
