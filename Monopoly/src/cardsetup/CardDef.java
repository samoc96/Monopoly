package cardsetup;

import java.util.ArrayList;

import playersetup.Player;
import propertysetup.DefineProperties;
import propertysetup.Properties;
import propertysetup.TitleDeeds;

import gamesetup.Dice;

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

	public CardType getCardType() {
		return cardType;
	}

	public void setOwner(Player player) {
		owner = player;	
	}
	
	public Player getOwner() {
		return owner;
	}

	public int getCardTypeVariable1() {
		return cardTypeVariable1;
	}
	
	public int getCardTypeVariable2() {
		return cardTypeVariable2;
	}
	
	public void action() {
		Player p = getOwner(); 
		DefineProperties d = new DefineProperties();
		Dice dice = new Dice();
		switch(cardType) {
			case MOVE:
				p.movePosition(cardTypeVariable1);
				break;
			
			case MOVE_TO:
				p.setPosition(cardTypeVariable1);
				break;
				
			case RECEIVE:
				p.receive(cardTypeVariable1);
				break;
				
			case PAY:
				p.pay(cardTypeVariable1);
				break;
				
			case GOJ:
				p.setHasJailCard(true);
				break;
				
			case GTJ:
				if(p.getPosition()>10) {
					p.pay(200);
				}
				p.setPosition(cardTypeVariable1);
				break;
				
			case RECEIVE_ALL:
				//TO DO 
				//NEED VALUE FOR NUMBER OF PLAYERS
				break;
				
			case PAY_ALL:
				//TO DO 
				//NEED VALUE FOR NUMBER OF PLAYERS
				break;
				
			case PAY_PER_HH:
				int amount=0;
				ArrayList<Properties> props = p.getProperties();
				
				for (int i=1; i<=p.getNumOfProps(); i++) {		
					amount+=cardTypeVariable1*((TitleDeeds) props.get(i)).getNumOfHouses();	
					amount+=cardTypeVariable2*((TitleDeeds) props.get(i)).getNumOfHotels();		
				}
				p.pay(amount);
				
				break;
				
			case MOVE_UTIL:	
				int posU = p.getPosition();
				if(posU<12||posU>28) {
					p.setPosition(12);
					posU=12;
					
				}
				else if(posU<28) {
					p.setPosition(28);
					posU=28;
				}
				if(d.getHashMap().get(posU).getOwner()!=null&&d.getHashMap().get(posU).getOwner()!=p) {
					dice.roll();
					p.pay((dice.die1+dice.die2)*10);
					getOwner().receive((dice.die1+dice.die2)*10);
				}
				
				break;
				
			case MOVE_RR:
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
				else if(posR<35) {
					p.setPosition(35);
					posR=35;
				}
				if(d.getHashMap().get(posR).getOwner()!=null&&d.getHashMap().get(posR).getOwner()!=p) {
					
					p.pay(d.getHashMap().get(posR).getRentPrice()*2);
					getOwner().receive(d.getHashMap().get(posR).getRentPrice()*2);
				}
				break;		
		}
	}
}
