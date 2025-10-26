package recursion;
import java.util.*;

// This program was amazing, after tracing about 1 hour I could finally figured it out how the 
// the program works for the Tower of Hanoi.


public class TowerOfHanoi {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);

        System.out.print("Please enter the number: ");
        int a = console.nextInt();
        Boolean left = true;
        towerOfHanoiMethod(a, left);

	}
	//---------------- towerOfHanoiMethod ----------------------
	public static void towerOfHanoiMethod(int n, boolean left) {
		
		// every time, I want to print the method to see what values been assigned which allows me to 
		// better debugging.
		System.out.printf(" towerOfHanoiMethod(%d, %b)\n", n, left);
		
		//We want to have a check point to reach to the base-case here:
		 if (n == 0) {
			 System.out.println("\tReach to Base case = " + n);
			 return;
		 }
		 
		 // keep calling the function to reach to the Base-case.
		 towerOfHanoiMethod(n-1, !left);
		 
		 //after reaching the base-case, function steps back to the previous call to check whether 
		 // has to move the element to right or left:
		 if(left) System.out.printf("\t\t\t\t%d Left\n", n);
		 else System.out.printf("\t\t\t\t%d Right\n", n);
		 
		 System.out.println();
		 
		 // again we call the method to check if any other element (other pieces) are left.
		 towerOfHanoiMethod(n-1, !left);
	}
}
