public class Inversions {
    public static long count(int[] a) {
        long c = 0, n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (a[i] > a[j]) c++;
        return c;
    }

    public static int[] generate(int n, long k) {
        if (n == 0 && k == 0) return new int[0];
        int[] inverse = new int[n];
        int i = n - 1, front = 0, back = n - 1;
        while (front < back) {
            if (k >= i) {
                inverse[front] = i;
                front++;
                k -= i;
            }
            else {
                inverse[back] = i;
                back--;
            }
            i--;
        }
        return inverse;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        for (int i : generate(n, k)) StdOut.print(i + " ");
    }
}
