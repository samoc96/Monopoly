package cardsetup;

import java.util.ArrayList;
import java.util.HashMap;

import codingtools.UserPrompts;
import playersetup.DefinePlayer;
import playersetup.Player;
import propertysetup.DefineProperties;
import propertysetup.Properties;
import propertysetup.TitleDeeds;

import gamesetup.Dice;
import gamesetup.LocationAction;
import gamesetup.PropActions;

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

	public void action(Player p) {
		HashMap<Integer, Properties> d = DefineProperties.getHashMap();
		Dice dice = new Dice();
		ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
		LocationAction la = new LocationAction(p);
		
		
		switch(cardType) {
			case MOVE:
				UserPrompts.cardMessage(message);
				p.movePosition(cardTypeVariable1);
				UserPrompts.playersPosition(p);
				break;
			
			case MOVE_TO:
				UserPrompts.cardMessage(message);
				p.setPosition(cardTypeVariable1);
				break;
				
			case RECEIVE:
				UserPrompts.cardMessage(message);
				p.receive(cardTypeVariable1);
				break;
				
			case PAY:
				UserPrompts.cardMessage(message);
				p.pay(cardTypeVariable1);
				break;
				
			case GOJ:
				UserPrompts.cardMessage(message);
				p.setHasJailCard(true);
				this.owner = p;
				break;
				
			case GTJ:
				UserPrompts.cardMessage(message);
				p.setPosition(cardTypeVariable1);
				p.setIsInJail(true);
				break;
				
			case RECEIVE_ALL:
				UserPrompts.cardMessage(message);
				for(int i = 0; i<gamePlayers.size(); i++) {
					if(gamePlayers.get(i)!=p) {
						gamePlayers.get(i).payPlayer(p, cardTypeVariable1);
					}
				}

				break;
				
			case PAY_ALL:
				UserPrompts.cardMessage(message);
				for(int i = 0; i<gamePlayers.size(); i++) {
					if(gamePlayers.get(i)!=p) {
						p.payPlayer(gamePlayers.get(i), cardTypeVariable1);
					}
				}
				break;
				
			case PAY_PER_HH:
				UserPrompts.cardMessage(message);
				int amount=0;
				ArrayList<Properties> props = p.getProperties();
				
				for (int i=1; i<=p.getNumOfProps(); i++) {		
					amount+=cardTypeVariable1*((TitleDeeds) props.get(i)).getNumOfHouses();	
					amount+=cardTypeVariable2*((TitleDeeds) props.get(i)).getNumOfHotels();		
				}
				p.pay(amount);
				
				break;
				
			case MOVE_UTIL:
				
				UserPrompts.cardMessage(message);
				int posU = p.getPosition();
				
				if(posU<12||posU>28) {
					p.setPosition(12);
					posU=12;					
				}
				else {
					p.setPosition(28);
					posU=28;

				}
				UserPrompts.locationMessage(d.get(posU).getName());
//				System.out.print(d.get(posU).getName()+"\n");
	//			System.out.print(d.get(posU).getOwner().getName());
				if(d.get(posU).getOwner()!=null && d.get(posU).getOwner()!=p) {
					System.out.print("This utility is owned! Pay the owner 10 times the amount thrown on your next roll!\n");
					dice.roll();
					UserPrompts.rentMessage(d.get(posU).getOwner().getName(), (dice.die1+dice.die2)*10);
					p.payPlayer(d.get(posU).getOwner(), (dice.die1+dice.die2)*10);
				}
				else {
					la.action();
				}
				break;
				
			case MOVE_RR:
				
				UserPrompts.cardMessage(message);
				int posR = p.getPosition();
				
				if(posR<5) {
					p.setPosition(5);
					posR=5;
				}
				else if(posR<15) {
					p.setPosition(15);
					posR=15;
				}
				else if(posR<25) {
					p.setPosition(25);
					posR=25;
				}
				else {
					p.setPosition(35);
					posR=35;
				}
				UserPrompts.locationMessage(d.get(posR).getName());
				if(d.get(posR).getOwner()!=null && d.get(posR).getOwner()!=p) {
					System.out.print("This railroad is owned! Pay the owner twice the current rent price!\n");
					PropActions.payRent(p, d.get(posR));
					PropActions.payRent(p, d.get(posR));
					UserPrompts.rentMessage(d.get(posR).getOwner().getName(), d.get(posR).getRentPrice()*2);
				}
				else {
					la.action();	
				}
				
				break;		
		}
	}
}
