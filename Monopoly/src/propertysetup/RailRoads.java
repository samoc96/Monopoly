package propertysetup;

/**
 * 
 * @author SamOConnor<p>
 *Class that extends properties and constructs a RailRoads property.
 */
public class RailRoads extends Properties{

	/**
	 * Constructs a railroad property.
	 * @param name
	 * @param propType
	 * @param price
	 * @param mortgage
	 */
	public RailRoads(String name, PropType propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}
	
	private int rentPrice;
	/**
	 * Determine the rent price of the railroad based on the number of railroads the owner owns.
	 * @param numOfRailRoads
	 */
	public void setRailRoadRentPrice(int numOfRailRoads) {
		if (numOfRailRoads == 1) {
			rentPrice = 25;	
		}
		else if (numOfRailRoads == 2) {
			rentPrice= 50;	
		}
		else if (numOfRailRoads == 3) {
			rentPrice= 100;	
		}
		else {
			rentPrice = 200;	
		}
	}

	/**
	 * Set the rent price to the rent price determined from the method above.
	 */
	public int setRentPrice() {
		return rentPrice;
	}

	public int setNumOfHouses() {
		return 0;
	}

	public boolean isMonopoly() {
		return false;
	}

	public int setNumOfHotels() {
		return 0;
	}

	public int setHousePrice() {
		return 0;
	}
}
