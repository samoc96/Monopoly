package cardsetup;

import java.util.ArrayList;

import codingtools.DisplayMessages;
import playersetup.DefinePlayer;
import playersetup.Player;
import propertysetup.Properties;
import propertysetup.TitleDeeds;

public class CardDef {
	private String message;
	private CardType cardType;
	private Player owner;
	private int cardTypeVariable1;
	private int cardTypeVariable2;
	
	public CardDef(String message, CardType cardType, int cardTypeVariable1, int cardTypeVariable2) {
		this.message=message;
		this.cardType=cardType;
		this.cardTypeVariable1=cardTypeVariable1;
		this.cardTypeVariable2=cardTypeVariable2;
		owner = null;
	}
	
	public String getMessage() {
		return message;
	}
	
	public CardType getCardType() {
		return cardType;
	}

	public void setOwner(Player player) {
		owner = player;	
	}
	
	public Player getOwner() {
		return owner;
	}

	public void action(Player player) {
		ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
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
				this.owner = player;
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
					amount+=cardTypeVariable1*((TitleDeeds) props.get(i)).getNumOfHouses();	
					amount+=cardTypeVariable2*((TitleDeeds) props.get(i)).getNumOfHotels();		
				}
				player.pay(amount);
				
				break;
				
			case MOVE_UTIL:
				
				DisplayMessages.cardMessage(message);
				CardActions.moveUtility(player);
				break;
				
			case MOVE_RR:
				
				DisplayMessages.cardMessage(message);
				CardActions.moveToRailRoad(player);
				break;
		}
	}
}
