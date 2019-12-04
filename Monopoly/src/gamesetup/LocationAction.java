package gamesetup;

import cardsetup.CardType;
import cardsetup.CcDeck;
import cardsetup.ChanceDeck;
import playersetup.Player;
import java.util.*;
import propertysetup.DefinePropertiesSingleton;
import propertysetup.Properties;
import codingtools.DisplayMessages;
import codingtools.UserPrompts;

public class LocationAction {
	
	public static void action(Player player){

		DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
		HashMap<Integer, Properties> d	= definePropertiesSingleton.getHashMap();	
		int pos = player.getPosition();
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
			player.setIsInJail(true);
			player.setPosition(10);
			return;
		}
		
		if(pos == 2||pos == 17||pos ==33) {
			DisplayMessages.locationMessage("Community Chest");
			cc.getCard().action(player);
			if(cc.getCard().getCardType().equals(CardType.GOJ)) {
				cc.removeCard();
			}
			return;
		
		}
		else if(pos == 7||pos == 22||pos ==36) {
			DisplayMessages.locationMessage("Chance");
			c.getCard().action(player);
			if(c.getCard().getCardType().equals(CardType.GOJ)) {
				c.removeCard();
			}
			return;
		}
		
		else if(pos == 4) {
			DisplayMessages.locationMessage("Income Tax");
			DisplayMessages.taxMessage(200);
			player.pay(200);
			return;
		}
		
		else if(pos == 38) {
			DisplayMessages.locationMessage("Super Tax");
			DisplayMessages.taxMessage(75);
			player.pay(75);
			return;
		}
		
		else {
			Properties property = d.get(pos);
			DisplayMessages.locationMessage(property.getName());
		
			if(property.getOwner() == null) {
				//ask player if he wants to buy it
				if(UserPrompts.buyProperty()) {
					PropActions.buyProp(player, property);
				}
			}
			
			else if (property.getOwner()!=player) {
				DisplayMessages.rentMessage(property.getOwner().getName(), property.getRentPrice());
				PropActions.payRent(player, property);
			}
			
			
			//if(property.getOwner()==p && ((TitleDeeds) property).isMonopoly()==true){
			//ask if they want to build or mortgage etc
				//if(UserPrompts.buildHouse()) {
					//PropActions.buildHH(p, property);
			//	}
			//}	
			//if(property.getOwner()==p) {
				//if(UserPrompts.mortgageProperty()) {
				//PropActions.mortgageProp(p, property);
				//}
		//	}
		}
	}
}

	
