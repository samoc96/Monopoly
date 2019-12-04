package propertysetup;

import playersetup.Player;

public abstract class Properties {
	private String name;
	private PropType propType;
	private int price;
	private int mortgage;
	private Player owner;
	private int rentPrice;
	

	
	public Properties(String name, PropType propType, int price, int mortgage){
		this.name = name;
		this.propType=propType;
		this.price=price;
		this.mortgage=mortgage;
		owner = null;
	}
	
	 
	public int getPrice() {
		return price;
	}
	
	public int getMortgage() {
		return mortgage;
	}
	
	public abstract int setNumOfHouses();
	
	public abstract int setNumOfHotels();
	
	public abstract int setRentPrice() ;
	
	public abstract int setHousePrice();
	
	public int getNumOfHouses() {
		return setNumOfHouses();
	}
	
	public int getNumOfHotels() {
		return setNumOfHotels();
	}
	
	public int getHousePrice() {
		return setHousePrice();
	}
	
	public abstract boolean isMonopoly();
	
	public int getRentPrice() {
		rentPrice = setRentPrice();
		return rentPrice;
	}

	public PropType getPropType() {
		return propType;
	}
	
	public void setOwner(Player player) {
		owner = player;	
	}
	
	public Player getOwner() {
		return owner;
	}

	public String getName() {
		return name;
	}
	
}
