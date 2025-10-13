import java.util.Arrays;

public class StaticMethods {

	public static void main(String[] args) {
//		System.err.println(Integer.parseInt(args[0]));
//		System.err.println(Integer.parseInt(args[1]));
		
		for (int i = 0; i < args.length; i++) {
			int arg = Integer.parseInt(args[i]);
			
			double value = harmonic(arg);
			
			System.out.printf("%.2f\n", value);
		}
		
		
	}

	
	//-------------harmonic Method--------------------
	public static double harmonic ( int number) {
		double sum = 0.0;
		
		for(int i = 1; i <= number; i++) {
			sum += 1.0 / i;
		}
		
		return sum;
		
	}
}
