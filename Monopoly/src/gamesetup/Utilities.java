package gamesetup;

import gameplay.Dice;

public class Utilities extends Properties{
	
	private int noOfUtilities;
	private int rentPrice;

	
	public Utilities(String name, String propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}
	
	public int getNoOfUtilities() {
		noOfUtilities = 0;
		for(Properties p : getOwner().getProperties())
			if (p.getPropType().equals(getPropType()))
				noOfUtilities ++;
	
		return noOfUtilities;
	}

	public int getRent() {
		Dice dice = new Dice();
		int count = 0;
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
