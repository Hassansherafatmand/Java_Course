import java.util.NoSuchElementException;

public class Stack<Item> {
    private Node first;
    private int n;

   
    private class Node {
        private Item item;
        private Node next;
    }

    // Constructor
    public Stack() {
        first = null;
        n = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Return the number of items
    public int size() {
        return n;
    }

    // Push an item onto the stack
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    // Pop an item from the stack
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    // Return (but do not remove) the top item
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
}
