package module_7;

import java.util.*;

public class ReferenceType {

	public static void main(String[] args) {
		
		// Primitives are value types: A system in which values are stored directly  and copying is achieved by creating independent copies of values.
		// Objects are reference type:  A system which reference to values are stored and copying is achieved by copying these references.
		
		
		int [] list1 = {1, 2,3, 4, 5};
		int [] list2 = {1, 2,3, 4, 5};
		int []list3 = list2;
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
		System.out.println(Arrays.equals(list1,list2)); // true; this method checks the content between both arrays.s
		System.out.println(list1 == list2);
		// false, it because list1 and list2 variable both refer to two different objects. List1 refers to [I@79fc0f2 ,but list2 refers to [I@50040f0c
		
		System.out.println(list2 == list3);// true, it because both lists are referring to one object [I@50040f0c.
		
		
		String s = null;
		int [] list4 =  null;
		System.out.println(s); // null
		System.out.println(list4); //null
	}	
	
}
