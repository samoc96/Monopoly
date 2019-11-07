package propertysetup;


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
		
		int rentPrice = 0;
		if (numOfRailRoads == 1)
			rentPrice= 25;
		else if (numOfRailRoads == 2)
			rentPrice= 50;
		else if (numOfRailRoads == 3)
			rentPrice= 100;
		else
			rentPrice = 200;
		return rentPrice;
	}
}
