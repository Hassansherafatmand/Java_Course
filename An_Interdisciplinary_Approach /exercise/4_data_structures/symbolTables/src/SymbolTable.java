import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import princetonLibs.StdIn;
import princetonLibs.StdOut;

/**
 * SymbolTable represents an ordered symbol table using a TreeMap.
 * It stores key–value pairs where keys must be comparable.
 *
 * Compilation:  javac SymbolTable.java
 * Execution:    java SymbolTable < tinyST.txt
 * Dependencies: StdIn.java, StdOut.java
 */
public class SymbolTable<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private final TreeMap<Key, Value> st;

    /** Initializes an empty symbol table. */
    public SymbolTable() {
        st = new TreeMap<Key, Value>();
    }

    /** Returns the value associated with the given key. */
    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("called get() with null key");
        return st.get(key);
    }

    /**
     * Inserts the specified key–value pair into the symbol table.
     * If the key already exists, its value is replaced.
     * If the value is null, the key is removed.
     */
    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("called put() with null key");
        if (val == null)
            st.remove(key);
        else
            st.put(key, val);
    }

    /** Removes the specified key and its value from the table (deprecated alias). */
    @Deprecated
    public void delete(Key key) {
        remove(key);
    }

    /** Removes the specified key and its value from the table. */
    public void remove(Key key) {
        if (key == null)
            throw new IllegalArgumentException("called remove() with null key");
        st.remove(key);
    }

    /** Returns true if this symbol table contains the given key. */
    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("called contains() with null key");
        return st.containsKey(key);
    }

    /** Returns the number of key–value pairs in this table. */
    public int size() {
        return st.size();
    }

    /** Returns true if the table is empty. */
    public boolean isEmpty() {
        return st.isEmpty();
    }

    /** Returns all keys in ascending order. */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /** Returns an iterator over all keys (deprecated alias). */
    @Deprecated
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /** Returns the smallest key. */
    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("called min() with empty symbol table");
        return st.firstKey();
    }

    /** Returns the largest key. */
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("called max() with empty symbol table");
        return st.lastKey();
    }

    /** Returns the smallest key ≥ the given key. */
    public Key ceiling(Key key) {
        if (key == null)
            throw new IllegalArgumentException("called ceiling() with null key");
        Key k = st.ceilingKey(key);
        if (k == null)
            throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /** Returns the largest key ≤ the given key. */
    public Key floor(Key key) {
        if (key == null)
            throw new IllegalArgumentException("called floor() with null key");
        Key k = st.floorKey(key);
        if (k == null)
            throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /** Unit test: builds a symbol table from standard input and prints it. */
    public static void main(String[] args) {
        SymbolTable<String, Integer> st = new SymbolTable<String, Integer>();
        int i = 0;
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            st.put(key, i++);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
