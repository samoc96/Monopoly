package propertysetup;

import gamesetup.Dice;

public class Utilities extends Properties{
	
	private int rentPrice;
	

	
	public Utilities(String name, PropType propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}

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

	@Override
	public boolean isMonopoly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int setNumOfHouses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setNumOfHotels() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setHousePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
