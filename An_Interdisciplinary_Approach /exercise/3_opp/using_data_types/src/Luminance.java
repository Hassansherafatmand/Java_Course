import java.awt.Color;
import princetonLibs.*;

public class Luminance {

	public static void main(String[] args) {
		
		int [] colors = new int[6];
		
		for (int i = 0; i < colors.length; i++) 
			colors[i] = Integer.parseInt(args[i]);

		Color c1 = new Color(colors[0], colors[1], colors[2]);
		Color c2 = new Color(colors[3], colors[4], colors[5]);
		System.out.println(areCompatible(c1, c2));
	}

	//----------------- intensity ---------------------
	public static double intensity(Color c) {
		
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		
		return (0.299*r + 0.587*g + 0.114*b);
	}
	//----------------- toGray ---------------------
	public static Color toGray(Color c) {
		
		int y = (int) Math.round(intensity(c));
		Color gray = new Color(y, y, y);
		
		return gray;
	}
	//----------------- areCompatible ---------------------
	public static boolean areCompatible (Color c1, Color c2) {
		
		return Math.abs(intensity(c1) - intensity(c2)) >= 128.0;
	}
	//----------------- ---------------------
	
}
