package propertysetup;
/**
 * 
 * @author SamOConnor<p>
 *Class that extends properties and constructs a Titledeeds property.
 */
public class TitleDeeds extends Properties{
 
	private int housePrice;
	private int rentPrice;
	private int rentPrice1;
	private int rentPrice2;
	private int rentPrice3;
	private int rentPrice4;
	private int rentPriceH;
	private int numOfHouses;
	private int numOfHotels;
	private int numForMono;
	
	/**
	 * Construct a Titledeeds property.
	 * @param name
	 * @param propType
	 * @param price
	 * @param mortgage
	 * @param housePrice
	 * @param rentPrice
	 * @param rentPrice1
	 * @param rentPrice2
	 * @param rentPrice3
	 * @param rentPrice4
	 * @param rentPriceH
	 * @param numForMono
	 */
	public TitleDeeds(String name, PropType propType, int price, int mortgage, 
			int housePrice,int rentPrice,int rentPrice1,int rentPrice2,int rentPrice3,int rentPrice4,int rentPriceH,int numForMono){
		super(name,propType,price,mortgage);
		this.housePrice=housePrice;
		this.rentPrice=rentPrice;
		this.rentPrice1=rentPrice1;
		this.rentPrice2=rentPrice2;
		this.rentPrice3=rentPrice3;
		this.rentPrice4=rentPrice4;
		numOfHouses=0;
		numOfHotels=0;
		this.numForMono=numForMono;
	}

	/**
	 * Set the house price.
	 */
	public int setHousePrice() {
		return housePrice;
	}

	/**
	 * Build a house on the property if monopoly is achieved.<p>
	 * Can only build one house at a time.<p>
	 * After 3 houses have been built you can then build a hotel.
	 */
	public void addHouse() {
		if(numOfHouses <5 && numOfHotels==0){
			if (numOfHouses == 0) {
				rentPrice = rentPrice1;
				numOfHouses++;
				}
			
			else if (numOfHouses == 1) {
				rentPrice = rentPrice2;
				numOfHouses++;					
				}
			
			else if (numOfHouses == 2) {
				rentPrice = rentPrice3;
				numOfHouses++;				
				}
			
			else if (numOfHouses == 3) {
				rentPrice = rentPrice4;
				numOfHouses++;			
				}
			if (numOfHouses == 4) {
				rentPrice = rentPriceH;
				numOfHouses=0;
				numOfHotels=1;		
				}
			getOwner().pay(housePrice);
			}
		}
	/**
	 * Set number of houses.
	 */
	public int setNumOfHouses() {
		return numOfHouses;
	}
	/**
	 * Set number of hotels.
	 */
	public int setNumOfHotels() {
		return numOfHotels;
	}
	/**
	 * Set rent price based on the number of houses/hotels built.
	 */
	public int setRentPrice() {
		return rentPrice;
	}
	/**
	 * Determine if the owner has monopoly by comparing this property with the rest of the owners properties.<p>
	 * Returns true when an owner has every Titledeeds for one color.
	 */
	public boolean isMonopoly()
	{
		if(!(getOwner()==null))
		{
			int count = 0;
			for(int i = 0; i<getOwner().getNumOfProps(); i++) {
				if (getOwner().getProperties().get(i).getPropType().equals(getPropType())){
					count ++;					
				}
			}				
			return (count == numForMono);
		}
		else return false;
	}
}
