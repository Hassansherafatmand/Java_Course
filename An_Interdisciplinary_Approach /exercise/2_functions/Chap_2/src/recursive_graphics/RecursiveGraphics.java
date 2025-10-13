 package recursive_graphics;

import princetonLibs.StdDraw;

public class RecursiveGraphics {

    // reads an integer command-line argument n and plots an order n H-tree
    public static void main(String[] args) {
        int n = 3;

        double x = 0.5; 
        double y = 0.5;   
        double size = 0.5;    
        draw(n, x, y, size);
      
        
//        StdDraw.line(0.5, 0.5,1.0,0.5);
    }

    
  
  //---------------------- drawH Method -----------------------------
	private static void drawH(double x, double y, double size) {
		double x0 = x - size / 2;
		double x1 = x + size / 2;
		double y0 = y - size / 2;
		double y1 = y + size / 2;
		
		StdDraw.line(x0, y0, x0, y1); // print the left |
		StdDraw.line(x1, y0, x1, y1); // print the right |
		StdDraw.line(x0, y, x1, y);   // print the center line - 
		
	}


	  //---------------------- draw Method -----------------------------
		private static void draw(int n, double x, double y, double size) {
			
			if (n == 0) return;
//			  drawH(x, y, size); // without this call function
			
			double x0 = x - size / 2;
			double x1 = x + size / 2;
			double y0 = y - size / 2;
			double y1 = y + size / 2;
			
			StdDraw.line(x0, y0, x0, y1); // print the left |
			StdDraw.line(x1, y0, x1, y1); // print the right |
			StdDraw.line(x0, y, x1, y);   // print the center line - 
			
			 draw(n-1, x0, y0, size/2); // Print all bottom-left H
//			 draw(n-1, x0, y1, size/2); // Print all top-left H
//			 draw(n-1, x1, y0, size/2); // Print all bottom-right H
//			 draw(n-1, x1, y1, size/2); // Print all upper-right H
			

			
		}
	

}

  
