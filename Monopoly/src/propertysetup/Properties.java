package propertysetup;

import playersetup.Player;
/**
 * 
 * @author SamOConnor<p>
 * Class to construct a property.<p>
 * The property can be either a TitleDeeds, RailRoad or Utility.
 *
 */
public abstract class Properties {
	private String name;
	private PropType propType;
	private int price;
	private int mortgage;
	private Player owner;
	private int rentPrice;
	/**
	 * Constructs a property and initializes variables.
	 * @param name
	 * @param propType
	 * @param price
	 * @param mortgage
	 */
	public Properties(String name, PropType propType, int price, int mortgage){
		this.name = name;
		this.propType=propType;
		this.price=price;
		this.mortgage=mortgage;
		owner = null;
	}
	
	/**
	 * @return
	 * Returns the price of the property.
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @return
	 * Returns the mortgage price of the property.
	 */
	public int getMortgage() {
		return mortgage;
	}
	/**
	 * @return
	 * Class to return number of houses.
	 */
	public abstract int setNumOfHouses();
	/**
	 * @return
	 * Class to return number of hotels.
	 */	
	public abstract int setNumOfHotels();
	/**
	 * @return
	 * Sets the rent price.
	 */
	public abstract int setRentPrice() ;
	/**
	 * @return
	 * Sets the house price.
	 */
	public abstract int setHousePrice();
	/**
	 * @return
	 * Returns number of houses.
	 */
	public int getNumOfHouses() {
		return setNumOfHouses();
	}
	/**
	 * @return
	 * Returns number of hotels.
	 */
	public int getNumOfHotels() {
		return setNumOfHotels();
	}
	/**
	 * @return
	 * Returns house price.
	 */
	public int getHousePrice() {
		return setHousePrice();
	}
	/**
	 * @return
	 * Determine monopoly for each property.
	 */
	public abstract boolean isMonopoly();
	/**
	 * @return
	 * Return rent price.
	 */
	public int getRentPrice() {
		rentPrice = setRentPrice();
		return rentPrice;
	}
	/**
	 * @return
	 * Return property type.
	 */
	public PropType getPropType() {
		return propType;
	}
	/**
	 * Set the owner of the property.
	 * @param player
	 */
	public void setOwner(Player player) {
		owner = player;	
	}
	/**
	 * @return
	 * Get the owner of the property.
	 */
	public Player getOwner() {
		return owner;
	}
	/**
	 * @return
	 * Get the name of the property.
	 */
	public String getName() {
		return name;
	}
	
}
