/******************************************************************************
 *  Simple SET implementation using Java's TreeSet
 *  ----------------------------------------------
 *  - Stores unique, ordered keys
 *  - No duplicates allowed
 *  - Supports basic set operations and ordering (min, max, floor, ceiling)
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import princetonLibs.*;

public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    // Create an empty set
    public SET() {
        set = new TreeSet<Key>();
    }

    // Create a copy of another set
    public SET(SET<Key> x) {
        set = new TreeSet<Key>(x.set);
    }

    // Add key if not already present
    public void add(Key key) {
        if (key == null) throw new IllegalArgumentException("add() null key");
        set.add(key);
    }

    // Remove a key
    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("remove() null key");
        set.remove(key);
    }

    // Alias for remove (deprecated)
    @Deprecated
    public void delete(Key key) {
        remove(key);
    }

    // Check if set contains a key
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("contains() null key");
        return set.contains(key);
    }

    // Return number of keys
    public int size() {
        return set.size();
    }

    // Check if empty
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // Smallest key
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("empty set");
        return set.first();
    }

    // Largest key
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("empty set");
        return set.last();
    }

    // Smallest key >= given key
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("ceiling() null key");
        Key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("no key ≥ " + key);
        return k;
    }

    // Largest key <= given key
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("floor() null key");
        Key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("no key ≤ " + key);
        return k;
    }

    // Union of two sets
    public SET<Key> union(SET<Key> that) {
        if (that == null) throw new IllegalArgumentException("union() null set");
        SET<Key> c = new SET<Key>();
        for (Key x : this) c.add(x);
        for (Key x : that) c.add(x);
        return c;
    }

    // Intersection of two sets
    public SET<Key> intersects(SET<Key> that) {
        if (that == null) throw new IllegalArgumentException("intersects() null set");
        SET<Key> c = new SET<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) if (that.contains(x)) c.add(x);
        } else {
            for (Key x : that) if (this.contains(x)) c.add(x);
        }
        return c;
    }

    // Compare sets
    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        SET that = (SET) other;
        return this.set.equals(that.set);
    }

    // Unsupported (mutable structure)
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() not supported");
    }

    // Return iterator
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    // String form
    @Override
    public String toString() {
        String s = set.toString();
        return "{ " + s.substring(1, s.length() - 1) + " }";
    }

    // Test client
    public static void main(String[] args) {
        SET<String> set = new SET<>();

        // add keys
        set.add("www.cs.princeton.edu");
        set.add("www.princeton.edu");
        set.add("www.math.princeton.edu");
        set.add("www.google.com");

        StdOut.println(set.contains("www.google.com"));
        StdOut.println(set.ceiling("www.goo"));
        StdOut.println(set.floor("www.goo"));

        for (String s : set)
            StdOut.println(s);
    }
}
