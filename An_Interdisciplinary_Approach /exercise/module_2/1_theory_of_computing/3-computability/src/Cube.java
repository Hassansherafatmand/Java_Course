public class Cube {
    public static void main(String[] args) {
        for (long c = 1; ; c++) {
            for (long a = 1; a < c; a++) {
                for (long b = 1; b < c; b++) {
                    if (313 * (a*a*a + b*b*b) == c*c*c) {
                        System.out.println("Found: a=" + a + " b=" + b + " c=" + c);
                        return;
                    }
                }
            }
        }
    }
}
