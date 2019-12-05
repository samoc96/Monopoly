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
	
	public static void action(Player player, ArrayList <Player> gamePlayers){

		DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
		HashMap<Integer, Properties> d	= definePropertiesSingleton.getHashMap();	
		int position = player.getPosition();
		CcDeck cc = new CcDeck();
		ChanceDeck c = new ChanceDeck();
		
		
		if(position == 0) {
			//print you are on Go
			DisplayMessages.locationMessage("Go");
			return;
		}
		
		if(position == 10) {
			//print you are Just Visiting
			DisplayMessages.locationMessage("Just Visiting");
			return;
		}
		
		if(position == 20) {
			//print you are on Free Parking
			DisplayMessages.locationMessage("Free Parking");
			return;
		}
		
		if(position == 30) {
			//print you are on Go To Jail
			DisplayMessages.locationMessage("Go to Jail!");
			player.setIsInJail(true);
			player.setPosition(10);
			return;
		}
		
		if(position == 2||position == 17||position ==33) {
			DisplayMessages.locationMessage("Community Chest");
			cc.getCard().action(player, gamePlayers);
			if(cc.getCard().getCardType().equals(CardType.GOJ)) {
				cc.removeCard();
			}
			return;
		
		}
		else if(position == 7||position == 22||position ==36) {
			DisplayMessages.locationMessage("Chance");
			c.getCard().action(player, gamePlayers);
			if(c.getCard().getCardType().equals(CardType.GOJ)) {
				c.removeCard();
			}
			return;
		}
		
		else if(position == 4) {
			DisplayMessages.locationMessage("Income Tax");
			DisplayMessages.taxMessage(200);
			player.pay(200);
			return;
		}
		
		else if(position == 38) {
			DisplayMessages.locationMessage("Super Tax");
			DisplayMessages.taxMessage(75);
			player.pay(75);
			return;
		}
		
		else {
			Properties property = d.get(position);
			DisplayMessages.locationMessage(property.getName());
		
			if(property.getOwner() == null) {
				//ask player if he wants to buy it
				if(UserPrompts.buyProperty(property)) {
					PropActions.buyProp(player, property);
				}
			}
			
			else if (property.getOwner()!=player) {
				DisplayMessages.rentMessage(property.getOwner().getName(), property.getRentPrice());
				PropActions.payRent(player, property);
			}
		}
	}
}

	
