import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        String k = console.next();

        int n = (int) Math.pow(2, Integer.parseInt(k));

        System.out.printf("Think of a number between 0 and %d.\n", n);
        System.out.println("I will try to guess it. Answer with 'yes' or 'no'.");
        System.out.println();

        int result = binarySearch(console, 0, n);
        System.out.println("Your number is: " + result);

        console.close();
    }

    private static int binarySearch(Scanner console, int low, int high) {
        if (high - low == 1) return low;

        int mid = low + (high - low) / 2;
        System.out.printf("Is your number greater or equal to %d? (yes/no): ", mid);
        String response = console.next().toLowerCase();

        if (response.startsWith("y")) {
            return binarySearch(console, mid, high);
        } else {
            return binarySearch(console, low, mid);
        }
    }
}
