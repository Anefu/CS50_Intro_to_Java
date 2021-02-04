public class Birthday
{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        boolean[] birthday = new boolean[n];
        for(int i = 1; i < (trials+1); i++){
            int r = (int) (Math.random() * n);
            birthday[r] = true;
            for(int j = 0; j < n; j++) if(birthday[j] == true) break;
        }
    }
}