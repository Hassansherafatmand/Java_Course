package quiz;

import java.util.Scanner;


public class Partition {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		
		System.out.print("Please Enter the Number: ");
		int n = console.nextInt();
		int max = n; // we assume the  
		
		int  []partition = new int [n];
		partition(partition, n, n, 0);
	
		
		
	}

	//----------------- partition ---------------------
	public static void partition(int [] partition, int n, int max, int counter) {
		
		 if (n == 0) {
            // print current partition
            for (int i = 0; i < counter; i++) {
            	
                if (i > 0) System.out.print(" ");
                System.out.print(partition[i]);
                
            }
            System.out.println();
            return;
	      }
		 
		 
		// recursive case
		    for (int i = Math.min(n, max); i >= 1; i--) {
		    	
		        partition[counter] = i;
		        
		     // print each index of the partition array with the associate value
		        System.out.printf("partition[%d] = %d\n",counter, i); 
		        
		        partition(partition,n - i, i,  counter + 1);
		    }
	}
}
