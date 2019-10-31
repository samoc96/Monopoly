package gamesetup;

public class Properties {
	private int buyPrice;
	private int rentPrice;
	private int owner;
	private int index;
	private String name;
	
	public Properties(int b, int r, int i, String n){
		this.index = i;
		this.rentPrice=r;
		this.buyPrice=b;
		this.name = n;
	}
	
	public enum Color {PINK, LIGHTBLUE, RED, YELLOW, GREEN, BROWN, ORANGE, DARKBLUE}; 
	
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public int getRentPrice() {
		return rentPrice;
	}
	
	
	public int getIndex() {
		return index;
	}
	
	public void setOwner(Player player) {
		this.owner = player.getToken();	
	}
	
	public int getOwner() {
		return owner;
	}


	public String getName() {
		return name;
	}
	
}
