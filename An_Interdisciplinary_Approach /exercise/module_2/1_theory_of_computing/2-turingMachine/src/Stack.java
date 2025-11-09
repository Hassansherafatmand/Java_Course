import java.util.NoSuchElementException;

import princetonLibs.StdIn;
import princetonLibs.StdOut;

public class Stack <Item>{
	private Node first;
	private int n;
	
	private class Node {
		private Item item;
		private Node next;
	}
	
	public Stack() {
        first = null;
        n = 0;
    }
	
	public boolean isEmpty() {return first == null;}
	
	public int size() {return n;}
	
	public void push(Item item) {
		Node current  = first;
		first = new Node();
		first.item = item;
		first.next = current;
		n++;
	}
	
	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException("stack underflow");
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	public Item get(int index) {

	    Node current = first;
	    for (int i = 0; i < index; i++) {
	        current = current.next;
	    }
	    return current.item;
	}
	
	@Override
	public String toString() {
	    String s = "";
	    Node current = first;

	    // Traverse from top to bottom
	    while (current != null) {
	        s += current.item;
	        current = current.next;
	    }

	    return s;
	}
	
	public static void main (String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (!s.equals("-")) stack.push(s);
			else StdOut.print(stack.pop() + " ");
		}
				
		
	}
	
}
