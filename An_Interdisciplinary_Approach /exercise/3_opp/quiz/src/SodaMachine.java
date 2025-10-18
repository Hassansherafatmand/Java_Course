
public class SodaMachine {

	private double balance;
	private int stock;
	private double price;
	
	// -------------------- Constructor --------------------
    public SodaMachine(double price, int stock) {
        this.price = price;
        this.stock = stock;
        this.balance = 0;
    }
    public SodaMachine() {
        this.price = 1;
        this.stock = 50; // number of Soda are available
        this.balance = 0;
    }
    
    
 // -------------------- Getters and Setters --------------------
	public double getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
	
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	
	public double getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	
	
	// -------------------- Methods --------------------
	public void insertCoin( double amount) {
		
		if (amount > 0) {
			balance += amount;
			System.out.printf("You inserted: %.1f\n" , amount);
		}
		
	}; 
	
	public void buy(int quantity) {
		if (stock == 0) {
	        System.out.println("Out of stock!");
	        return;
	    }

	    if (quantity <= 0) {
	        System.out.println("Invalid quantity.");
	        return;
	    }

	    if (quantity > stock) {
	        System.out.println("Not enough sodas in stock.");
	        return;
	    }

	    double totalCost = price * quantity;

	    if (balance < totalCost) {
	        System.out.printf("Not enough money. Please insert $%.2f more.%n", totalCost - balance);
	        return;
	    }

	    stock -= quantity;
	    balance -= totalCost;
	    System.out.println("Enjoy your " + quantity + " soda(s)!");
	}
	
	public void getChange() {
		System.out.printf("Returning the remaining change: $%.2f\n", balance);
		this.balance = 0.0;
	}
	
	
	@Override
    public String toString() {
        return String.format("SodaMachine [Price = $%.2f, Stock = %d, Balance = $%.2f]",
                              price, stock, balance);
    }
	
	
	
	
	
	
}
