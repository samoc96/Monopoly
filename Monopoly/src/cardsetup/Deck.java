package cardsetup;

import java.util.ArrayList;
/**
 * 
 * @author SamOConnor
 *Interface for both Chance and Community Chest Decks to implement.
 */
public interface Deck {
	CardDef getCard();
	void removeCard();
	ArrayList <CardDef> ChanceDeck = new ArrayList <CardDef>();
	ArrayList <CardDef> CommunityChestDeck = new ArrayList <CardDef>();
}
