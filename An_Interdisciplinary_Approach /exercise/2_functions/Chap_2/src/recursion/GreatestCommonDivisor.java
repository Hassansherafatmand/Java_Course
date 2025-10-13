package recursion;

import java.util.*;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		 Scanner console = new Scanner(System.in);

	        System.out.print("Please enter two integer numbers: ");
	        int a = console.nextInt();
	        int b = console.nextInt();
	        int result = gcd(a,b);
	        System.out.println(result);
	}
	
	//---------------- gcdMethod ----------------------
	public static int gcd (int a, int b) {
		System.out.printf("(%d, %d)\n", a, b);
		if (b == 0) return a;
		return gcd(b, a %b);
	}
}
