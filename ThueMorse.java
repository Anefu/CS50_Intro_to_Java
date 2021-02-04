public class ThueMorse
{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] sequence = new int[n];
        int count = 1;
        while(count < n){
            int c, i;
            i = 0;
            c = count;
            while (i < c && count < n){
                if(sequence[i] > 0) sequence[count] = 0;
                else sequence[count] = 1;
                i++;
                count++;
            }
        }
        for(int i = 0; i < sequence.length; i++){
            for(int j = 0; j < sequence.length; j++){
                if(sequence[i] == sequence[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println("");
        }
    }
}