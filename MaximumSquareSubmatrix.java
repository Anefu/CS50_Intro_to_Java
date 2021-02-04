public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int n = a[0].length;
        int[][] sizes = new int[n+1][n+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i-1][j-1] == 0) sizes[i][j] = 0;
                else
                    sizes[i][j] = Math.min(sizes[i][j-1], Math.min(sizes[i-1][j-1], sizes[i-1][j])) + 1;
                if (max < sizes[i][j]) max = sizes[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readInt();
        StdOut.println(size(a));
    }
}
