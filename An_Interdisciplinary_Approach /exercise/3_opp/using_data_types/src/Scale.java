import princetonLibs.*;

public class Scale {

	public static void main(String[] args) {
	
		Picture source = new Picture(args[0]);
		System.out.println("source width = "+ source.width()); // 295
		System.out.println("source height = "+ source.height()); // 275
		
		int w = Integer.parseInt(args[1]);
		int h = Integer.parseInt(args[2]);
		
		Picture target = new Picture(w, h);
		
		for (int colT = 0; colT < w; colT++ ) {
			for (int rowT = 0; rowT < h;  rowT++) {
				
				int colS = colT * source.width() / w;
				int rowS = rowT * source.height() / h;
				
//				System.out.println(colS);
//				System.out.println(rowS);
				
				target.set(colT, rowT, source.get(colS, rowS));
			}
		}
		source.show();
		target.show();

	}

}


