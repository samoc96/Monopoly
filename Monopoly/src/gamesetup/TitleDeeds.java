package gamesetup;

public class TitleDeeds extends Properties{
 
	private int housePrice;
	private int rentPrice;
	private int rentPrice1;
	private int rentPrice2;
	private int rentPrice3;
	private int rentPrice4;
	private int rentPriceH;
	private int numOfHouses;
	private int numForMono;
	
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
		this.numForMono=numForMono;
	}

	public int getNumOfHouses() {
		return numOfHouses;
	}
	
	public int getHousePrice() {
		return housePrice;
	}

	public void addHouse()
	{
		if(numOfHouses <5)
		{
			if (numOfHouses == 0)
			rentPrice = rentPrice1;
			if (numOfHouses == 1)
			rentPrice = rentPrice2;
			if (numOfHouses == 2)
			rentPrice = rentPrice3;
			if (numOfHouses == 3)
				rentPrice = rentPrice4;
			if (numOfHouses == 4)
			rentPrice = rentPriceH;
			numOfHouses++;
			
			getOwner().pay(housePrice);
		}
	}

	public int setRentPrice() {
		return rentPrice;
	}

	public boolean isMonopoly()
	{
		if(!(getOwner()==null))
		{
			int count = 0;
			for(Properties p : getOwner().getProperties())
				if (p.getPropType().equals(getPropType()))
					count ++;
			return (count == numForMono);
		}
		else return false;
	}
	
}
