import java.util.Scanner;

public class Grep {

	public static void main(String[] args) {
		String regexp = args[0];
		
		Scanner console =  new Scanner (System.in);
		
		while(console.hasNextLine()) {
			String line = console.nextLine();
			
			if(line.matches(".*" + regexp + ".*")) System.out.println(line);
		}

	}

}
