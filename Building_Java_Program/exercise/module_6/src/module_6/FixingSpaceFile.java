package module_6;

import java.util.*;
import java.io.*;


public class FixingSpaceFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		
//		System.out.println(readFile());
		
		readFile();
		
		
		
	}
	//-------------------- readFile Function --------------------
	
	public static void readFile() throws FileNotFoundException{
		
		String fileAddress = "resources/spacedText.txt";
		String newFileAddress = "resources/fixedSpacedText.txt";
		
		PrintStream output = new PrintStream (new File(newFileAddress));
		Scanner input = new Scanner(new File(fileAddress));
		
		
		//Send a single word at a time
		
		while (input.hasNextLine()) {
			
			String textLine = input.nextLine();
			
			
			//Generating data on a file
			producingOutputOnFileAndScreen(textLine, output);
			
			//Generating data on the screen
			producingOutputOnFileAndScreen(textLine, System.out);
			
		}
		
		input.close();
		
	}
	
	//-------------------- producingOutputOnFile Function --------------------
	public static void producingOutputOnFileAndScreen(String text, PrintStream  output){
		
		Scanner data = new Scanner (text);
		
		//First word without leading space;
		if (data.hasNext()) {
			
			output.print(data.next());
		}
		
		//Reaming words with a single space.
		while(data.hasNext()) {
			output.print(" " + data.next());
		}
		output.println();
			
		
		
	}
	

}
