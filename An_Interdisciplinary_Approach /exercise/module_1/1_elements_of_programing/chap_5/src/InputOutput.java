import java.awt.Color;

public class InputOutput {

	public static void main(String[] args) {
		
		
//		  int numbCircle = Integer.parseInt(args[0]);        
//	      double probBlack = Double.parseDouble(args[1]); 
//	      double minRadius = Double.parseDouble(args[2]);      
//	      double maxRadius = Double.parseDouble(args[3]);   
	      
	      int numbCircle =   200;      
	      double probBlack = 0.75;
	      double minRadius = 0.01;     
	      double maxRadius = 0.1;
	      double range = maxRadius - minRadius;
	      
	      for (int i = 0; i < numbCircle; i++) {
	    	  
	    	  // creating some random  for each circle 
	    	  double x = Math.random();
	          double y = Math.random();
	    	  
	          
	          double radius = minRadius + ( Math.random() * range );
	          
	          if (Math.random() < probBlack) {
	                StdDraw.setPenColor(Color.BLACK);
	            } 
	          else {
	                StdDraw.setPenColor(Color.WHITE);
	            }
	          
	          // draw the circle with the x and y coordinates and its radius
	            StdDraw.filledCircle(x, y, radius);
	            
	            // display the circle	           
	            StdDraw.show();
	      }
	      
	      
	}

}
