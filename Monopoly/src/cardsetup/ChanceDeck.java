package cardsetup;

import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck{
	ChanceCards c = new ChanceCards();
	private ArrayList <CardDef> chanceDeck;

	public ChanceDeck() {
		chanceDeck.add(c.chance1);
		chanceDeck.add(c.chance2);
		chanceDeck.add(c.chance3);
		chanceDeck.add(c.chance4);
		chanceDeck.add(c.chance5);
		chanceDeck.add(c.chance6);
		chanceDeck.add(c.chance7);
		chanceDeck.add(c.chance8);
		chanceDeck.add(c.chance9);
		chanceDeck.add(c.chance10);
		chanceDeck.add(c.chance11);
		chanceDeck.add(c.chance12);
		chanceDeck.add(c.chance13);
		chanceDeck.add(c.chance14);
		chanceDeck.add(c.chance15);
		chanceDeck.add(c.chance16);
		
		Collections.shuffle(chanceDeck);
	}
	
	public CardDef getCard() {
		CardDef d = chanceDeck.get(0);
		Collections.rotate(chanceDeck, -1);
		return d;
	}
}
