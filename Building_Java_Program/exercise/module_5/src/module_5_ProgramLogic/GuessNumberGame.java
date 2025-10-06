package module_5_ProgramLogic;

import java.util.*;

public class GuessNumberGame {

    // -------------------- getInt Function --------------------
    public static int getInt(Scanner console, String prompt) {
    	
        System.out.print(prompt);
        
        while (!console.hasNextInt()) {
            console.next(); // discard invalid input
            System.out.println("Not an integer; try again.");
            System.out.print(prompt);
        }
        
        return console.nextInt();
    }

    public static void main(String[] args) {
    	
        Scanner console = new Scanner(System.in);
        Random randNumber = new Random();
        int num = randNumber.nextInt(10) + 1; // 1–10 instead of 0–9
        int guessedNumber = getInt(console, "Please guess a number between 1 to 10: ");
        int count = 1;

        while (guessedNumber != num) {
            System.out.println("That is incorrect.");
            guessedNumber = getInt(console, "Try again: ");
            count++;
        }

        System.out.printf("The number was %d, and you got it in %d guesses.%n", num, count);
        console.close();
    }
}
