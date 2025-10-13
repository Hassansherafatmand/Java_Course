import princetonLibs.StdIn;
import princetonLibs.StdOut;
import princetonLibs.StdDraw;

public class StdInOutPrinceton {

	public static void main(String[] args) {
		
		
		

        // draw the triangle
        double t = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);

		
	}

	
}
