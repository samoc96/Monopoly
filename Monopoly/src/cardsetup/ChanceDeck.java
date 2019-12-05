package cardsetup;

import java.util.Collections;

/**
 * 
 * @author SamOConnor<p>
 * Class that implements the interface deck, to store a deck of Chance cards.
 *
 */
public class ChanceDeck implements Deck{
	/**
	 * Construct a deck of chance cards by adding predefined chance cards to an arrayList of type CardDef.
	 * <p>Shuffle cards after.
	 */
	public ChanceDeck() {
		ChanceCards c = new ChanceCards();
		ChanceDeck.add(c.chance1);
		ChanceDeck.add(c.chance2);
		ChanceDeck.add(c.chance3);
		ChanceDeck.add(c.chance4);
		ChanceDeck.add(c.chance5);
		ChanceDeck.add(c.chance6);
		ChanceDeck.add(c.chance7);
		ChanceDeck.add(c.chance8);
		ChanceDeck.add(c.chance9);
		ChanceDeck.add(c.chance10);
		ChanceDeck.add(c.chance11);
		ChanceDeck.add(c.chance12);
		ChanceDeck.add(c.chance13);
		ChanceDeck.add(c.chance14);
		ChanceDeck.add(c.chance15);
		ChanceDeck.add(c.chance16);
		
		Collections.shuffle(ChanceDeck);
	}
	
	/**
	 * Returns a Chance Card and put's the remove chance card to the bottom of the deck.
	 */
	public CardDef getCard() {
		CardDef d = ChanceDeck.get(4);
		Collections.rotate(ChanceDeck, -1);
		return d;
	}
	/**
	 * Removes the drawn Chance card from the deck.<p>
	 * This method is required for the GOJ card.
	 */
	public void removeCard() {
		ChanceDeck.remove(0);
	}
}
