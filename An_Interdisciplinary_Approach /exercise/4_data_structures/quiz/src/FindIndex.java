import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*
 * Given an array a[] of N distinct integers (positive or negative) in ascending order. 
 * Devise an algorithm to find an index i such that a[i] = i if such an index exists. 
 * Hint: binary search.
 * */

public class FindIndex {

	public static void main(String[] args) {
		
		ArrayList<Integer> list  =  new ArrayList<Integer>();
		Scanner console = new Scanner (System.in);
		
		// get array of numbers
		System.out.print("Please enter some integer numbers: ");
		while (true) {
            if (console.hasNextInt()) {
                list.add(console.nextInt());
            } else {
                break; 
            }
        }
		console.next();
		
		
		
		
		// filling the array form Arraylist
		int[] targetList = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
		    targetList[i] = list.get(i);
		}
		
		// display the sorted array;
		Arrays.sort(targetList);
		System.out.println(Arrays.toString(targetList));
		
		
		
		int result = search(targetList);
		if (result != -1)
            System.out.println("FindIndex program found at index " + result +
                               " (value = " + targetList[result] + ")");
        else
            System.out.println("The target index does not exist: i a[i] == i");

		
		
		
		System.out.println();


	}

	//-----------------  Search -------------------------
    private static int search(int[] items) {
    	
        return search( items, 0, items.length -1);
    }

    private static int search(int[] items, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (items[mid] == mid)
            return mid;
        else if (items[mid] > mid)
            return search(items, low, mid - 1);
        else
            return search(items, mid + 1, high);
    }
}
