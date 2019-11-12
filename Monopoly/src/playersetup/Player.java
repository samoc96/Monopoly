package playersetup;

import java.util.ArrayList;

import propertysetup.Properties;

import gamesetup.Dice;

public class Player {
	private String name;
	private int money;
	private int token;
	private int position;
	private boolean hasJailCard;
	private int numOfDoubles;
	private ArrayList <Properties> myProperties; 
	private int numOfProps;
	private boolean isInJail;
	private boolean isBankrupt;
	
	public Player(String n, int t) {
		this.name = n;
		this.token = t;
		hasJailCard=false;
		position=0;
		myProperties= new ArrayList<Properties>();
		numOfDoubles=0;
		money=1500;
		numOfProps=0;
		isInJail=false;
		isBankrupt=false;
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
	
	public void setHasJailCard(boolean b) {
		hasJailCard = b;
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
		numOfProps++;
	}
	
	public void threeDoubles(Dice dice){
		if(dice.die1==dice.die2){
			numOfDoubles++;
		}
		if(numOfDoubles==3){
			isInJail=true;
			position=10;
			numOfDoubles=0;
		}
	}

	public ArrayList <Properties> getProperties() {
		return myProperties;
	}

	public int getNumOfProps() {
		return numOfProps;
	}

	public boolean getIsInJail() {
		return isInJail;
	}

	public void setBankrupt(boolean isBankrupt) {
		if(money<0){
			
		}
	}

	public boolean isBankrupt() {
		return isBankrupt;
	}

}
