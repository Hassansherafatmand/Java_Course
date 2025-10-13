import java.util.*;

public class MyBeer {

    public static void main(String[] args) {

        System.out.println("=== MyBeer Program ===");

        // Number of guests from command-line argument
        int numberOfGuests = Integer.parseInt(args[0]);

        // Array to represent beers
        int[] beers = new int[numberOfGuests];
        for (int i = 0; i < numberOfGuests; i++) {
            beers[i] = i;
        }

        int trials = 1000;  
        int successCount = 0;  

        // Run 1000 trials
        for (int t = 0; t < trials; t++) {
			
            // Shuffle for this trial
            shuffleBeer(beers);

            // Reset flag for each trial
            boolean someoneGotOwnBeer = false;

            // Check if any guest got their own beer
            for (int i = 0; i < numberOfGuests; i++) {
                if (beers[i] == i) {
                    someoneGotOwnBeer = true;
                    break;
                }
            }

            if (someoneGotOwnBeer) {
                successCount++;
            }
        }

        // Calculate fraction of successful trials
        double fraction = (double) successCount / trials;

        System.out.printf("Fraction of times = %.3f%n", fraction);
    }

    // -------------------- shuffleBeer Method --------------------
    public static void shuffleBeer(int[] list) {
        Random rand = new Random();

        for (int i = list.length - 1; i > 0; i--) {
            int randIndex = rand.nextInt(i + 1);
            int temp = list[i];
            list[i] = list[randIndex];
            list[randIndex] = temp;
        }
    }
}
