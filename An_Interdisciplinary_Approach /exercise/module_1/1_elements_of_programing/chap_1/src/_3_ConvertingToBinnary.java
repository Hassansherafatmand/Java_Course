


import java.util.Scanner;

public class _3_ConvertingToBinnary {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		
		
        System.out.print("Please Enter a Number: ");
        int n = console.nextInt();
        int power = 1;
        

        // Step 1: find the largest power of 2 <= n
        while (power <= n / 2) {
        	 System.out.println("Power = " +power);
            power *= 2;
        }

        System.out.println("Power = " +power);
        // Step 2: print bits from most significant to least significant
        while (power > 0) {
            if (n < power) {
                System.out.print(0);
            } else {
                System.out.print(1);
                n -= power;

            }
            power /= 2;
        }

        System.out.println(); // for new line

	}

}
