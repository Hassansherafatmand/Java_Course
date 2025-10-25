import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LargestOne {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        // // get array of numbers
        System.out.print("Please enter some integer numbers(to stop press any letters): ");
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

        // display the array
        System.out.println("Array = " + Arrays.toString(targetList));
       
        Arrays.sort(targetList);
        

        // asking for the kth
        System.out.print("Choose kth which is the index of the largest number: ");
        int k = console.nextInt();
        console.close();
        System.out.println();
        
        // find the largest number
        int index = targetList.length - k;


        System.out.printf("The %dth largest number is %d\n", k, targetList[index]);
    }
}
