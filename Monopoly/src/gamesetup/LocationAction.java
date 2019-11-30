package gamesetup;

import cardsetup.CcDeck;
import cardsetup.ChanceDeck;
import playersetup.Player;
import java.util.*;
import propertysetup.DefineProperties;
import propertysetup.Properties;
import propertysetup.TitleDeeds;
import codingtools.DisplayMessages;
import codingtools.UserPrompts;

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
			DisplayMessages.locationMessage("Go");
			return;
		}
		
		if(pos == 10) {
			//print you are Just Visiting
			DisplayMessages.locationMessage("Just Visiting");
			return;
		}
		
		if(pos == 20) {
			//print you are on Free Parking
			DisplayMessages.locationMessage("Free Parking");
			return;
		}
		
		if(pos == 30) {
			//print you are on Go To Jail
			DisplayMessages.locationMessage("Go to Jail!");
			p.setPosition(10);
			p.setIsInJail(true);
			return;
		}
		
		if(pos == 2||pos == 17||pos ==33) {
			DisplayMessages.locationMessage("Community Chest");
			cc.getCard().action(p);
			return;
		
		}
		else if(pos == 7||pos == 22||pos ==36) {
			DisplayMessages.locationMessage("Chance");
			c.getCard().action(p);
			return;
		}
		
		else if(pos == 4) {
			DisplayMessages.locationMessage("Income Tax");
			DisplayMessages.taxMessage(200);
			p.pay(200);
			return;
		}
		
		else if(pos == 38) {
			DisplayMessages.locationMessage("Super Tax");
			DisplayMessages.taxMessage(75);
			p.pay(75);
			return;
		}
		
		else {
			Properties property = d.get(pos);
			DisplayMessages.locationMessage(property.getName());
		
			if(property.getOwner() == null) {
				//ask player if he wants to buy it
				if(UserPrompts.buyProperty()) {
					PropActions.buyProp(p, property);
				}
			}
			
			else if (property.getOwner()!=p) {
				DisplayMessages.rentMessage(property.getOwner().getName(), property.getRentPrice());
				PropActions.payRent(p, property);
			}
			
			
			if(property.getOwner()==p && ((TitleDeeds) property).isMonopoly()==true){
			//ask if they want to build or mortgage etc
				if(UserPrompts.buildHouse()) {
					PropActions.buildHH(p, property);
				}
			}	
			if(property.getOwner()==p) {
				if(UserPrompts.mortgageProperty()) {
				PropActions.mortgageProp(p, property);
				}
			}
		}
	}
}

	
