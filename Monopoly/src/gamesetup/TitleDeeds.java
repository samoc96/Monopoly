package gamesetup;

public class TitleDeeds extends Properties{
	private int housePrice;
	private int hotelPrice;
	
	public TitleDeeds(int b, int r, int i,String n, int house, int hotel){
		super(b,r,i,n);
		this.setHousePrice(house);
		this.setHotelPrice(hotel);
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	public int getHousePrice() {
		return housePrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}
	
	
}
