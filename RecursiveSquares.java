public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor();
        StdDraw.square(x, y, length / 2);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n <= 0) return;
        drawSquare(x, y, length);
        double halflength = length / 2;
        double x0 = x - halflength, x1 = x + halflength;
        double y0 = y - halflength, y1 = y + halflength;
        draw(n - 1, x0, y0, halflength);
        draw(n - 1, x0, y1, halflength);
        draw(n - 1, x1, y0, halflength);
        draw(n - 1, x1, y1, halflength);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
