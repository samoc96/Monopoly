package cardsetup;


import java.util.Collections;

/**
 * 
 * @author SamOConnor<p>
 * Class that implements the interface deck, to store a deck of community chest cards.
 *
 */
public class CommunityChestDeck implements Deck {
	
	/**
	 * Construct a deck of community chest cards by adding predefined community chest cards to an arrayList of type CardDef.
	 * <p>Shuffle cards after.
	 */
	public CommunityChestDeck() {
		CommunityChestCards c = new CommunityChestCards();
		CommunityChestDeck.add(c.CC1);
		CommunityChestDeck.add(c.CC2);
		CommunityChestDeck.add(c.CC3);
		CommunityChestDeck.add(c.CC4);
		CommunityChestDeck.add(c.CC5);
		CommunityChestDeck.add(c.CC6);
		CommunityChestDeck.add(c.CC7);
		CommunityChestDeck.add(c.CC8);
		CommunityChestDeck.add(c.CC9);
		CommunityChestDeck.add(c.CC10);
		CommunityChestDeck.add(c.CC11);
		CommunityChestDeck.add(c.CC12);
		CommunityChestDeck.add(c.CC13);
		CommunityChestDeck.add(c.CC14);
		CommunityChestDeck.add(c.CC15);
		CommunityChestDeck.add(c.CC16);
		
		Collections.shuffle(CommunityChestDeck);
	}
	
	/**
	 * Returns a community chest Card and put's the remove chance card to the bottom of the deck.
	 */
	public CardDef getCard() {
		CardDef d = CommunityChestDeck.get(0);
		Collections.rotate(CommunityChestDeck, -1);
		return d;
	}
	/**
	 * Removes the drawn community chest card from the deck.<p>
	 * This method is required for the GOJ card.
	 */
	public void removeCard() {
		CommunityChestDeck.remove(0);
	}
}
