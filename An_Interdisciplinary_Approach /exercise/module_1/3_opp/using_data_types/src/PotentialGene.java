
public class PotentialGene {

	public static void main(String[] args) {
	
		 String s = args[0];
		boolean dna = isPotentialGene(s);
		System.out.println(isPotentialGene(s));
       

	}
	//---------------------- isPotentialGene ----------------------
	public static boolean isPotentialGene(String s) {
		
		String dna = s.toUpperCase();
		
		// the length is a multiple of 3
		if (s.length() % 3 != 0) return false;
		
		if(!dna.startsWith("ATG")) return false;
		
		// check if the string is intervened by these characters
		for (int i= 0; i <s.length() - 3; i++) {
			if(i % 3 == 0) {
				String codon = dna.substring(i, i+ 3);
				if (codon.equals("TAA")) return false;
				if (codon.equals("TGA")) return false;
				if (codon.equals("TAG")) return false;
				
			}
		}
		
		// check if the string ends with these characters
		if(dna.endsWith("ATG")) return true;
		if(dna.endsWith("TGA")) return true;
		if(dna.endsWith("TAG")) return true;
		
		return false;
	}
}
