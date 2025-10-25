import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import princetonLibs.*;

public class ArrayStackOfStrings {
	private String[] items;
	private int n;
	
	//Constructor
	public ArrayStackOfStrings (int capacity) {
		items = new String[capacity];
	}
	
	public boolean isEmpty() {
		return (n == 0);
	}
	
	public void  push (String s) {
		items[n++] = s;
	}
	
	public String pop () {
		return items[--n];
	}
	
	public static void main(String[] args) {
		
//		File file = new File ("tobe.txt");
//		System.out.println(file.canRead());
//		System.out.println(file.getPath());
//		System.out.println(file.getAbsolutePath());
		
		
		int cap = Integer.parseInt(args[0]);
		ArrayStackOfStrings stack = new ArrayStackOfStrings(cap);
		
		Scanner inputScanner = new Scanner(System.in);
		
		while (inputScanner.hasNext()) {
			
			String s = inputScanner.next();
//			System.out.printf("word is [%s]\n", s); display each words;
			if (!s.equals("-")) {
			
				stack.push(s);
			}
			else 	System.out.print(stack.pop() + " ");
		}
		
		System.out.println();
		System.out.println(Arrays.toString(stack.items));
		
		
	}

}

/*
Echoes of Lordaeron: 

Long after heroes fall and kingdoms fade, the world remembers.
The echoes of their deeds whisper through stone and storm,
carried by the winds of time.
We are those echoes the will of Lordaeron,
reborn in frost, flame, and shadow.

*/