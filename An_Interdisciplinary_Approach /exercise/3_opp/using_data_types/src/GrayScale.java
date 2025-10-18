
import java.awt.Color;

import princetonLibs.*;

public class GrayScale {

	public static void main(String[] args) {
		
//		String s = "cat.jpg"; 
		
		Picture pic = new Picture(args[0]); 

		for (int col = 0; col < pic.width(); col++) {
			for (int row = 0; row < pic.height(); row++) {
				Color c = pic.get(col, row);
				Color gray = Luminance.toGray(c);
				pic.set(col, row, gray);
				
				
			}
		}
		
		
		
		pic.show();

	}

}
