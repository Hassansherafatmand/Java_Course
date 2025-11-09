import java.util.Scanner;

public class Validate {

	public static void main(String[] args) {
		

		String regexp = args[0];
		
		Scanner console = new Scanner (System.in);
		
		while (console.hasNext()) {
			String string = console.next();
			if(string.matches(regexp)) System.out.println("Yes");
			else System.out.println("No");
		}

	}

}

/*
 * MacOS~> javac Validate.java                        
 * MacOS~> java Validate "(a|b)*a(a|b)(a|b)(a|b)(a|b)"  
bbbabbbb
Yes
bbbbbbbba
No
* MacOS~> java Validate "a*|(a*ba*ba*ba*)*"
bbbaababbaa
Yes
baabbbaaaaab
No
 */