
public class DataMain {

public static void main(String[] args) {
		
		Date d1 = new Date(10, 17, 2025);
		Date d2 = new Date(1, 1, 2022);
		System.out.println("Difference days between them are: "  + d1.daysBetween(d2) + " days"); 
		
		
		Date d3 = new Date(10, 18, 2025);
		System.out.println("It's a " + d3.dayOfWeek()); // Saturday
		

	}

}
