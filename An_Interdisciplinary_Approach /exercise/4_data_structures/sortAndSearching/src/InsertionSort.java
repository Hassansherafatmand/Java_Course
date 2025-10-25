import java.util.Arrays;
import princetonLibs.*;

public class InsertionSort {

    public static void main(String[] args) {
        
        In in = new In(args[0]);
        String[] emails = in.readAllStrings();
        
        System.out.println("Before Sort: ");
        for (String email : emails) System.out.println(email);
        
        sort(emails);
      
        System.out.println();
        System.out.println("After Sort");
        for (String email : emails) System.out.println(email);
    }
    
  //--------------------- sort --------------------- 
    public static <T extends Comparable<T>> void sort(T[] emails) {
        for (int i = 1; i < emails.length; i++) {         
            for (int j = i; j > 0; j--) {                 
                if (emails[j].compareTo(emails[j - 1]) < 0) { 
                    T temp = emails[j];
                    emails[j] = emails[j - 1];
                    emails[j - 1] = temp;
                }
            }
        }
    }
}
