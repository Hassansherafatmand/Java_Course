package caseStudy;

import java.util.*;
import java.io.*;

public class CaseStudy {

	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("Transition program:");
		System.out.println();
		
		transitionMethod();
		RandomSurferMethod();
		
	}

	
//	------------------ transition Method ------------------------------
	public static void transitionMethod () throws FileNotFoundException{
		
		
		 int n = 5; // number of pages
		    int[][] links = new int[n][n];
		    int[] outLinks = new int[n];
		    String inputPath = "resources/data.txt";
		    String outputPath = "resources/transition.txt";
		    double alpha = 0.9; // 90-10 rule

		    // Read data from file
		    try (Scanner input = new Scanner(new File(inputPath))) {
		        if (input.hasNextInt()) input.nextInt(); // skip the first number

		        while (input.hasNextInt()) {
		            int i = input.nextInt();
		            int j = input.nextInt();
		            links[i][j] = 1;
		            outLinks[i]++;
		        }
		    }

		    // Print matrix to console
		    System.out.println("Link Matrix:");
		    for (int[] row : links) {
		        for (int col : row) System.out.print(col + " ");
		        System.out.println();
		    }

		    // Print outlinks
		    System.out.println("\nOutlinks per page: " + Arrays.toString(outLinks));

		    // Compute transition matrix
		    double[][] transition = new double[n][n];
		    for (int i = 0; i < n; i++) {
		        for (int j = 0; j < n; j++) {
		            if (outLinks[i] == 0)
		                transition[i][j] = 1.0 / n;
		            else if (links[i][j] == 1)
		                transition[i][j] = alpha / outLinks[i] + (1 - alpha) / n;
		            else
		                transition[i][j] = (1 - alpha) / n;
		        }
		    }

		    // Write transition matrix to file
		    try (PrintStream output = new PrintStream(new File(outputPath))) {
		    	output.println(n);
		        System.out.println("\nTransition Matrix (also written to file):");
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < n; j++) {
		                System.out.printf("%.2f ", transition[i][j]);
		                output.printf("%.2f ", transition[i][j]);
		            }
		            System.out.println();
		            output.println();
		        }
		        System.out.println("\n✅ Transition matrix successfully saved to " + outputPath);
		    }
	}
	
	
//	------------------ RandomSurfer Method ------------------------------
	public static void RandomSurferMethod () throws FileNotFoundException {
		 // Number of random moves (trials)
        int trials = 1000;
        
        
        // Read the transition matrix file
        String addressFile = "resources/transition.txt";
        File file = new File(addressFile);
        Scanner input = new Scanner(file);
        
        int n = input.nextInt(); // number of pages
        double[][] p = new double[n][n];
        
        // Read the matrix into p[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = input.nextDouble();
            }
        }
        
        input.close();
        
      //****************************************
        // Track how many times each page is visited
        int[] freq = new int[n];

        // Start at page 0
        int page = 0;

        // Create a random number generator
        Random rand = new Random();

        // Simulate the random surfer for 'trials' moves
        for (int t = 0; t < trials; t++) {

            double r = rand.nextDouble(); // random number between 0 and 1
            double sum = 0.0;

            // Determine next page based on current page's probabilities
            for (int j = 0; j < n; j++) {
                sum += p[page][j];
                if (r < sum) {
                    page = j; // move to next page
                    break;
                }
            }

            // Record a visit to that page
            freq[page]++;        
        }
      
      // Print P to console
	    System.out.println("P Matrix:");
	    for (double[] row : p) {
	        for (double col : row) System.out.print(col + " ");
	        System.out.println();
	    }
        
	    System.out.println("\nPrint page ranks:");
	    // Print page ranks.
        for (int i = 0; i < n; i++) {
            System.out.printf("%8.2f", (double) freq[i] / trials);
        }
	    
	    
	}
	
	
	
	
}
