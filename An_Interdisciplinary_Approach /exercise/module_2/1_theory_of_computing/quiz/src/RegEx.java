import java.util.Scanner;
//-------------------------------------------
/*
* We know that the area code is 3 digit number.
* and the rest is a 3 digit numbers + '-'+ 4 digit numbers.
* we can use the () to group the area code and then use '?' to make it 0 or 1 (optional)
* Then we define the rest
* Also we can use '?' for the space between area code and the actual number: '\\s?' in the below regEx
* "(\\(\\d{3}\\)\\s?)?\\d{3}-\\d{4}"
* 
*/ 
//-------------------------------------------


public class RegEx {

	public static void main(String[] args) {
		
		Scanner consoul = new Scanner (System.in);
		
		System.out.print("Please enter the phone number: ");
		String phone = consoul.nextLine();
	
		
		String defualtRegExp = "(\\(\\d{3}\\)\\s?)?\\d{3}-\\d{4}";

		if(phone.matches(defualtRegExp)) 	System.out.println("Valid phone number format");
		else 								System.out.println("Invalid phone number format");


	}

}

