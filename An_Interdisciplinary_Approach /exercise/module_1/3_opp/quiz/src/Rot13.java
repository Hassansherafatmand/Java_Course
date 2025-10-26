/*
 * Rot13. Rot13 is a very simple encryption scheme used on some Internet newsgroups 
 * to conceal potentially offensive postings. It works by cyclically shifting 
 * each lowercase or uppercase letter 13 positions. So, the letter 'a' is replaced 
 * by 'n' and the letter 'n' is replaced by 'a'. For example, the string "Encryption" 
 * is encoded as "Rapelcgvba." Write a program ROT13.java that reads in a String as a 
 * command-line parameter and encodes it using Rot13. 
 * 
 * 
 * */

public class Rot13 {

	public static void main(String[] args) {
		
		String s = args[0];
		encryptionRot13(s);
		

	}
	
	
	// ---------------- encryptionRot13 ---------------
	public static void encryptionRot13(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if( c >= 'a' && c <= 'm') c += 13;
			else if ( c >= 'A' && c <= 'M') c += 13;
			else if(c >= 'n' && c <= 'z') c -= 13;
			else if ( c >= 'N' && c <= 'Z') c -= 13;
			System.out.print(c);
		}
		System.out.println();
	}
}
