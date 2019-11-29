package gameplay;

import codingtools.UserPrompts;
import gamesetup.Dice;
import gamesetup.LocationAction;
import playersetup.Player;

public class Turn {
	private Player player;
	
	public Turn(Player player){
		this.player = player;
	}
		
	public void playerRoll(){
		Dice d = new Dice();
		UserPrompts.playersBank(player);
		if(player.getNumOfProps()!=0) {
			UserPrompts.playersProperties(player);
		}
		UserPrompts.playersTurn(player);
		d.roll();
		player.movePosition(d.die1+d.die2);
		UserPrompts.playersPosition(player);
		LocationAction la = new LocationAction(player);
		la.action();
		System.out.print("\n");
		UserPrompts.playersBank(player);
		if(player.getMoney()<0) {
			player.setBankrupt(true);
		}
		if(player.getNumOfProps()!=0) {
			UserPrompts.playersProperties(player);
		}
	}		
}
