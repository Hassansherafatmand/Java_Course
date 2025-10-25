import princetonLibs.StdOut;
import princetonLibs.StdIn;


public class HashST<Key, Value> {
    
   

    private int n = 0;    // number of key-value pairs    
    private int m;        // number of Linked lists
    private Node[] lists; // linked list for hash i  

    // node helper class
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    
    // constructor
    public HashST() { lists = new Node[m];}
    
    
    // size
    public int size() {
        return n;
    }
    // check if the list is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // check if the specified key exist;
    public boolean contains(Key key) {
    	return get(key) != null;
    }

    // hash 
    private int hash(Key key) {
    	return Math.abs(key.hashCode() % m);
    }
    
    // get the value associated with a key
    public Value get(Key key) {
        
        int i = hash(key);
        for (Node x = lists[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    
    // inserts a key-value pair
    public void put(Key key, Value val) {
       
        int i = hash(key);
        for (Node x = lists[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        
        lists[i] = new Node(key, val, lists[i]);
    }
    
    
    // returns all the keys
    public Iterable<Key> keys(){
    	
    	Queue<Key> queue = new Queue<Key>();
    	for (int i = 0; i < m; i++) {
            for (Node x = lists[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    	
    }


    
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

