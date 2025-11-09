/*************************************************************************
 *  Compilation:  javac SAT.java
 *  Execution:    java SAT tinySAT.txt
 *  Dependencies: In.java, StdOut.java (from Princeton library)
 *
 *  This program solves any SAT instance by enumerating all 2^n
 *  possible assignments of truth values and checking which one
 *  satisfies all clauses.
 *  It is an exponential-time algorithm.
 *************************************************************************/
import princetonLibs.*;


public class SAT {
    private boolean[] inSubset;
    private final String[] clauses;
    private final int n;

    // Constructor: tries all possible assignments
    public SAT(String[] clauses) {
        this.clauses = clauses;
        n = clauses[0].length();
        inSubset = new boolean[n];
        while (next()) {
            if (check(clauses, inSubset)) return;
        }
    }

    // Generate next truth assignment (binary counter style)
    private boolean next() {
        int i = n - 1;
        while (i >= 0 && inSubset[i]) {
            inSubset[i--] = false;
        }
        if (i < 0) return false;
        inSubset[i] = true;
        return true;
    }

    // Check whether the current assignment satisfies all clauses
    public static boolean check(String[] clauses, boolean[] inSubset) {
        boolean product = true;
        for (int i = 0; i < clauses.length; i++) {
            boolean sum = false;
            for (int j = 0; j < inSubset.length; j++) {
                if (clauses[i].charAt(j) == '+') sum = sum || inSubset[j];
                if (clauses[i].charAt(j) == '-') sum = sum || !inSubset[j];
            }
            product = product && sum;
        }
        return product;
    }

    // Return current assignment as a string (e.g., "01101")
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++)
            s.append(inSubset[i] ? '1' : '0');
        return s.toString();
    }

    // Main method reads clauses from file and solves the SAT instance
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String[] clauses = in.readAllStrings();
        SAT solver = new SAT(clauses);
        StdOut.println(solver);
    }
}
