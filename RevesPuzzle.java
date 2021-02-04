public class RevesPuzzle {
    private static void moves3(int starter, int n, String from, String temp, String to) {
        if (n == 0)
            return;
        moves3(starter, n - 1, from, to, temp);
        StdOut.println("Move disc " + (n + starter) + " from " + from + " to " + to);
        moves3(starter, n - 1, temp, from, to);
    }

    public static void moves4(int n, String from, String temp1, String temp2, String to) {
        if (n == 0)
            return;
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        moves4(k, from, temp2, to, temp1);
        moves3(k, n - k, from, temp2, to);
        moves4(k, temp1, from, temp2, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        moves4(n, "A", "B", "C", "D");
    }
}
