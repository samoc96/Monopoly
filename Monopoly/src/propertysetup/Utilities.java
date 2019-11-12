package propertysetup;

import gamesetup.Dice;

public class Utilities extends Properties{
	
	private int numOfUtilities;
	

	
	public Utilities(String name, PropType propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}
	
	public int getNumOfUtilities() {
		numOfUtilities = 0;
		for(Properties p : getOwner().getProperties())
			if (p.getPropType().equals(getPropType()))
				numOfUtilities ++;
	
		return numOfUtilities;
	}

	public int setRentPrice() {
		Dice dice = new Dice();
		int rentPrice = 0;
		if(numOfUtilities==1)
			rentPrice = 4*(dice.die1+dice.die2);
		if(numOfUtilities==2)
			rentPrice = 10*(dice.die1+dice.die2);
		return rentPrice;
	}	
}
