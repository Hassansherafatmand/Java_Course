import princetonLibs.StdOut;
import princetonLibs.StdIn;

public class Converter {

   // converts integer n into a base b string
    public static String toString(int n, int base) {
        // special case
        if (n == 0) return "0";

        String s = "";
        while (n > 0) {
            s = toChar(n % base) + s;
            n = n / base;
        }
        return s;
    }

    // converts integer n into a base b string
    public static String toStringRecursive(int n, int base) {
        if (n == 0) return "";
        return toStringRecursive(n/base, base) + toChar(n % base);
    }

    // convert a String representing a base b integer into an int
    public static int parseInt(String s, int base) {
        int n = 0;
        for (int i = 0; i < s.length(); i++)
            n = base*n + toInt(s.charAt(i));
        return n;
    }

    public static int toInt(char c) {
        if (c < '0' || c > 'Z') throw new IllegalArgumentException("invalid char");
        if ((c >= '0') && (c <= '9')) return c - '0';
        return c - 'A' + 10;
    }

    public static char toChar(int i) {
        if (i < 0 || i > 36) throw new IllegalArgumentException("invalid digit");
        if (i < 10) return (char) ('0' + i);
        return (char) ('A' + i - 10);
    }


    // sample test client
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            int baseFrom = StdIn.readInt();
            int baseTo = StdIn.readInt();
            int n = parseInt(s, baseFrom);
            StdOut.println(toString(n, baseTo));
        }
    }
}
