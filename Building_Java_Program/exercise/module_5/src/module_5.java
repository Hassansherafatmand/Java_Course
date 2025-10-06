

import java.util.*;


public class module_5 {
	//	-------------------- randomNumber Function --------------------
	public static void randomNumber () {
		
		// one option is using random() method from Math class => Math.random()
		double ranNumber = Math.random();
		System.out.printf("Generated a random number using Math.random() option: %.0f\n", ranNumber * 10);
		
		// the other option using Random class in java.util package
		Random r = new Random();
		System.out.printf("Generated a random number using Random class option: %d\n", r.nextInt(10));
		
		
		
	}
	//	--------------------  randomApp Function --------------------
	public static void randomApp  () {
		System.out.println("This program picks numbers from ");
		System.out.println("range 1 to 10 until a particular ");
		System.out.println("number comes up.");
		System.out.println();
		
		Scanner console = new Scanner(System.in);
		Random r = new Random();
		
		int result = -1;
		int count = 0;
		
		System.out.print("Please pick a number between 1 to 10: ");
		int number = console.nextInt();
		
		
		while (number != result) {
			result = r.nextInt(10) + 1;
			System.out.println("Next number = " + result);
			count++;			
		}
		
		System.out.printf("Your number came after %d times", count);
		
		
		
		
		
		
	}
	//	-------------------- fenecPost Function --------------------
	public static void fencePostProblem (String s, int times) {

		System.out.println("We want to pitnt the below sequence.");
		System.out.println("[Alex, Alex, Alex, Alex, Alex]");
		System.out.println();
		
		System.out.println("First Approache:");
		System.out.print("[");
		for (int i = 0; i <= s.length();i++) {
			System.out.print(s + ", ");
			
		}
		System.out.print("]");
		System.out.println();
		System.out.println();
		
		
		System.out.println("Second Approache:");
		System.out.print("["+ s);
		for (int i = 1; i <= s.length();i++) {
			System.out.print( ", " + s);
			
		}
		System.out.print("]");
		System.out.println();
		
		
	}
	
	public static String firstWordCase1 (String word) {
		
		int start = 0;
		int stop = 0;
		
		while (word.charAt(stop) != ' ') {
			stop++;
		}
		
		return (word.substring(start, stop));
		
	}
	public static String firstWordCase2 (String word) {
		
		int start = 0;
		int stop = 0;
		
		 // skip the leading spaces
	    while (start < word.length() && word.charAt(start) == ' ') {
	        start++;
	    }

	    // find the end of first word
	    stop = start;
	    while (stop < word.length() && word.charAt(stop) != ' ') {
	        stop++;
	    }
		
		return (word.substring(start, stop));
		
	}
	//	-------------------- getInt Function --------------------
	public static int getInt(Scanner console, String prompt) {
		
		System.out.print(prompt);
	    while (!console.hasNextInt()) {
	        console.next(); // discard invalid input
	        System.out.println("Not an integer; try again.");
	        System.out.print(prompt); // reprint prompt
	    }
	    return console.nextInt();
	}
	
	
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	
	
	public static void main(String[] args) {
//		randomNumber();
//		randomApp();
//		fencePostProblem("Alex", 5);
		
//		String word = firstWordCase2(" Hello World!");
//		System.out.println(word);

		// getIn Function
//		Scanner console = new Scanner(System.in);
//	    int age = getInt(console, "How old are you? ");
//	    System.out.println("You entered: " + age);
//		console.close();
		
	}

}

