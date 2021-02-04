public class Checkerboard{
    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        double r = 0.5;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                double x = i+r;
                double y = n-(j+r);
                if((x+y)%2==0) StdDraw.setPenColor(StdDraw.GRAY);
                else StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, r);
            }
        }
        }
    }