package module_6;


import java.util.*;
import java.io.*;





public class SumOfNumbers {

	//-------------------- sumApp Function --------------------


	public static int sumApp(File file) {
	    int sum = 0;

	  
		   
		   //Confirmation checks
		   String status;
		
		   if (!file.exists())  		status = "NOT_EXIST";
		   else if(!file.isFile())    	status = "NOT_FILE";
		   else if(!file.canRead())     status = "NOT_READABLE";
		   else 			  		    status = "OK";
		   
		   switch(status) {
			   	case "NOT_EXIST":
			   		System.out.println("Error: File does not exist.");
		            return 0;
			   	case "NOT_FILE":
			   		System.out.println("Error: Path is not a file.");
			   		return 0;
			   	case "NOT_READABLE":
			   		System.out.println("Error: File cannot be read (permissions issue).");
			   		return 0;
			   	case "OK":
			   		System.out.println("File check passed. Ready to read.");
			   		break;
			   	default:
			   	 System.out.println("Unknown file state.");
		            return 0;
		   }
		   
		   
		// If OK, continue with reading
		    try (Scanner input = new Scanner(file)) {
		        while (input.hasNextInt()) {
		            sum += input.nextInt();
		        }
		        input.close();
		        
		    } catch (FileNotFoundException e) {
		        System.out.println("File not found: " + e.getMessage());
		    }
		    
		    
		    return sum;
	}


	public static void main(String[] args) throws FileNotFoundException {
		String fileAddress = "resources/data.txt";
		File file = new File(fileAddress);
		
		int summOfNumbers = sumApp(file);
		System.out.println("The result of the numbers are: " + summOfNumbers);
		
		
		
		
	}

}
