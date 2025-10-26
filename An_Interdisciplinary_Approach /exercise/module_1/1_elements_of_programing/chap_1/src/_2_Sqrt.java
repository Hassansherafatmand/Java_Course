


import java.util.Scanner;

public class _2_Sqrt {

	public static void main(String[] args) {
Scanner console = new Scanner (System.in);
		
		System.out.print("Please Enter a double Number: ");
		double c = console.nextDouble();
		double EPSILON =1e-15;
		double t = c;
		while (Math.abs(t  - c/t)  > EPSILON * t) t= (c / t + t) / 2.0;
		System.out.println(t);
		

	}

}
