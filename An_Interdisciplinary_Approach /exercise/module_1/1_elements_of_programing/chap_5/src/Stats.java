

public class Stats {

    public static void main(String[] args) {
    	// for test the program:
//    	int numbers = 4; 
//    	double [] values = {6.7, 89.5, 6.45, 71.6}; 
    	
    	
        //get a number of values to read
        int numbers = Integer.parseInt(args[0]);
    	
        double[] values = new double[numbers];

        
        for (int i = 0; i < numbers; i++) {
            values[i] = StdIn.readDouble();
        }

        //compute the mean
        double sum = 0.0;
        for (int i = 0; i < numbers; i++) {
            sum += values[i];
        }
        
        double mean = sum / numbers;

        //compute the sample standard deviation
        double sumOfSquares = 0.0;
        for (int i = 0; i < numbers; i++) {
            sumOfSquares += (values[i] - mean) * (values[i] - mean);
        }
        double stddev = Math.sqrt(sumOfSquares / (numbers - 1));

        //display the results
        StdOut.printf("Mean = %.2f\n" , mean);
        StdOut.printf("Sample standard deviation = %.2f" , stddev);
    }
}