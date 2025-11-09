import princetonLibs.StdIn;
import princetonLibs.StdOut;
import princetonLibs.In;

public class TuringMachine {

    private String[] action;                       // L, R, Halt, Yes, No
    private ST<Character, Integer>[] next;         // next state for each symbol
    private ST<Character, Character>[] out;        // symbol to write for each symbol

    // -----------------------------------------------------------------
    // Construct the TM description from a file (state table)
    // -----------------------------------------------------------------
    public TuringMachine(String filename)
    {
        In in = new In(filename);
        int n = in.readInt();                // number of states
        String alphabet = in.readString();   // alphabet (e.g., 01#)

        action = new String[n];
        next   = (ST<Character, Integer>[])  new ST[n];
        out    = (ST<Character, Character>[]) new ST[n];

        for (int st = 0; st < n; st++)
        {
            action[st] = in.readString();

            // skip states that just halt or give Yes/No
            if (action[st].equals("Halt")) continue;
            if (action[st].equals("Yes"))  continue;
            if (action[st].equals("No"))   continue;

            // next-state table
            next[st] = new ST<Character, Integer>();
            for (int i = 0; i < alphabet.length(); i++)
            {
                int state = in.readInt();
                next[st].put(alphabet.charAt(i), state);
            }

            // output (write) table
            out[st] = new ST<Character, Character>();
            for (int i = 0; i < alphabet.length(); i++)
            {
                char symbol = in.readString().charAt(0);
                out[st].put(alphabet.charAt(i), symbol);
            }
        }
    }

    // -----------------------------------------------------------------
    // Simulate TM on given input
    // -----------------------------------------------------------------
    public String simulate(String input) {
        Tape tape = new Tape(input);
        int state = 0;

        while (action[state].equals("L") || action[state].equals("R")) {
            if (action[state].equals("R")) tape.moveRight();
            if (action[state].equals("L")) tape.moveLeft();

            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);
        }

        return action[state] + " " + tape;
    }

    // -----------------------------------------------------------------
    // Main test client
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine(args[0]);
        while (StdIn.hasNextLine())
            StdOut.println(tm.simulate(StdIn.readLine()));
    }
}
