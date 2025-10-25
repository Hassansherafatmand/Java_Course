import princetonLibs.StdOut;
import princetonLibs.StdIn;
public class Index {
    public static void main(String[] args) {
        int minLength     = Integer.parseInt(args[0]);    // min length of word
        int minOccurrence = Integer.parseInt(args[1]);    // min number of occurrences

        // read in the words from standard input
        String[] words = StdIn.readAllStrings();

        // build symbol table of words and locations
        ST<String, Queue<Integer>> st = new ST<String, Queue<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() < minLength) continue;
            if (!st.contains(s)) {
                st.put(s, new Queue<Integer>());
            }
            Queue<Integer> q = st.get(s);
            q.enqueue(i);
        }
        for (String s : st.keys()) {
            Queue<Integer> q = st.get(s);
            if (q.length() >= minOccurrence) {
                StdOut.println(s + ": " + q);
            }
        }
    }
}