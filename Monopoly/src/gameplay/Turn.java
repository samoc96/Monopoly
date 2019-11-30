package gameplay;

import codingtools.DisplayMessages;
import codingtools.UserPrompts;
import gamesetup.Dice;
import gamesetup.LocationAction;
import gamesetup.PropActions;
import playersetup.Player;
import propertysetup.TitleDeeds;

public class Turn {
		
	public static void playerTurn(Player player,Dice dice){
		
		DisplayMessages.playersTurn(player);
		DisplayMessages.playersBank(player);
		if(player.getNumOfProps()!=0) {
			DisplayMessages.playersProperties(player);
			DisplayMessages.displayBreak();
			if(UserPrompts.propertyAction()) {
				 
				for(int i = 0; i < player.getNumOfProps(); i++) {
					System.out.print("For the following property:\n"+player.getProperties().get(i).getName()+"\n");
					if(((TitleDeeds) player.getProperties().get(i)).isMonopoly()) {
						if(UserPrompts.buildHouse()) {
							((TitleDeeds) player.getProperties().get(i)).addHouse();
							DisplayMessages.houseBought();
							DisplayMessages.playersBank(player);
						}
					}
					if(UserPrompts.mortgageProperty()) {
						PropActions.mortgageProp(player, player.getProperties().get(i));
						DisplayMessages.playersBank(player);
						i--;
					}
				}
			}
		}
		
		dice.roll();
		player.movePosition(dice.die1+dice.die2);
		LocationAction la = new LocationAction(player);
		la.action();
		if(player.getMoney()<0) {
			DisplayMessages.bankruptWarningMessage();
			int n = player.getNumOfProps();
			for(int i=0; i<n; i++) {
				PropActions.mortgageProp(player, player.getProperties().get(i));
				if(player.getMoney()>0) {
					break;
				}
			}
			
			if(player.getMoney()<0) {
				DisplayMessages.bankruptMessage();
				player.setBankrupt(true);				
			}
		}
		
		DisplayMessages.displayBreak();
		DisplayMessages.playersBank(player);
		if(player.getNumOfProps()!=0) {
			DisplayMessages.playersProperties(player);
		}
		
	}		
}
