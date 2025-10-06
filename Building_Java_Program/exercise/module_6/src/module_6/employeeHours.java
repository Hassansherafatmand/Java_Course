
package module_6;

import java.util.*;
import java.io.*;


public class employeeHours {

	public static void main(String[] args) throws FileNotFoundException {

		String fileAddress = "resources/employeData.txt";
		File file = new File (fileAddress);
		
		
		
		Scanner input = new Scanner(file);
		
//		System.out.println(file.canRead()); //true
//		System.out.println(file.getAbsolutePath());// /Users/luca/Desktop/Java/Building_Java_Program/exercise/module_6/resources/employeData.txt
		
		processEmployeeHours(input);

	}

	
	
	//-------------------- processEmployeeHours Function --------------------
	public static void processEmployeeHours (Scanner input) {
		
		System.out.println("Total Employee Hours:");
		
		
		while (input.hasNext()) {
			String name = input.next();
			double sum = 0.0;
			
			while(input.hasNextDouble()) {
				sum += input.nextDouble();
			}
			
			System.out.printf("Total Hours worked by %s is = %.1f", name, sum);
			System.out.println();
		}
	}
}
