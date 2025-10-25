import java.util.NoSuchElementException;

public class LinkedListStack {

	private int n;
	private Node first;
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public int size() {return n;}
	
	public void push(String item) {
		Node current = first;
		first = new Node();
		first.item = item;
		first.next = current;
		n++;
	}
	
	public String pop() {
		if(isEmpty())throw new NoSuchElementException("stack underflow");
		String string = first.item;
		first = first.next;
		n--;
		return string;
	}
	@Override
	public String toString() {
		String string = "";
		for (Node i = first; i != null; i = i.next) {
			string += i.item.concat(" ");
		}
		return string;
	}
}
