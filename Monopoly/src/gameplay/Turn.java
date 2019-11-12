package gameplay;

import gamesetup.Dice;
import gamesetup.LocationAction;
import playersetup.Player;

public class Turn {
	private Player p;
	
	public Turn(Player p){
		this.p = p;
	}
	
	public void playerRoll(){
		Dice d = new Dice();
		LocationAction la = new LocationAction(p);
		d.roll();
		p.movePosition(d.die1+d.die2);
		la.action();
	}	
	
	
	
}
