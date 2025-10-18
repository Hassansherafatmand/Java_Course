


public class PlayingCards {

	public static void main(String[] args) {
	
		String [] SUITS = {"♣️ Clubs", "♦️ Diamonds", "♥️ Hearts", "♠️  Spades"};
		String [] RANKS = 
			{
					"2", "3", "4", "5", "6", "7", "8", "9", "1", 
					"Jack", "Queen","King" 
	     	};
		String[] deck = new String[SUITS.length * RANKS.length];
		
		openCardBox(deck, SUITS, RANKS);
		
		// print the deck
		for (String card : deck) {
		    System.out.println(card);
		}
//		
		shuffleCards(deck);
//
		// print the deck
		for (String card : deck) {
		    System.out.println(card);
		}
		
		//Random pick
//		int i = (int) (Math.random() * RANKS.length);
//		int j = (int) (Math.random() * SUITS.length);
//		
//		System.out.println(RANKS[i] + " of " + SUITS[j]);

	}
	//------------------ openCardBox Method -------------------
	public static void openCardBox (String [] deck, String [] SUITS, String [] RANKS) {
		int index = 0;
		for (int i = 0; i < SUITS.length; i++) {
		    for (int j = 0; j < RANKS.length; j++) {
		        deck[index] = RANKS[j] + " of " + SUITS[i];
		        index++;
		    }
		}
		
	}
	
	//------------------ shuffleCards Method -------------------
	public static void shuffleCards (String [] deck) {
		int n = deck.length;
		for(int i = 0; i < n; i++) {
			int rand = (int) (Math.random() * (n - i));
			String temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		
		
	}
}
