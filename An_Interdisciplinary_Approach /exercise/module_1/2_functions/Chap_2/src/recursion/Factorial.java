package recursion;
import java.util.*;

public class Factorial {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("Please enter the factorial number: ");
        int num = console.nextInt();

        int result = factorialMethod(num);

        // Print factorial expression
        System.out.print("!");
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                System.out.printf("%d", i);
            } else {
                System.out.printf(", !%d", i);
            }
        }

        System.out.print(" = " + result);
        console.close();
    }

    //---------------- FactorialMethod ----------------------
    public static int factorialMethod(int num) {
        if (num == 0 || num == 1) return 1;
        return num * factorialMethod(num - 1);
    }
}
