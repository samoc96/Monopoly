package gameplay;

public class Player {
	private String name;
	private int money;
	private String token;
	private int position;

	public Player(String n, String t) {
		this.name = n;
		this.token = t;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getToken() {
		return token;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
