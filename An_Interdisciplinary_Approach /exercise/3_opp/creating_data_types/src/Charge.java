
public class Charge {

	private final double rX, rY;
	private final double q;
	
	//------------------- constructor method --------------------
	public Charge(double x0, double y0, double q0) {
		
		this.rX = x0;
		this.rY = y0;
		this.q = q0;
		
	}
	
	public double potentialAt(double x, double y) {
		
		double k = 8.99e09;
		double dx = x - rX;
		double dy = y - rY;
		
		return((k * q) / Math.sqrt(dx * dx + dy * dy));
	}
	
	public String toString () {
		
		return q + " at (" + rX + ", " + rY + ")";
	}
}
