package gameplay;

import java.util.ArrayList;
import codingtools.DisplayMessages;
import gamesetup.Dice;
import playersetup.DefinePlayer;
import playersetup.Player;
import propertysetup.DefineProperties;

public class Game {
	
	public static void main(String[] args){
		int i = 0;
		int count = 0;
		Dice dice = new Dice();
		DisplayMessages.welcomeMessage();
		DefinePlayer.setPlayers();
		DefineProperties.setProperties();
		ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
		
		while(gamePlayers.size()>0) {
			if(gamePlayers.get(i).getIsInJail()!=true) {
				//DisplayMessages.playersTurn(gamePlayers.get(i));
				Turn.playerTurn(gamePlayers.get(i), dice);
				
				if(gamePlayers.get(i).isBankrupt()) {
					gamePlayers.remove(i);
				}
				if(dice.die1==dice.die2) {
					count++;
					System.out.print(+dice.die1+"\n"+dice.die2+"\n"+"You have rolled a double! Go again!\n");
					DisplayMessages.displayBreak();
				}
				else {
					count = 0;
					i++;
				}
				if(count==3) {
					gamePlayers.get(i).setIsInJail(true);
					gamePlayers.get(i).setPosition(10);
					DisplayMessages.jailMessage();
					DisplayMessages.displayBreak();

				}
				
			}
			else {
				System.out.print("You are still in jail!\n");
				i++;
			}
			if(i==gamePlayers.size()) {
				i=0;
			}
			
		}
		
		//DisplayMessages.welcomeMessage();
		//DefineProperties.setProperties();
		//HashMap<Integer, Properties> d = DefineProperties.getHashMap();
		//Player player = new Player("Sam");
		//DisplayMessages.playersBank(player);
		//PropActions.buyProp(player, d.get(1));
		//PropActions.buyProp(player, d.get(3));
		//PropActions.buyProp(player, d.get(6));
		//DisplayMessages.playersBank(player);
		//DisplayMessages.playersProperties(player);
		//DisplayMessages.displayBreak();
		
		
		//DisplayMessages.playersProperties(player);

		
		//TEST BANKRUPTCY
		
		// TEST HOUSE AND HOTELS
//		PropActions.buyProp(player, d.get(1));
	//	PropActions.buyProp(player, d.get(3));
		//System.out.print(((TitleDeeds) d.get(1)).isMonopoly()+"\n");
		//System.out.print(((TitleDeeds) d.get(1)).getRentPrice()+"\n");
		//((TitleDeeds) d.get(1)).addHouse();
		//System.out.print(((TitleDeeds) d.get(1)).getRentPrice()+"\n");
		//Properties med = new TitleDeeds("Mediterranean Avenue", PropType.PURPLE, 60, 30, 50, 2, 10, 30, 90, 160, 250, 2);
		//Properties bal = new TitleDeeds("Baltic Avenue", PropType.PURPLE, 60, 30, 50, 4, 20, 60, 180, 320, 450, 2);
		
		
		//Test rolling doubles
		
	}	
}
