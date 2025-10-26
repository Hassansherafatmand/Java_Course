import java.util.NoSuchElementException;
import princetonLibs.StdIn;
import princetonLibs.StdOut;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private final Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {}

    public boolean isEmpty() { return size() == 0; }
    public int size() { return size(root); }
    private int size(Node x) { return (x == null) ? 0 : x.size; }

    public boolean contains(Key key) { return get(key) != null; }

    public Value get(Key key) { return get(root, key); }
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() { root = deleteMin(root); }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMax() { root = deleteMax(root); }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) { root = delete(root, key); }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key min() { return min(root).key; }
    private Node min(Node x) { return (x.left == null) ? x : min(x.left); }

    public Key max() { return max(root).key; }
    private Node max(Node x) { return (x.right == null) ? x : max(x.right); }

    public Key floor(Key key) {
        Node x = floor(root, key);
        return (x == null) ? null : x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        return (t != null) ? t : x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        return (x == null) ? null : x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        return (t != null) ? t : x;
    }

    public Key select(int k) { return select(root, k).key; }
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) { return rank(key, root); }
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public Iterable<Key> keys() { return rangeSearch(min(), max()); }

    public Iterable<Key> rangeSearch(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> q = new Queue<Node>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node x = q.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            q.enqueue(x.left);
            q.enqueue(x.right);
        }
        return keys;
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) st.put(StdIn.readString(), i);
        for (String s : st.levelOrder()) StdOut.println(s + " " + st.get(s));
    }
}
