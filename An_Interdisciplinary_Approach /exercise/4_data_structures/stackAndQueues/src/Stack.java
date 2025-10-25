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
	public static void main (String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (!s.equals("-")) stack.push(s);
			else StdOut.print(stack.pop() + " ");
		}
				
		
	}
	
}
