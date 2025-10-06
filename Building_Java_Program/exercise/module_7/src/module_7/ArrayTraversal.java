package module_7;

import java.util.*;


public class ArrayTraversal {

	public static void main(String[] args) {
	
//		int [] list = {1, 5, 6, 2, 9, 4, 3};
//		
//		int target = 6;
		
//		printArray(list);
		
		
		// Searching an element inside an array ----------------------------------------	
//		 int result = searchElementInArray(list, target);
//		 if (result == -1)System.out.println("Not Found");		 
//		 else System.out.printf("Value Found in index of list[%d]" , result);
		
		 
		 
		// Replacing an int element inside an array ----------------------------------------
//		 System.out.println("Befor Replacement" + Arrays.toString(list));
//		 System.out.println("Replace number 9 with 10.");
//		 repplaceElementInArray(list, 9, 10);
//		 System.out.println("After Replacement" + Arrays.toString(list));
		 
		 
		// Replacing a string  element inside an array ----------------------------------------
//		 String []groceryList = {"apple","orange","milk","water","fish","cheesecake","salmon"};		
//		 
//		 System.out.println("Befor Replacement = " + Arrays.toString(groceryList));
//		 System.out.println("Replace the item 'water' with 'soda'.");
//		 
//		 repplaceStringElementInArray(groceryList, "water", "soda");
//		 
//		 System.out.println("After Replacement = " + Arrays.toString(groceryList));
		 
		 
		// Testing for Equality between two arrays ----------------------------------------
//		 String [] groceryList1 ={"apple","orange","milk","water"};
//		 String [] groceryList2 ={"apple","orange","milk","water", "soda"};
		 
//		 if(Arrays.equals(groceryList1, groceryList2)) System.out.println("Equals");
//			else System.out.println("NoT Equals");
//		 
//		 boolean status = testingEquality(groceryList1, groceryList2);// not equals
//		 System.out.println("Equals: " + status);
		 
		// Reversing an Array ----------------------------------------
		int [] list = {1, 5, 6, 2, 9, 4, 3};
		System.out.println(Arrays.toString(list));
		
//		reversingArray(list);
		
		// Reverse the string
		String s = "Mississippi";
		String result = "";
		System.out.println(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			result = s.charAt(i) + result;
		}
		System.out.println(result);
		
		
		
		
		
	}

	//-------------------- printArray  Function --------------------
	public static void printArray (int[] list) {
		System.out.println("This is the refrence or memory Address of the array: " + list);
		//Output:[I@79fc0f2f which is not the actual contents of the array, but rather its reference (memory address representation) in Java.
		
		System.out.println();
		//----------------- method 1 --------------------------------
		System.out.print("Method 1 using Arrays.toString() Method: ");
		System.out.println(Arrays.toString(list)); //Output: [1, 5, 6, 2, 9, 4, 3]
		
		
		System.out.println();
		//----------------- method 2 --------------------------------
		
		// print an array using for-loop : [1, 5, 6, 2, 9, 4, 3]
		System.out.print("Method 2 using for-loop: ");
		System.out.print("[" + list[0]);
		for(int i = 1; i <list.length; i++) {
			System.out.print(", " + list[i]);
		}
		System.out.print("]" );
		// There is an issue here which is if the array with a length of 0, we will encounter with the ArrayIndexOutOfBoundExecption error.
		
		System.out.println();
		//----------------- method 3 --------------------------------
		System.out.print("Method 3 using for-loop in a propper way: ");
			
			if (list[0]== 0) {
				System.out.println("[]");
			}
			else {
				System.out.print("[" + list[0]);
				
			}
			
			for(int i = 1; i <list.length; i++) {
				
				System.out.print(", " + list[i]);
			}
			
			System.out.print("]" );	
				
		
		
	}
	
	
	
	//-------------------- searchElementInArray  Function --------------------
	public static int searchElementInArray(int[] list, int target) {
		
		for (int i = 0; i <list.length; i++) {
			if(list[i] == target) { 
				return i;
			}
			
		}
		
	return -1;
	}

	
	//-------------------- repplaceElementInArray  Function --------------------
	public static  void  repplaceElementInArray (int [] list, int target, int replace) {
		
		for (int i =0; i < list.length; i++) {
			
			if(list[i] == target) list[i] = replace;
			
		}	
		
	}
	
	
	//-------------------- repplaceStringElementInArray  Function --------------------
	
	public static void repplaceStringElementInArray(String [] list, String target, String replace) {
		
		for(int i = 0; i <list.length; i++) {
			if(list[i].equalsIgnoreCase(target)) list[i] = replace;
		}
		
	}
	
	
	//-------------------- testingEquality  Function --------------------
	public static boolean testingEquality (String [] list1, String [] list2) {
		
		if(list1.length != list2.length) return false;
		
		for(int i = 0; i < list1.length; i++) {
			if (list1[i] != list2[i]) return false;
		}
		
		return true;
		
	}
	
	
	//-------------------- reversingArray  Function --------------------
	public static void reversingArray (int [] list) {
		
		
		int first = 0;
		int mid = list.length / 2;
		int lastIndex = list.length - 1;
		System.out.println("First number = " + list[first]);
		System.out.println("Mid number = " + list[mid]);
		System.out.println("last number = " + list[lastIndex]);
		
		for (int i = 0; i < mid; i++) {
	        int temp = list[i];
	        list[i] = list[lastIndex - i];
	        list[lastIndex - i] = temp;
	    }
		
		System.out.println(Arrays.toString(list));
	}
	
	
}
