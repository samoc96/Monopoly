package gamesetup;

public abstract class Properties {
	private String name;
	private String propType;
	private int price;
	private int mortgage;
	private Player owner;

	
	public Properties(String name, String propType, int price, int mortgage){
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
	
	public abstract int getRent() ;
	
	public String getPropType() {
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
