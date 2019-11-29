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
	
	public abstract int setRentPrice() ;
	
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
