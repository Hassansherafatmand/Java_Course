import princetonLibs.StdOut;
import princetonLibs.StdIn;

/**
 *  The {@code HashST} class represents a symbol table of generic key–value pairs.
 *  It uses a separate chaining hash table implementation.
 *
 *  Compilation:  javac HashST.java
 *  Execution:    java HashST < input.txt
 *  Dependencies: StdIn.java, StdOut.java, Queue.java
 *
 *  This implementation:
 *  - Resizes the hash table dynamically to maintain performance.
 *  - Supports insertion, deletion, and lookup in expected constant time.
 *
 *  Example input:
 *      A B C D E
 *  Example output:
 *      A 0
 *      B 1
 *      C 2
 *      D 3
 *      E 4
 */
public class HashST<Key, Value> {
    
    private static final int INIT_CAPACITY = 4; // initial number of chains

    private int n;        // number of key-value pairs
    private int m;        // number of chains
    private Node[] st;    // array of linked-list symbol tables

    /** Helper linked list data type */
    private static class Node {
        private final Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /** Initializes an empty symbol table. */
    public HashST() {
        this(INIT_CAPACITY);
    }

    /** Initializes an empty symbol table with {@code m} chains. */
    public HashST(int m) {
        this.m = m;
        st = new Node[m];
    }

    // Computes hash value between 0 and m-1.
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // Resizes the hash table to have the given number of chains (rehashing all keys).
    @SuppressWarnings("unchecked")
    private void resize(int chains) {
        HashST<Key, Value> temp = new HashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                temp.put((Key) x.key, (Value) x.val);
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    /** Returns the number of key-value pairs in this symbol table. */
    public int size() {
        return n;
    }

    /** Returns true if this symbol table is empty. */
    public boolean isEmpty() {
        return size() == 0;
    }

    /** Returns true if this symbol table contains the specified key. */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /** Returns the value associated with the specified key, or {@code null} if not found. */
    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    /**
     * Inserts the specified key–value pair into the symbol table,
     * overwriting the old value if the key already exists.
     * Removes the key if the value is {@code null}.
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            remove(key);
            return;
        }

        // Double table size if average list length ≥ 10
        if (n >= 10 * m) resize(2 * m);

        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]);
    }

    /** Removes the specified key and its associated value from the symbol table. */
    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to remove() is null");

        int i = hash(key);
        st[i] = remove(st[i], key);

        // Halve table size if average list length ≤ 2
        if (m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }

    // Recursively removes a key in the linked list beginning at Node x.
    private Node remove(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = remove(x.next, key);
        return x;
    }

    /** Returns all keys in the symbol table. */
    @SuppressWarnings("unchecked")
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }

    /** Unit test: reads keys from StdIn and prints each key with its value. */
    public static void main(String[] args) {
        HashST<String, Integer> st = new HashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // Print keys and values
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
