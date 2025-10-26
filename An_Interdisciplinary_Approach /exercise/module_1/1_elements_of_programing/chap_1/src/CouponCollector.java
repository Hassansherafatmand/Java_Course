

public class CouponCollector {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		boolean [] isCollected = new boolean [n];
		int count = 0;
		int distinct  = 0;
		
		while (distinct < n) {
			int r = (int) (Math.random() * n);
			count ++;
			
			if(!isCollected[r]) {
				distinct++;
				isCollected[r] = true;
				
			}
			
		}
		
		System.out.println(count);
		
	}

}


//for (int i = 0; i < n; i++) {
//	System.out.print(test[i] + " ");
//}