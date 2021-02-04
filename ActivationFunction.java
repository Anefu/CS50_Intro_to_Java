public class ActivationFunction
{
    public static double heaviside(double x)
    {
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) return 0.0;
        else if (x == 0 || x == -0.0) return 0.5;
        return 1.0;
    }
    public static double sigmoid(double x)
    {
        return 1.0 / (1.0 + Math.pow(Math.E, -x));   
    }
    public static double tanh(double x)
    {
        if (x <= -20) return -1.0;
        if (x >= 20) return 1.0;
        return (Math.exp(x) - Math.exp(-1.0 * x))/(Math.exp(x) + Math.exp(-1.0 * x));    
    }
    public static double softsign(double x)
    {
        if (x == Double.POSITIVE_INFINITY) return 1.0;
        if (x == Double.NEGATIVE_INFINITY) return -1.0;
        if (Double.isNaN(x)) return Double.NaN;
        return x / (1.0 + Math.abs(x));    
    }
    public static double sqnl(double x)
    {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == -0.0) return x;
        if (x <= -2.0) return -1.0;
        else if (x > -2.0 && x < 0.0) return x + Math.pow(x, 2)/4.0;
        else if (x >= 0.0 && x < 2.0) return x - Math.pow(x, 2)/4.0;
        else return 1.0;   
    }
    public static void main(String[] args)
    {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("tanh(" + x + ") = " + tanh(x));
        System.out.println("softsign(" + x + ") = " + softsign(x));
        System.out.println("sqnl(" + x + ") = " + sqnl(x));    
    }
    
}