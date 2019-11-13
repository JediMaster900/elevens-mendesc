package app;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		// if there are two cards... return containsPairSum11
		if(selectedCards.size() == 2) return containsPairSum11(selectedCards);

		// else if there are three cards... return containsJQK
		else if(selectedCards.size() == 3) return containsJQK(selectedCards);
		// else return false
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		// get all of the cards that are still on the board
		List<Integer> cardsLeftOnBoard = cardIndexes();

		return this.containsPairSum11(cardsLeftOnBoard) || this.containsJQK(cardsLeftOnBoard);
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		// OUTER LOOP
		for(int x = 0; x < selectedCards.size(); x++){
			// get the card location from selectedCards
			int firstCardIndex = selectedCards.get(x).intValue();
			// load the card at the given index
			Card first = this.cardAt(firstCardIndex);
			for(int y = 0; y < selectedCards.size(); y++){
				// get the card location from selectedCards
				int secondCardIndex = selectedCards.get(y).intValue();
				// load the card at the given index
				Card second = this.cardAt(secondCardIndex);
				if(firstCardIndex != secondCardIndex && first.pointValue() + second.pointValue() == 11) return true;
			}
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		boolean foundJack = false;
		Boolean foundQueen = false;
		boolean foundKing = false;

		// TODO: loop through each card

		for(Integer i : selectedCards){
			if(cardAt(i).rank().equals("jack")) foundJack = true;
			else if(cardAt(i).rank().equals("queen")) foundQueen = true;
			else if(cardAt(i).rank().equals("king")) foundKing = true;
		}

		return foundJack && foundQueen && foundKing;
	}
}