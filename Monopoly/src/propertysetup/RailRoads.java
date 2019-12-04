package propertysetup;


public class RailRoads extends Properties{

	public RailRoads(String name, PropType propType, int price, int mortgage){
		super(name,propType,price,mortgage);
	}
	
	private int rentPrice;
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

	
	public int setRentPrice() {
		return rentPrice;
	}


	@Override
	public int getNumOfHouses() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getNumOfHotels() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getHousePrice() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isMonopoly() {
		// TODO Auto-generated method stub
		return false;
	}
}
