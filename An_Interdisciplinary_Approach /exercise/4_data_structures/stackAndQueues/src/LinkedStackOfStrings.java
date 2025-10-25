import java.util.NoSuchElementException;
import java.util.Scanner;

import princetonLibs.StdOut;

public class LinkedStackOfStrings {
	private int n;
	private Node first;
	
	private class Node {
		private String item;
		private Node next;
	}
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void push(String item) {
		Node current = first;
		first = new Node();
		first.item = item;
		first.next = current;
		n++;
	}
	
	public String pop () {
		if(isEmpty())throw new NoSuchElementException("stack underflow");
		String item = first.item;
		first = first.next;
		n--;
		return item;
	}
	public int size() {
		return n;
	}
	
	public static void main(String[] args) {
		
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		
		Scanner input = new Scanner(System.in);
		
		while (input.hasNext()) {
			String word  = input.next();
			if (!word.equals("-"))     stack.push(word);
            else if (stack.isEmpty())  StdOut.println("BAD INPUT");
            else                       StdOut.print(stack.pop() + " ");
		}

	}

}
