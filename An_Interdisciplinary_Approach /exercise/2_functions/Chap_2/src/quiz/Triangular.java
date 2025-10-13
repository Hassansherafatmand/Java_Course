package quiz;

import java.util.*;
public class Triangular {

	public static void main(String[] args) {
		System.out.println("Triangular program");
		
		Scanner console = new Scanner (System.in);
		
		System.out.print("Please Enter 3 double number: ");
		double a = console.nextDouble();
		double b = console.nextDouble();
		double c = console.nextDouble();
		
		System.out.println(Triangular(a, b, c));
		
	}
	//---------------- Triangular --------------------
	public static boolean Triangular(double a, double b, double c) {
		boolean angular = false;
		if( a < b + c && b < a + c && c < a + b) return true;
		return false;
	}

}
