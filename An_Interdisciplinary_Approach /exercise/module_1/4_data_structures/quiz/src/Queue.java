import princetonLibs.*;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n = 0;  

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node previousLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else           previousLast.next = last;
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n--;
        return item;
    }

    public double length() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() { /* not used */ }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) queue.enqueue(s);
            else StdOut.print(queue.dequeue() + " ");
        }

        for (String s : queue) {
            StdOut.println(s);
        }

        StdOut.println();
    }
}
