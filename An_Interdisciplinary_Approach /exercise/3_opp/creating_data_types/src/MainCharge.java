

public class MainCharge {

	public static void main(String[] args) {
		
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		Charge c1 = new Charge(0.51, 0.63, 21.3);
		Charge c2 = new Charge(0.13, 0.94, 81.9);
		
		System.out.println(c1);
		System.out.println(c2);
		
		double v1 = c1.potentialAt(x, y);
		double v2 = c2.potentialAt(x, y);
		
		System.out.printf("%.2e\n", (v1 + v2));

	}

}
