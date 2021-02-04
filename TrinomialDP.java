public class TrinomialDP {
    private static int convert(int k, int n) {
        return k + n;
    }

    public static long trinomial(int n, int k) {
        if (k < -1 * n || k > n)
            return 0;
        long[][] trinomials = new long[n + 1][2 * n + 2];
        trinomials[0][n] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = -1 * n; j <= n; j++) {
                int idx = convert(j, n);
                trinomials[i][idx] = trinomials[i - 1][idx] + trinomials[i - 1][idx + 1];
                if (idx - 1 >= 0)
                    trinomials[i][idx] += trinomials[i - 1][idx - 1];
            }
        }
        return trinomials[n][convert(k, n)];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
