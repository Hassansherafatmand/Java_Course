package module_7;

import java.util.*;

public class ArraysAndMethods {

	public static void main(String[] args) {
		
		
		//----------------- Practice 1 --------------------------------
		int [] list1 = new int [4];
		
	
		initializOddNumbs(list1);
		System.out.println();
		incrementArray(list1);

		
		
		
		// What if we dont construct the array, therefore, we have to return the reference to it. 
		//Otherwise, only the method will have a reference to constructed array.
		
		
		System.out.println();
		// if a method constructs an array, it doesnt have to be passed as a parameter, but it has to return by the method.
		
		int [] list2 = initializEvenNumbs(5);
		
		//printout the list array
				for(int i = 0; i < list2.length; i++) {
					System.out.print(list2[i]+ " ");
				}
		
		
		//----------------- Practice 2 --------------------------------
		System.out.println();
		System.out.println("List3: (For-Each-Loop)");
		int [] lists3 = initializEvenNumbs(5);
		
		for (int list: lists3 ) {
			System.out.print(list +2 + " ");
		}
		
		
		//----------------- Practice 3 --------------------------------
		System.out.println();
		System.out.println("-------------------------------------------");
		char []lists4 = {'A', 'B', 'C', 'D', 'E'};
		char []lists5 = Arrays.copyOf(lists4, 2 * lists4.length); //Create an array with the twice size of the lists4.
		for (char list : lists5) {
			System.out.print(list + " ");
		}
		System.out.println();
		System.out.println("Length of the lists4 array = " + lists4.length);
		System.out.println("Length of the lists5 array = " + lists5.length);
		
		
		//For Copy of portion of an array into another one, we can use Arrays.copyOfRange
		
		System.out.println();
		char []lists6 = Arrays.copyOfRange(lists4, 0, 2);
		for (char list : lists6) {
			System.out.print(list + " ");
		}
		System.out.println();
		System.out.println("Length of the lists6 array = " + lists6.length);
		
		
		//----------------- Practice 3 --------------------------------
		
		
		
		
		
	}
	

	//-------------------- initializOddNumb  Function --------------------
	public static void initializOddNumbs (int [] list) {
		
		System.out.print("Array of odd numbers: ");
		for(int i = 0; i < list.length; i++) {
			list[i] = i*2+1;
		}
		
		//printout the list array
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i]+ " ");
		}
				
	}
	
	//-------------------- incrementArray  Function --------------------
		public static void incrementArray (int [] list) {
			System.out.print("Increment the Array: ");
			for(int i = 0; i < list.length; i++) {
				list[i]++;
			}
			
			//printout list array
			for(int i = 0; i < list.length; i++) {
				System.out.print(list[i]+ " ");
			}
			
		}
	
	//-------------------- constructsArray  Function --------------------
		public static int[] initializEvenNumbs (int size) {
			int [] list = new int [size];
			
			System.out.print("Array of even numbers: ");
			for(int i = 0; i < size; i++) {
				list[i] = i*2;
			}
		
			return list;
		
		}
		
		
		
		
		
}

/*
 * int [] list = new int [4];
 * for(int i = 0; i < list.length; i++) {
			list[i] = i*2+1;
		}
		
		//printout list array
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i]+ " ");
		}
		
		//
		incrementArray(list);

		
		System.out.println();
		
		//printout list array
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i]+ " ");
		}
		
		//The lesson to draw from, is that whenever we pass an array as a parameter to a method, 
		//that method has the ability to change the content even though it does not return the array. 
		
 
 * */
 