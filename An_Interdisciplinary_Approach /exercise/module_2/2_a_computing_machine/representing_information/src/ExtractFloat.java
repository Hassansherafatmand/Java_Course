public class ExtractFloat {

    public static void main(String[] args) {
        float x = Float.parseFloat(args[0]);
        int bits = Float.floatToRawIntBits(x);

        int signBit      = (bits >> 31)  & 0x00000001;
        int exponentBits = (bits >> 23)  & 0x000000FF;
        int fractionBits = (bits >>  0)  & 0x007FFFFF;

        int exponent = exponentBits - 127;
        double fraction = 1.0 * fractionBits / (1 << 23);
        double mantissa = 1.0 + fraction;

        if (signBit == 1) System.out.println("Sign:     -");
        else              System.out.println("Sign:     +");
        System.out.println("Exponent: " + exponent);
        System.out.println("Mantissa: " + mantissa);
    }
}

/******************************************************************************
 *  Compilation:  javac ExtractFloat.java
 *  Execution:    java ExtractFloat x
 *
 *  This program illlustrates the use of Java bit manipulation operations
 *  by extracting the sign, exponent, and fraction fields from a float
 *  value entered as the command-line argument.
 *
 *  % java ExtractFloat -100.25
 *      Sign: +
 *  Exponent: 6
 *  Mantissa: 1.56640625
 *  
 *  % java ExtractFloat 0.0
 *  Sign:     +
 *  Exponent: -127
 *  Mantissa: 1.0
 */