package module_6;

import java.util.*;
import java.io.*;


public class LineBasedProcessing {

	public static void main(String[] args)throws FileNotFoundException{
		
		String fileAddress = "resources/employee_hours.txt";
		
		File file = new File(fileAddress);
		Scanner input = new Scanner (file);
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			lineBasedProcess(line);
		}
		
		
		input.close();
	}

	
	
	
	//Process the given string (ID, name, hours worked)
	//-------------------- lineBasedProcess Function --------------------
	public static void lineBasedProcess (String text) {
		
		Scanner data = new Scanner (text);
		int id = data.nextInt();
		String name = data.next();
		double sum = 0;
		
		while(data.hasNextDouble()) {
			
			sum += data.nextDouble();
			
			
		}
		System.out.printf("Total hours worked by %-5s (#%d) = %.2f",name,id, sum  );
		System.out.println();
		
		
		data.close();
	}
}
