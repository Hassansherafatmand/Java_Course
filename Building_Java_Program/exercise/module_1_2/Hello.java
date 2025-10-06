package exercise;
public class Hello {
   public static void main(String[] args) {
 // Parse command-line arguments
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        // Formula: distance^2 = x^2 + y^2
        int distanceSquared = (x * x) + (y * y);

        // Print result
        System.out.println("The squared distance from" +x +y + " to the origin is: " + distanceSquared);
   }
    
}
