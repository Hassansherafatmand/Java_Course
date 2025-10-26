import princetonLibs.StdIn;
import princetonLibs.StdOut;
import java.util.*;


public class StdInOutPrinceton {

	public static void main(String[] args) {
		
		Random rand = new Random();
//		if((rand.nextInt(7) + 1) > 3 )System.out.println("Heads");
//		else System.out.println("Tails");

		double r = Math.random() * 7;
		System.out.println(r);
		if(r > 3 )System.out.println("Heads");
		else System.out.println("Tails");
		
		
		
	}
}
