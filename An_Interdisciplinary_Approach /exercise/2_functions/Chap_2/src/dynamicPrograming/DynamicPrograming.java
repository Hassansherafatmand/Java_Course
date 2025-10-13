package dynamicPrograming;

public class DynamicPrograming {

	private static int[] memo = new int[6]; // we only need up to 5

  

    public static void main(String[] args) {
    	
//        System.out.println(fib(5)); // This will print 5
        
    	fib(5);
    	
    	
    	
        for(int item : memo) {
        	System.out.print(item + ", ");
        }
        
        
        
        
        
    }

    
    
    //---------------- fib Method ------------------------
    public static int fib(int n) {
    	
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] > 0) return memo[n]; // reuse if we have it

        // Otherwise, compute and store it
        memo[n] = fib(n - 1) + fib(n - 2);
        System.out.printf("memo[%d] = %d\n" , n, memo[n]);
        return memo[n];
    }
}
