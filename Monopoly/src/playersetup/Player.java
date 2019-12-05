package playersetup;

import java.util.ArrayList;

import codingtools.DisplayMessages;
import propertysetup.Properties;

/**
 * 
 * @author SamOConnor<p>
 * Class to construct a player and perform various methods.<p>
 * 
 */
public class Player {
	private String name;
	private double money;
	private int position;
	private boolean hasJailCard;
	private int numOfJailDoubles;
	private ArrayList <Properties> myProperties; 
	private int numOfProps;
	private boolean isInJail;
	private boolean isBankrupt;
	private int numOfRR;
	private int numOfU;
	/**
	 * Constructs a player assigning the inputed string as the players name.<p>
	 * Initializes all the players variables.
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
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
	/**
	 * @return name
	 * Returns the String containing the player's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 * the double value of the player's money.
	 */
	public double getMoney() {
		return money;
	}

	
	/**
	 * Subtracts the given double from the player's money.
	 * @param amount
	 */
	public void pay(double amount){
		money-=amount;
	}
	
	/**
	 * Adds the given double amount to the player's money.   
	 * @param d
	 */

	public void receive(double d){
		money+=d;
	}
	
	/**
	 * @return
	 * Returns the position of the player
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * @param numOfSpaces
	 * @return
	 * Moves the player by a given number of spaces.<p>
	 * If statements ensure that player position resets to 0 once they pass position 39. <p>
	 * If statements to ensure player receives money when they pass go.
	 */
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
	
	/**
	 * Sets the player's position to the given input. <p>
	 * If statement to ensure when a player is sent to jail they don't receive $200.
	 * @param position
	 */
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
	
	/**
	 * Set whether or not the player has a GOJ card.
	 * @param b
	 */
	public void setHasJailCard(boolean b) {
		hasJailCard = b;
	}
	
	/**
	 * @return
	 * Determine if the player has GOJ card.
	 */
	public boolean getHasJailCard() {
		return hasJailCard;
	}
	
	/**
	 * Pay a given player by the given amount.<p>
	 * Player pays the amount.<p>
	 * Other player receives the amount.
	 * @param p
	 * @param amount
	 */
	public void payPlayer(Player player, double amount){
		pay(amount);
		player.receive(amount);
	}
	
	/**
	 * Adds a given property to the player's properties array list.<p>
	 * Increments the number of properties.
	 * @param properties
	 */
	public void newProperty(Properties properties){
		myProperties.add(properties);
		numOfProps++;
	}
	
	/**
	 * Removes a given property from the player's properties array list.<p>
	 * Iterates through the player's properties array list to find which property to remove.
	 * Decreases the number of properties.
	 * @param properties
	 */
	public void removeProperty(Properties properties){
		for(int i=0; i<numOfProps; i++) {
			if(myProperties.get(i).equals(properties)) {
				myProperties.remove(i);
				numOfProps--;
				break;
			}	
		}	
	}
	
	/**
	 * @return
	 * Returns the number of doubles a player has rolled in one turn.
	 */
	public int getNumberOfJailDoubles() {
		return numOfJailDoubles;
	}
	
	/**
	 * Set the number of doubles a player has rolled in one turn.
	 * @param numOfJailDoubles
	 */
	public void setNumberOfJailDoubles(int numOfJailDoubles) {
		this.numOfJailDoubles = numOfJailDoubles;
	}

	/**
	 * @return
	 * Returns the player's property array list.
	 */
	public ArrayList <Properties> getProperties() {
		return myProperties;
	}

	/**
	 * @return
	 * Returns the number of properties a player has.
	 */
	public int getNumOfProps() {
		return numOfProps;
	}

	/**
	 * @return
	 * Determines if the player is in jail.
	 */
	public boolean getIsInJail() {
		return isInJail;
	}

	/**
	 * Set whether a player is in jail.
	 * @param b
	 */
	public void setIsInJail(boolean b) {
		isInJail = b;
	}
	
	/**
	 * Set whether a player is bankrupt.
	 * @param isBankrupt
	 */
	public void setBankrupt(boolean isBankrupt) {
		this.isBankrupt = isBankrupt;
	}

	/**
	 * @return
	 * Determine if a player is bankrupt.
	 */
	public boolean isBankrupt() {
		return isBankrupt;
	}

	/**
	 * @return
	 * Return number of Railroads a player owns.
	 */
	public int getNumOfRR() {
		return numOfRR;
	}

	/**
	 * Set number of Railroads a player owns.
	 * @param numOfRR
	 */
	public void setNumOfRR(int numOfRR) {
		this.numOfRR = numOfRR;
	}
	
	/**
	 * @return
	 * Return number of Utilities a player owns.
	 */
	public int getNumOfU() {
		return numOfU;
	}
	
	/**
	 * Set number of Utilities a player owns.
	 * @param numOfRR
	 */
	public void setNumOfU(int numOfU) {
		this.numOfU = numOfU;
	}

}
