
import java.io.*;
import java.util.*;

import princetonLibs.*;
public class Concatenation {

	public static void main(String[] args) throws FileNotFoundException {
      
//		Out out = new Out(args[1]);
//		In in = new In(args[0]);
//		String s = in.readAll();
//		out.println(s);
		
		Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
		


    }

}
/* 
 PrintStream outPut = new PrintStream(new File(args[args.length - 1]));

for(int i = 0; i < args.length -1; i++) 
{
	Scanner input = new Scanner(new File (args[i]));
	while(input.hasNextLine()) 
	{
		String s = input.nextLine();
		outPut.println(s);
	}
	
	input.close();		
}
outPut.close();
 
 
 */
