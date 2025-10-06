
package module_4_TextProcessing;

public class module_4_1 {
	
	//	-------------------- textProcessing Function --------------------
	public static void textProcessing () {
		
		char ch1 = 'a';
        char ch2 = '7';

        // Check type
        System.out.println(Character.isLetter(ch1)); // true
        System.out.println(Character.isDigit(ch2));  // true

        // Change case
        System.out.println(Character.toUpperCase(ch1)); // A
        System.out.println(Character.toLowerCase('Q')); // q

        // Numeric value
        System.out.println(Character.getNumericValue(ch2)); // 7
	}

	//	--------------------  formatSpecifiers Function --------------------
	public static void formatSpecifiers () {
		int score = 87;
		double gpa = 3.18652;
		String name = "Luca";
		
		System.out.printf("student name: %10s\n", name);
		System.out.printf("exam score  : %9d%%\n", score);
		System.out.printf("GPA         : %10.2f\n", gpa);
		
	
		
		
		
	}
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	//	--------------------  Function --------------------
	
	
	public static void main(String[] args) {
		 
//		textProcessing();
		formatSpecifiers();
		
	}

}
