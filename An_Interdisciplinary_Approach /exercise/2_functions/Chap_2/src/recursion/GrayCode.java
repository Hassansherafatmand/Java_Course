package recursion;

import java.util.*;

public class GrayCode {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

        System.out.print("Please enter the number: ");
        int a = console.nextInt();
        Boolean enter = true;
        garyCodeMethod(a, enter);


	}

	private static void garyCodeMethod(int a, Boolean enter) {
		System.out.printf(" grayCodeMethod(%d, %b)\n", a, enter);
		
		if(a == 0) {
			 System.out.println("\tReach to Base case = " + a);
			 return;
		}
		garyCodeMethod(a - 1, true);
		
		 if(enter) System.out.printf("\t\t\t\t%d enter\n", a);
		 else System.out.printf("\t\t\t\t%d exit\n", a);
		 
		 System.out.println();
		
		 garyCodeMethod(a - 1, false);
	}

}
