public class ShannonEntropy{
    public static void main(String args[]) {
        int m = Integer.parseInt(args[0]);
        double n = 0.0;
        int[] counts = new int[m+1];
        while(!StdIn.isEmpty()){
            int x = StdIn.readInt();
            for(int i = 1; i < counts.length; i++){
                if(x == i) counts[i]++;
            }
            n++;
        }
        double entropy = 0.0;
        for(int i = 0; i < counts.length; i++){
            if(counts[i] != 0){
                double pi = (double) counts[i]/n;
                double logs = Math.log(pi)/Math.log(2);
                entropy += ((-pi)*logs);
            }
        }
        StdOut.printf("%.4f", entropy);
    }
}