

public class Sample {

	public static void main(String[] args) {
		
		
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		
		int [] sample = new int[n];
		
		for (int i = 0; i < n; i++) {
			sample[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			
			int random = i + (int) (Math.random() * (n  - i) );
			int  temp = sample[random];
			sample  [random] = sample [i];
			sample[i]= temp;
		}
		
		for (int i = 0; i < m; i++) {
			System.out.print(sample[i] + " ");
		}
		
		System.out.println();
	}

}
