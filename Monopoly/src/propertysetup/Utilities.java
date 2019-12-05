package propertysetup;

import gamesetup.Dice;
/**
 * 
 * @author SamOConnor<p>
 *Class that extends properties and constructs a Utilities property.
 */
public class Utilities extends Properties{
	
	private int rentPrice;
	
	/**
	 * Constructs a Utility property.
	 * @param name
	 * @param propType
	 * @param price
	 * @param mortgage
	 */
	public Utilities(String name, PropType propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}

	/**
	 * Set the rent price of the utility based on the number rolled on the dice and the amount of utilities owned.
	 * @param numOfUtilities
	 * @return
	 */
	public int setUtilitiesRentPrice(int numOfUtilities) {
		Dice dice = new Dice();
		dice.roll();
		if(numOfUtilities==1)
			rentPrice = 4*(dice.die1+dice.die2);
		if(numOfUtilities==2)
			rentPrice = 10*(dice.die1+dice.die2);
		return rentPrice;
	}	

	public int setRentPrice() {
		return rentPrice;
	}

	public boolean isMonopoly() {
		return false;
	}

	public int setNumOfHouses() {
		return 0;
	}

	public int setNumOfHotels() {
		return 0;
	}

	public int setHousePrice() {
		return 0;
	}
}
