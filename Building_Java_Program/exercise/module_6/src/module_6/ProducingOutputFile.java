package module_6;

import java.io.*;
import java.util.*;

public class ProducingOutputFile {

	public static void main(String[] args) throws FileNotFoundException {
		producingOutput();

	}

	//-------------------- producingOutput Function --------------------
	public static void producingOutput()throws FileNotFoundException {
		
		
		PrintStream output = new PrintStream(new File("resources/outputFile1.txt"));
		output.println("Hello Java!");
		output.println();
		
		output.println("Java is my favorite programing language.");
	}
	
}
