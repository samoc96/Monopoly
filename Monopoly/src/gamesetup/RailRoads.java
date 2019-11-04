package gamesetup;

public class RailRoads extends Properties{
	private int numOfRailRoads;
	
	public RailRoads(String name, PropType propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}

	public int getNumOfRailRoads() {
		numOfRailRoads = 0;
		for(Properties p : getOwner().getProperties())
			if (p.getPropType().equals(getPropType()))
				numOfRailRoads ++;
	
		return numOfRailRoads;
	}
	
	public int setRentPrice() {
		
		int count = 0, rentPrice = 0;
		for(Properties p : getOwner().getProperties())
			if (p.getPropType().equals(getPropType()))
				count ++;
		if (count == 1)
			rentPrice= 25;
		else if (count == 2)
			rentPrice= 50;
		else if (count == 3)
			rentPrice= 100;
		else
			rentPrice = 200;
		return rentPrice;
	}
}
