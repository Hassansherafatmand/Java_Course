package exercise;
import java.util.Scanner;

public class MyProgram {

    // -------- Distance Function -------------
    public static void calcDistance(String[] args) {
        // Get two Numbers
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        // Compute the Distance
        double distance = Math.sqrt(x*x + y*y);

        // Display the output
        System.out.println("Distance: " + distance);
    }

    public static void SumOfTwoDice (){
        //Define the variables
        int dice = 6;
        int a = 1 + ((int) (Math.random() * dice));
        System.out.println("a is: " + a);
        int b = 1 + ((int) (Math.random() * dice));
        System.out.println("b is: " + b);

        // Display the output
        System.out.println(a + b);
    }

    // -------- SumOfSines Function -------------
    public static void SumOfSines(String[] args){
         //Define the variables
         double degrees = Double.parseDouble(args[0]);
         double redianc = Math.toRadians(degrees);

         //Display the output
         System.out.println(redianc);
    }

    // -------- SpringSeason Function -------------
    public static void SpringSeason(String[] args){
        //Define the variables
       int month = Integer.parseInt(args[0]);
       int day = Integer.parseInt(args[1]);

       System.out.println(
        (month == 3 && day >= 20) ||   // March 20 → March 31
        (month == 4) ||                // All of April
        (month == 5) ||                // All of May
        (month == 6 && day <= 20) ); 
    }
    
    // --------  drawV Function -------------
    public static void drawV() {
        for (int line = 1; line <= 5; line++){ 
            for(int i = 1; i <= (line - 1); i++){ 
                System.out.print(" "); 
            } 
            for(int i = 1; i <= (11-2 * line); i++){ 
                System.out.print("1"); 
            } 
            
            System.out.println(); 
        }
    }
   
    // --------  stringObject Function -------------
    public static void stringObject(String s1){
        System.out.println("s1 contains: " + s1);
        System.out.println("startsWith method: " + s1.startsWith("When"));
        System.out.println("endsWith method: " + s1.endsWith("You?"));
        System.out.println("charAt method: " + s1.charAt(s1.length()-1)); //last charachter
        System.out.println("indexOf method: " +s1.indexOf("w"));
        System.out.println("replace method" + s1.replace("Are You", "is she"));
        System.out.println("subString method: " + s1.substring(0,3));        
    }


    // --------  Scanner Object Function -------------      
    public static void scannerObject (){
        Scanner scan = new Scanner (System.in);

        System.out.print("First Name: ");
        String firstName = scan.next();

        System.out.print("Last Name: ");
        String lastName = scan.next();

        System.out.println("Your name is " + firstName + " and your family is " + lastName + ".");

        scan.close();

    }
    // --------  Function -------------
    // --------  Function -------------
    // --------  Function -------------
    // --------  Function -------------
    // --------  Function -------------


    // -------- Main Method -------------
    public static void main(String[] args) {
        // Call the distance function
        // calcDistance(args);

        // call the SumOfTwoDice function
        // SumOfTwoDice();

        // call the SumOfSines function
        // SumOfSines(args);

        // call the SpringSeason function
        // SpringSeason(args);

        //Darw a V shape
        // drawV();

        // Useful MEthods of String Objects
        stringObject("How Are You?");

        // scannerObject ();

        // call the  function
        // call the  function
        // call the  function
        // call the  function


    }
}


 