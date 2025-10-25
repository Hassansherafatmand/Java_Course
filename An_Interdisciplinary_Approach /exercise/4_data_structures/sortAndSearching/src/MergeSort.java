import java.util.Arrays;

import princetonLibs.*;

public class MergeSort {

	public static void main(String[] args) {
	
		 int[] numbers = {5, 2, 8, 3, 1, 9};

	        System.out.println("Before Sort: " + Arrays.toString(numbers));
	        
	        System.out.println("Length of the array: " + numbers.length);
	        
	        System.out.println();
	        mergeSort(numbers, 0, numbers.length - 1);
	        
	        System.out.println("After Sort: " + Arrays.toString(numbers));
	
		
	}
	
	//---------------- mergeSort ----------------
    public static void mergeSort(int[] a, int low, int high) {
    	// print the array each tile we split
    	System.out.println("Inside Sort: " + Arrays.toString(Arrays.copyOfRange(a, low, high + 1)));

    	
        if (low < high) {      	 
            int mid = (low + high) / 2;

            // Split into two halves
            mergeSort(a, low, mid); // left side
            
            mergeSort(a, mid + 1, high);

            

             //Merge the sorted halves
            merge(a, low, mid, high);
        }
    }

    //---------------- merge ----------------
    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        // Merge two sorted halves
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }

        // Copy remaining elements
        while (i <= mid) temp[k++] = a[i++];
        while (j <= high) temp[k++] = a[j++];

        // Copy sorted temp back into array
        for (i = 0; i < temp.length; i++) {
            a[low + i] = temp[i];
        }
    }
}


