


import java.util.Scanner;

public class _1_HarmonicNumber {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		
		System.out.print("Please Enter a Number: ");
		int n = console.nextInt();
		double sum = 0.0;
		for (int i = 1; i <= n; i ++) {
			sum += 1.0 / i;
		}
		System.out.println(sum);
		
		
	}
	//

}
