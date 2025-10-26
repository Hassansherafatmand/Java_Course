import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ThreeSum {

    //--------------------- readInput ----------------------
    public static int[] readInput(String fileAddress) throws FileNotFoundException {
    	
    	
        Scanner input = new Scanner(new File(fileAddress));
        
       
        
        ArrayList<Integer> list = new ArrayList<>();

        while (input.hasNextInt()) {
            list.add(input.nextInt());
        }
        input.close();

        // Convert ArrayList to array
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    //--------------------- counterTriples ----------------------
    public static int counterTriples(int[] a) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                    	System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //--------------------- main ----------------------
    public static void main(String[] args) throws FileNotFoundException {


        String fileAddress = "data/1kints.txt";
       
        int[] numbers = readInput(fileAddress);
        int count = counterTriples(numbers);

        System.out.println("Number of triples that sum to 0: " + count);
    }
}
