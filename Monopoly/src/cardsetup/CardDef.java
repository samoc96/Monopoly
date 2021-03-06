package cardsetup;

import java.util.ArrayList;

import codingtools.DisplayMessages;
import playersetup.Player;
import propertysetup.Properties;

/**
 * 
 * @author SamOConnor<p>
 * Class to setup the community chest and chance cards.
 *
 */
public class CardDef {
	private String message;
	private CardType cardType;
	private int cardTypeVariable1;
	private int cardTypeVariable2;
	
	/**
	 * Each card has a message, a CardType, and 2 variables. These variables are used to perform various actions depending on the CardType. 
	 * @param message
	 * @param cardType
	 * @param cardTypeVariable1
	 * @param cardTypeVariable2
	 */
	public CardDef(String message, CardType cardType, int cardTypeVariable1, int cardTypeVariable2) {
		this.message=message;
		this.cardType=cardType;
		this.cardTypeVariable1=cardTypeVariable1;
		this.cardTypeVariable2=cardTypeVariable2;
	}
	
	/**
	 * @return
	 * The cards message.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return
	 * The cards CardType.
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * Takes in a player and an arrayList of player.<p>
	 * Depending on the CardType various actions may be performed on the player.<p>
	 * The cardTypeVariable1 is used for actions such as paying/receiving money and moving/setting position of the player.<p>
	 * The cardTypeVariable2 is used for the price of repairing damages for hotels.<p>
	 * The arrayList of players is needed for when a player must either pay/receieve all.
	 * @param player
	 * @param gamePlayers
	 */
	public void action(Player player, ArrayList <Player> gamePlayers) {
		switch(cardType) {
			case MOVE:
				DisplayMessages.cardMessage(message);
				player.movePosition(cardTypeVariable1);
				DisplayMessages.playersPosition(player);
				break;
			
			case MOVE_TO:
				DisplayMessages.cardMessage(message);
				player.setPosition(cardTypeVariable1);
				break;
				
			case RECEIVE:
				DisplayMessages.cardMessage(message);
				player.receive(cardTypeVariable1);
				break;
				
			case PAY:
				DisplayMessages.cardMessage(message);
				player.pay(cardTypeVariable1);
				break;
				
			case GOJ:
				DisplayMessages.cardMessage(message);
				player.setHasJailCard(true);
				break;
				
			case GTJ:
				DisplayMessages.cardMessage(message);
				player.setPosition(cardTypeVariable1);
				player.setIsInJail(true);
				break;
				
			case RECEIVE_ALL:
				DisplayMessages.cardMessage(message);
				CardActions.receiveAll(gamePlayers, player, cardTypeVariable1);
				break;
				
			case PAY_ALL:
				DisplayMessages.cardMessage(message);
				CardActions.payAll(gamePlayers, player, cardTypeVariable1);
				break;
				
			case PAY_PER_HH:
				DisplayMessages.cardMessage(message);
				int amount=0;
				ArrayList<Properties> props = player.getProperties();
				
				for (int i=1; i<=player.getNumOfProps(); i++) {		
					amount+=cardTypeVariable1*props.get(i).getNumOfHouses();	
					amount+=cardTypeVariable2*props.get(i).getNumOfHotels();		
				}
				player.pay(amount);
				
				break;
				
			case MOVE_UTIL:
				
				DisplayMessages.cardMessage(message);
				CardActions.moveUtility(player,gamePlayers);
				break;
				
			case MOVE_RR:
				
				DisplayMessages.cardMessage(message);
				CardActions.moveToRailRoad(player,gamePlayers);
				break;
		}
	}
}
