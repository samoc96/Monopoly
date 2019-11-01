package gamesetup;

import java.util.ArrayList;

import gameplay.Dice;

public class Player {
	private String name;
	private int money;
	private int token;
	private int position;
	private boolean hasJailCard;
	private int numOfDoubles;
	private ArrayList <Properties> myProperties; 
	public static final int totalSpaces = 40;
	
	public Player(String n, int t) {
		this.name = n;
		this.token = t;
		this.hasJailCard=false;
		this.position=0;
		this.myProperties= new ArrayList<Properties>();
		this.numOfDoubles=0;
		this.money=1500;
	}
	
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public int getToken() {
		return token;
	}

	public void pay(int amount){
		money-=amount;
	}

	public void receive(int amount){
		money+=amount;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int movePosition(int numOfSpaces)
	{
		int new_position = getPosition()+numOfSpaces;
		return new_position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setHasJailCard(boolean hasJailCard) {
		this.hasJailCard = hasJailCard;
	}
	
	public boolean getHasJailCard() {
		return hasJailCard;
	}
	
	public void payPlayer(Player p, int amount){
		pay(amount);
		p.receive(amount);
	}
	
	public void newProperty(Properties p){
		myProperties.add(p);
	}
	
	public boolean threeDoubles(Dice dice){
		if(dice.die1==dice.die2){
			numOfDoubles++;
		}
		if(numOfDoubles>=3){
			numOfDoubles=0;
			return true;
		}
		else {
			return false;
		} 
	}

	public ArrayList <Properties> getProperties() {
		return myProperties;
	}

}
