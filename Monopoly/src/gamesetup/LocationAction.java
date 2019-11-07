package gamesetup;

import cardsetup.CardDef;
import cardsetup.CcDeck;
import cardsetup.ChanceCards;
import cardsetup.ChanceDeck;
import cardsetup.CommunityChestCards;
import playersetup.Player;
import propertysetup.DefineProperties;

public class LocationAction {
	private Player p;
	DefineProperties d = new DefineProperties();
	public LocationAction(Player p){
		this.p=p;
	}
	
	public void action(){
		
		int pos = p.getPosition();
		CcDeck cc = new CcDeck();
		ChanceDeck c = new ChanceDeck();
		switch (pos){
		
		case 1:
			//d.get
			break;
			
		case 2:
		case 17:
		case 33:
			cc.getCard().setOwner(p);
			cc.getCard().action();
			break;
		
		}
	}
}
