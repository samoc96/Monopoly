package playersetup;

import java.util.ArrayList;

import codingtools.DisplayMessages;
import propertysetup.Properties;

public class Player {
	private String name;
	private int money;
	private int position;
	private boolean hasJailCard;
	private int numOfJailDoubles;
	private ArrayList <Properties> myProperties; 
	private int numOfProps;
	private boolean isInJail;
	private boolean isBankrupt;
	private int numOfRR;
	private int numOfU;
	
	public Player(String n) {
		this.name = n;
		hasJailCard=false;
		position=0;
		myProperties= new ArrayList<Properties>();
		numOfJailDoubles=0;
		money=1500;
		numOfProps=0;
		numOfRR = 0;
		numOfU = 0;
		isInJail=false;
		isBankrupt=false;
	}
	
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void pay(int amount){
		money-=amount;
	}

	public void receive(double d){
		money+=d;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int movePosition(int numOfSpaces)
	{
		if(numOfSpaces<0 && -position>numOfSpaces) {
			position = 40+position+numOfSpaces;
		}
		else if(position+numOfSpaces>=40) {
			DisplayMessages.pastGo();
			money += 200;
			position = position+numOfSpaces-40;
		}
		else {
		position = position+numOfSpaces;
		}
		return position;
	}
	
	public void setPosition(int position) {
		if(this.position > position && isInJail == false) {
			DisplayMessages.pastGo();
			money += 200;
			this.position = position;
		}
		else {
			this.position = position;	
		}	
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
	
	public void newProperty(Properties properties){
		myProperties.add(properties);
		numOfProps++;
	}
	
	public void removeProperty(Properties properties){
		for(int i=0; i<numOfProps; i++) {
			if(myProperties.get(i).equals(properties)) {
				myProperties.remove(i);
				numOfProps--;
				break;
			}	
		}	
	}
	
	public int getNumberOfJailDoubles() {
		return numOfJailDoubles;
	}
	
	public void setNumberOfJailDoubles(int numOfJailDoubles) {
		this.numOfJailDoubles = numOfJailDoubles;
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

	public void setIsInJail(boolean b) {
		isInJail = b;
	}
	
	public void setBankrupt(boolean isBankrupt) {
		this.isBankrupt = isBankrupt;
	}

	public boolean isBankrupt() {
		return isBankrupt;
	}

	public int getNumOfRR() {
		return numOfRR;
	}

	public void setNumOfRR(int numOfRR) {
		this.numOfRR = numOfRR;
	}

	public int getNumOfU() {
		return numOfU;
	}

	public void setNumOfU(int numOfU) {
		this.numOfU = numOfU;
	}

}
