
public class Tape {

	private Stack<Character> left = new Stack<Character>();
	private Stack<Character> right = new Stack<Character>();
	private char current;
	
	public Tape(String input) {
		
		right.push('#');
		
		for(int i = input.length() - 1; i >= 0; i--) {
			right.push(input.charAt(i));
		}
		current = right.pop();
	}
	
	public char read() {return current;}
	
	public void write(char symbol) {current = symbol;}
	
	public void moveLeft () {
		right.push(current);
		if (left.isEmpty()) left.push('#');
		
		current = left.pop();
	}
	
	public void moveRight () {
		left.push(current);
		if(right.isEmpty()) right.push('#');
		
		current = right.pop();
	}
	
	@Override
	public String toString() {
	    String s = "";

	    // Prints all the left side (from bottom to top)
	    for (int i = 0; i < left.size(); i++) {
	        s += left.get(i);
	    }

	    // Marks the current head position
	    s += "[" + current + "]";

	    // Prints all the side (top of stack is closest to head)
	    for (int i = right.size() - 1; i >= 0; i--) {
	        s += right.get(i);
	    }

	    return s;
	}

}
