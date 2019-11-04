package gamesetup;

import gameplay.Dice;

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
		int count = 0, rentPrice = 0;
		for(Properties p : getOwner().getProperties())
			if (p.getPropType().equals(getPropType()))
				count ++;
		if(count==1)
			rentPrice = 4*(dice.die1+dice.die2);
		if(count==2)
			rentPrice = 10*(dice.die1+dice.die2);
		return rentPrice;
	}	
}
