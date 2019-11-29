package cardsetup;


import java.util.ArrayList;
import java.util.Collections;


public class CcDeck {
	
	private ArrayList <CardDef> CcDeck = new ArrayList <CardDef>();

	public CcDeck() {
		CommunityChestCards c = new CommunityChestCards();
		CcDeck.add(c.CC1);
		CcDeck.add(c.CC2);
		CcDeck.add(c.CC3);
		CcDeck.add(c.CC4);
		CcDeck.add(c.CC5);
		CcDeck.add(c.CC6);
		CcDeck.add(c.CC7);
		CcDeck.add(c.CC8);
		CcDeck.add(c.CC9);
		CcDeck.add(c.CC10);
		CcDeck.add(c.CC11);
		CcDeck.add(c.CC12);
		CcDeck.add(c.CC13);
		CcDeck.add(c.CC14);
		CcDeck.add(c.CC15);
		CcDeck.add(c.CC16);
		
		Collections.shuffle(CcDeck);
	}
	
	public CardDef getCard() {
		CardDef d = CcDeck.get(0);
		Collections.rotate(CcDeck, -1);
		//System.out.print(d.getMessage());
		return d;
	}
}
