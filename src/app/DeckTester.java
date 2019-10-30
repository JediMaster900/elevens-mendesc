package app;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		/**** EXAMPLE DECK 1 *****/
		System.out.println("----TESTING DECK 1----");
		// create a deck
		String[] suits = {"clubs", "hearts", "diamonds", "spades"};
		String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		int [] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		Deck deck = new Deck(ranks, suits, pointValues);

		// test its size

		// deal one card
		System.out.println("Deck size: " + deck.size());
		Card x = deck.deal();
		System.out.println("Yo homie, I just dealt this card: " + x);
		System.out.println("Now my deck size is: " + deck.size());
		System.out.println(deck);

		// test two string
	}
}

