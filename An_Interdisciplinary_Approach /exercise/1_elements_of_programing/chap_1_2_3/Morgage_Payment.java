
import java.util.Scanner;
public class Morgage_Payment {
    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("This program computes monthly morgage payments.");

        Scanner input = new Scanner (System.in);

        System.out.print("loan amount\t:");
        double loan = input.nextDouble();

        System.out.print("number of years : ");
        int years = input.nextInt();

        System.out.print("interest rate.  : ");
        double rate = input.nextDouble();
        System.out.println();

        //Compute the result
        int n = 12 * years;
        double c = rate / 12.0 / 100.0;
        double payment = loan * c * Math.pow(1 + c, n) / (Math.pow(1 + c, n) - 1);
        System.out.println("payment = $" + (int )payment);




        input.close();
    }
}
