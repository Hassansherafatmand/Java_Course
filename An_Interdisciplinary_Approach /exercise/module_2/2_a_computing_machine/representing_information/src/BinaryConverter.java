

public class BinaryConverter {
	// convert a String of 0s and 1s into an integer
    public static int parseInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if      (c == '0') result = 2 * result;
            else if (c == '1') result = 2 * result + 1;
        }
        return result;
    }

    // convert an int into a String of 0s and 1s
    public static String toBinaryString(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");

        // special case
        if (n == 0) return "0";

        // build string from right to left
        String s = "";
        while (n > 0) {
            if (n % 2 == 0) s = '0' + s;
            else            s = '1' + s;
            n = n / 2;
        }
        return s;
    }


    public static void main(String[] args) {
        int n = 47;
        String s = "101111";
        System.out.println(n +  ":  " + toBinaryString(n));
        System.out.println(s +  ":  " + parseInt(s));
    }

}
