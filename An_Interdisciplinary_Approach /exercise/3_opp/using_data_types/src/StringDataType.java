import java.lang.reflect.Field;
import java.net.FileNameMap;

public class StringDataType {

	public static void main(String[] args) {
		String s = args[0];
		
		//extract file name and extension from a command-line argument
//		extractFileNameAndExtension(s);

		
		boolean isPalindrom = isPalindrome(s);
		System.out.println(isPalindrom);
		
	}
	//---------------------- extractFileNameAndExtension -------------------------------
	public static void extractFileNameAndExtension(String s) {

		int dot = s.indexOf(".");
		String fileName = s.substring(0, dot);
		String extention = s.substring(dot+1, s.length());
		
		System.out.printf("The file name is: '%s'\nThe extension is: '%s'", fileName, extention);
	}
	
	//---------------------- isPalindrome ----------------------
	public static boolean isPalindrome( String s) {
		
		int n = s.length();
		for(int i = 0; i < n/2; i++) {
			if (s.charAt(i) != s.charAt(n-1-i)) return false;
		}
		return true;
	}
}
