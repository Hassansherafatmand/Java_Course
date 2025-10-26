import princetonLibs.*;
public class DoublingTest {

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-1000000, 1000000);
        }
        Stopwatch s = new Stopwatch();
        ThreeSumBook.count(a);
        return s.elapsedTime();
    }


    public static void main(String[] args) {
    	
        System.out.printf("%7s %7s %4s\n", "size", "time", "ratio");
        
        
        
        for (int n = 512; true; n += n) {
        	
        	double previous = timeTrial(n/2);
            double current = timeTrial(n);
            StdOut.printf("%7d %7.2f %4.2f\n", n, current, current / previous);
            previous = current;
        }
    }
}