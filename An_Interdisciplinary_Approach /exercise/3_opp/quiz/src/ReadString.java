
/*
 * Write a program that reads in a string and prints the first character 
 * that appears exactly once in the string. Ex: ABCDBADDAB -> C.
 * 
 * */
 
import java.util.Scanner;

public class ReadString {

	public static void main(String[] args) {
		
		// form command- line ---------------------------
//		String s = args[0];
//		firstUniqueCharArray(s.toUpperCase());
		
		
		// from Standard input ---------------------------
		Scanner console = new Scanner (System.in);
		
		System.out.print("Please Enter the String: ");
		String s = console.nextLine();
		System.out.println(s);
		
		firstUniqueCharArray(s.toUpperCase());
		
		console.close();

		
		
	}
	
	// ---------------- firstUniqueCharArray ----------------------
	public static void firstUniqueCharArray(String s) {
	    
	    // validation check if the string has length of 1
	    if (s.length() == 1) {
	        System.out.println(s + " -> " + s.charAt(0) + ": index[" + 0 + "]");
	        return;
	    }
	    
	    char[] chars = new char[s.length()];

	    // transfer all string characters into an array
	    for (int i = 0; i < chars.length; i++) {
	        chars[i] = s.charAt(i);
	    }

	    // search for the first occurrence 
	    for (int i = 0; i < chars.length; i++) {
	        int count = 0;

	        for (int j = 0; j < chars.length; j++) {
	            if (chars[i] == chars[j]) {
	                count++;
	            }
	        }

	        if (count == 1) {
	            System.out.println(s + " -> " + chars[i] + ": index[" + i + "]");
	            return;
	        }
	    }

	    System.out.println(s + " -> No unique character");
	}

}
