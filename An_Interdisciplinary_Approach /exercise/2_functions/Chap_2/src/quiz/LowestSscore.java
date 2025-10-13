package quiz;

import java.util.Random;

public class LowestSscore {

	public static void main(String[] args) {
		
		int totalStudents = 20000;
		int admitedApplicant = 5000;
		double mean = 1200.0;
		double stdDev = 100.0;
		
		/* I know that 20000 / 5000 = 4 therefore 100 / 4 = 25 => 25% of the student got high score.
		 * Therefore, it reminds 75% of the student have lower score.
		 * We can simulated the score program using the Normal distribution method like nextGaussian().
		 * We can then sort the array
		 * 
		 * 
		 * */
		
		
		// Generating the score in an array. 
		Random rand = new Random();
		double[] scores = new double[totalStudents];
		
		for (int i = 0; i < scores.length; i++) {
			// because mean is 1200.0, then we generating score around the mean some higher some lower.
		    scores[i] = mean + rand.nextGaussian() * stdDev;
		}
		
		// Sort the scores in ascending order
        sortArray(scores);

        // Find the lower score and higher
        double lowerScore = scores[totalStudents - admitedApplicant];
        double higherScore = scores[totalStudents - 1];
        
        // Display the result
        System.out.printf("Estimated lowest admitted SAT score: %.2f%n", lowerScore);
        System.out.printf("Estimated highest admitted SAT score: %.2f%n", higherScore);
		
		
	}
	
	// ------------------ sortArray -------------------
	public static void sortArray(double[] array) {
	    for (int i = 0; i < array.length - 1; i++) {        
	        for (int j = i + 1; j < array.length; j++) {      
	            if (array[j] < array[i]) {
	                double temp = array[i];
	                array[i] = array[j];
	                array[j] = temp;
	            }
	        }
	    }
	}

}
