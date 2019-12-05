package gamesetup;

import cardsetup.CardType;
import cardsetup.ChanceDeck;
import cardsetup.CommunityChestDeck;
import playersetup.Player;
import java.util.*;
import propertysetup.DefinePropertiesSingleton;
import propertysetup.Properties;
import codingtools.DisplayMessages;
import codingtools.UserPrompts;

/**
 * 
 * @author SamOConnor<p>
 * Class to determine the appropriate action for a given player's position on the board.
 *
 */
public class LocationAction {
	/**
	 * Takes in a given player and an arrayList of players.<p>
	 * Performs various actions for the given player's position.<p>
	 * Actions can be simple such as displaying where the player is on the board.<p>
	 * To actions where players must draw a chance/community chest card.<p>
	 * There are also actions for paying taxes.<p>
	 * Finally, there are actions for when a player lands on a property and whether he can buy it if unowned, or pay rent otherwise.
	 * @param player
	 * @param gamePlayers
	 */
	public static void action(Player player, ArrayList <Player> gamePlayers){

		DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
		HashMap<Integer, Properties> d	= definePropertiesSingleton.getHashMap();	
		int position = player.getPosition();
		CommunityChestDeck cc = new CommunityChestDeck();
		ChanceDeck c = new ChanceDeck();
		
		
		if(position == 0) {
			DisplayMessages.locationMessage("Go");
			return;
		}
		
		if(position == 10) {
			DisplayMessages.locationMessage("Just Visiting");
			return;
		}
		
		if(position == 20) {
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

	
