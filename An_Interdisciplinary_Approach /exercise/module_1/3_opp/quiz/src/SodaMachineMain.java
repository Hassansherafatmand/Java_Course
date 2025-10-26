import java.util.Scanner;

public class SodaMachineMain {

	public static void main(String[] args) {
		
		
		SodaMachine user1 = new SodaMachine();		
		sodaMachine(user1);
		

	}
	
	//-------------------- sodaMachine -------------------------
	public static void sodaMachine(SodaMachine user) {
		System.out.println("Welcome to Redbuzz Soda Machine!");
        System.out.println("--------------------------------");
        System.out.println("1. Insert coin");
        System.out.println("2. Buy soda");
        System.out.println("3. Get change");
        System.out.println("4. Check machine status");
        System.out.println("5. Exit");
        System.out.println("--------------------------------");
		
		Scanner console = new Scanner (System.in);
		
		 while (true) {
	            System.out.print("Select an option (1-5): ");
	            int choice = console.nextInt();
	               
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter amount to insert ($): ");
	                    double amount = console.nextDouble();
	                    user.insertCoin(amount);
	                    break;

	                case 2:
	                	 System.out.print("\tEnter the Quantity: ");
	                	 int quantity = console.nextInt();
	                    user.buy(quantity);
	                    break;

	                case 3:
	                    user.getChange();
	                    break;

	                case 4:
	                    System.out.println(user);
	                    break;

	                case 5:
	                	 if (user.getBalance() > 0) {
	                	        System.out.println("You still have money in the machine.");
	                	        System.out.println("Please buy a soda or get your change first.");
	                	        break; 
	                	    }

	                	    System.out.println("Thank you for using Redbuzz Soda Machine!");
	                	    return; 
	                   

	                default:
	                    System.out.println("Invalid option. Please choose 1-5.");
	            }
	        }
		
		
	}
}
