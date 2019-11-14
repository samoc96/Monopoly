package gamesetup;

import cardsetup.CcDeck;
import cardsetup.ChanceDeck;
import playersetup.Player;
import java.util.*;
import propertysetup.DefineProperties;
import propertysetup.Properties;

public class LocationAction {
	private Player p;
	public LocationAction(Player p){
		this.p=p;
	}
	
	public void action(){
		
		HashMap<Integer, Properties> d = DefineProperties.getHashMap();
		int pos = p.getPosition();
		CcDeck cc = new CcDeck();
		ChanceDeck c = new ChanceDeck();
		
		if(pos == 0) {
			//print you are on Go
		}
		
		if(pos == 10) {
			//print you are Just Visiting
		}
		
		if(pos == 20) {
			//print you are on Free Parking
		}
		
		if(pos == 30) {
			//print you are on Go To Jail
			p.setPosition(10);
			p.setIsInJail(true);
		}
		
		if(pos == 2||pos == 17||pos ==33) {
			cc.getCard().action(p);
		
		}
		else if(pos == 7||pos == 22||pos ==36) {
			c.getCard().action(p);
		}
		
		else if(pos == 4) {
			p.pay(200);
		}
		
		else if(pos == 38) {
			p.pay(75);
		}
		
		else {
			Properties property = d.get(pos);
			PropActions propActions = new PropActions(p, property);
		
			if(property.getOwner()==null) {
				//ask player if he wants to buy it
				//if yes
				propActions.buyProp();
				
				//if no
				//break;
			}
			
			else if (property.getOwner()!=p) {
				propActions.payRent();
			}
			
			
			if(property.getOwner()==p){
				//ask if they want to build or mortgage etc
				propActions.buildHH();
				propActions.mortgageProp();
			}
		}
	}
}

	
