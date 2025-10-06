package module_6;

import java.util.*;
import java.io.*;
import java.nio.file.*;


public class FileReadingBasics {

	//	-------------------- CommonFileReadMEthods Function --------------------

	public static void commonFileReadMethods (File file) {
			
		System.out.println("canRead method: " + file.canRead());
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("Exists? " + file.exists());
		System.out.println("Is directory? " + file.isDirectory());
		
		System.out.println();
		
		
		// Rename the file to new file.
		System.out.println("Rename the file to new file.");
	
		File newFile = new File("resources/hamlet.txt");
		
		boolean success = file.renameTo(newFile);
		System.out.println("renameTo method: " + success);
						
		System.out.println("canRead method: " + file.canRead());
		System.out.println("Absolute path: " + file.getAbsolutePath());
		
	}

	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("resources/hamlet.txt");
		
		//CommonFileReadMEthods function
//		commonFileReadMethods(file);
		
		
		
		
		
		
		
		
		if (!file.exists()) {
		    System.out.println("File not found at: " + file.getAbsolutePath());
		    return;
		}
		
		
		Scanner input = new Scanner(file);
		
		int count = 0;
		
		while(input.hasNext()) {
			String word = input.next();
			count++;
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("Total words: " + count);
		System.out.println();
		
		input.close();
		
	}

}
