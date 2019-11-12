package gamesetup;

import cardsetup.CardDef;
import cardsetup.CcDeck;
import cardsetup.ChanceCards;
import cardsetup.ChanceDeck;
import cardsetup.CommunityChestCards;
import playersetup.Player;
import java.util.*;
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
		deck = d.getHashMap();
		ChanceDeck c = new ChanceDeck();
		switch (pos){
		
		case 1:
			
			break;
			
		case 2:
		case 17:
		case 33:
			cc.getCard().action(p);
			break;
		
		}
	}
}
