public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int count = 0;
        for (long a = 1; a * a * a < n; a++) {
            long b = Math.round(Math.cbrt(n - (a * a * a)));
            if (a * a * a + b * b * b == n) count++;
        }
        return count > 2;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
