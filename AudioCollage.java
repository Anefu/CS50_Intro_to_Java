public class AudioCollage
{
    public static double[] amplify(double[] a, double alpha)
    {
        double[] amp = new double[a.length];
        for (int i = 0; i < a.length; i++)
            amp[i] = alpha*a[i];
        return amp;
        
    }
    public static double[] reverse(double[] a)
    {
        double[] rev = new double[a.length];
        for (int i = 0; i < a.length; i++)
            rev[i] = a[i];
        for (int i = 0; i < a.length/2; i++){
            double temp = rev[i];
            rev[i] = rev[rev.length-1-i];
            rev[rev.length-1-i] = temp;
        }
        return rev;   
    }
    public static double[] merge(double[] a, double[] b)
    {
        double[] merged = new double[a.length+b.length];
        int pos = 0;
        for (double sample : a) {
            merged[pos] = sample;
            pos++;
        }
        for (double sample : b) {
            merged[pos] = sample;
            pos++;
        }       
        return merged; 
    }
    public static double[] mix(double[] a, double[] b)
    {
        double[] mixed  = new double[Math.max(a.length, b.length)];
        if (Math.max(a.length, b.length) == a.length) {
            int pos = 0;
            for (double x : a){
                mixed[pos] = x;
                pos++;
            }
            int i = 0;
            for (double x: b){ 
                mixed[i] += x;
                i++;
            }
        }
        else {
            int pos = 0;
            for (double x : b){
                mixed[pos] = x;
                pos++;
            }
            int i = 0;
            for (double x: a){ 
                mixed[i] += x;
                i++;
            }
        }
        return mixed;
    }
    public static double[] changeSpeed(double[] a, double alpha)
    {
        int n = (int) (a.length/alpha);
        double[] speed = new double[n];
        for (int i = 0; i < speed.length; i++){
            speed[i] = a[(int) (i*alpha)];
        }
        return speed;
    }
    public static void main(String[] args)
    {
        double[] singer = changeSpeed(StdAudio.read("singer.wav"), 0.85);
        double[] piano = changeSpeed(StdAudio.read("piano.wav"), 0.5);
        double[] chimes = StdAudio.read("chimes.wav");
        double[] silence = StdAudio.read("silence.wav");
        double[] mixed = mix(singer, piano);
        mixed = mix(mixed, chimes);
        double[] harp = reverse(StdAudio.read("harp.wav"));
        mixed = merge(mixed, harp);
        mixed = merge(mixed, silence);
        mixed = amplify(mixed, 0.8);

        StdAudio.play(mixed);
    }   
}