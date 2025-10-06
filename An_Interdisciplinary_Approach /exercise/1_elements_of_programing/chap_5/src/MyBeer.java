
import java.util.*;


public class MyBeer {

	public static void main(String[] args) {
		
		System.out.println("MyBeer Program");

//		int numberOfGuests = 5; // For test
		int numberOfGuests = Integer.parseInt(args[0]);
/ 		
		boolean someoneGottheirOwnBeer = false;
		int []beers = new int [numberOfGuests];
				
		
		// here ever guess picks their beer => guess[0] = 0, guess[1] = 1
		for (int i = 0; i < numberOfGuests; i++) {
            beers[i] = i;  
        }
		
		
		//We are going to shuffle the array (beer). because array is an object the method has the 
		// ability to change the array content.
		shuffleBeer(beers);
		
		
		//display which guess has picked which beer
		for (int i = 0 ; i < beers.length; i++) {
			System.out.printf("Guest [%d] picked beer [%d]%n", i, beers[i]);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("display who got their own beer:");
		
		int trials = 10 ; // or 1000 time
		int count = 0;
		
		for (int i = 1 ; i < trials; i++) {
			
			for (int j = 0 ; j < beers.length; j++) {
				
				if (beers[j] == j) {
					 System.out.printf("  => Guest %d got their own beer! \n", j);
					 someoneGottheirOwnBeer = true;
					 break;
					 
				}
				if(!someoneGottheirOwnBeer) {
					 count++;
				}
				
			}
			if(!someoneGottheirOwnBeer) {
				 System.out.println("No one got their own beer this time.");
				 
			}
		}
		
		double fraction = (double) count / trials;
		System.out.println("fraction of times = " + fraction);
		
		
		
	}

//	-------------------- shuffleBeer Method --------------------
	public static void shuffleBeer (int [] list) {
		Random randnumber = new Random();
		
		
		for (int i = (list.length - 1) ; i > 0 ; i-- ) {
			
			int rand = randnumber.nextInt(i +1);
			int temp = list[i];
			list[i] = list[rand];
			list[rand]= temp;
		}

	}
	
	
}
