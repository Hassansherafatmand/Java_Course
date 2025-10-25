import java.util.Arrays;
import princetonLibs.*;

public class MergeSort1 {

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        
        sort(a);
        
        System.out.println(Arrays.toString(a));
    }

    //---------------- sort wrapper ----------------
    static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);   
    }

    //---------------- recursive sort ----------------
    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (low >= high) return;          

        int mid = low + (high - low) / 2;

        // Split into halves
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);      

        // Merge sorted halves
        merge(a, aux, low, mid, high);
    }

    //---------------- merge ----------------
    @SuppressWarnings("unchecked")
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        // Copy to aux[]
        for (int k = low; k <= high; k++)
            aux[k] = a[k];

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if      (i > mid)                a[k] = aux[j++];
            else if (j > high)               a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else                              a[k] = aux[i++];
        }
    }
}
