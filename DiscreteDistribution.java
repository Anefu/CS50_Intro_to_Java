public class DiscreteDistribution
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int[] si = new int[args.length];
        int sum = 0;
        for(int i=1; i < si.length; i++) {
            sum += Integer.parseInt(args[i]);
            si[i] = sum;
        }
        int i = 0;
        while (i < m){
            int r = (int) (Math.random() * si[si.length-1]);
            for (int j = 0; j < si.length; j++){
                if(r >= si[j] && r < si[j+1]) System.out.print((j+1) + " ");
            }
        i++;
        }
        }
    }