package gameplay;

import java.util.ArrayList;
import codingtools.DisplayMessages;
import gamesetup.Dice;
import playersetup.DefinePlayer;
import playersetup.Player;
import propertysetup.DefinePropertiesSingleton;

public class Game {
	private static int numOfBankrupt;
	
	public static void play(){
		int i = 0;
		int count = 0;
		Dice dice = new Dice();
		DisplayMessages.welcomeMessage();
		DefinePlayer.setPlayers();
		DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
		definePropertiesSingleton.setProperties();
		ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
		
		while(gamePlayers.size()>1 && numOfBankrupt<2) {
			
			if(gamePlayers.get(i).getIsInJail() == true) {
				Turn.jailTurn(gamePlayers.get(i), dice,gamePlayers);
			}
			else {
				Turn.playerTurn(gamePlayers.get(i), dice,gamePlayers);
				if(gamePlayers.get(i).isBankrupt()) {
					gamePlayers.remove(i);
					numOfBankrupt += 1;
				}
				if(dice.die1==dice.die2) {
					count++;
					DisplayMessages.doubleRolled();
				}
				else {
					count = 0;
					i++;
				}
				if(count == 3) {
					gamePlayers.get(i).setIsInJail(true);
					gamePlayers.get(i).setPosition(10);
					DisplayMessages.doubleGoToJailMessage();
					DisplayMessages.displayBreak();
				}
				if(i==gamePlayers.size()) {
					i=0;
				}
			}
		}
		System.out.print("GAME OVER!\n");
		System.out.print(Winner(gamePlayers).getName()+" is the Winner with a bank account of: $" +Winner(gamePlayers).getMoney()+"\nCONGRATULATIONS!");
	}
		
	public static Player Winner(ArrayList <Player> gamePlayers) {
		int i=0;
		int most_money = 0;
		int w = 0;
		for(i = 0;i<gamePlayers.size();i++) {
			int money = 0;
			money += gamePlayers.get(i).getMoney();
			for(int j=0; j<gamePlayers.get(i).getNumOfProps();j++) {
				money += gamePlayers.get(i).getProperties().get(j).getPrice();
				money += gamePlayers.get(i).getProperties().get(j).getNumOfHouses()*gamePlayers.get(i).getProperties().get(j).getHousePrice();	
				money += 5*gamePlayers.get(i).getProperties().get(j).getNumOfHotels()*gamePlayers.get(i).getProperties().get(j).getHousePrice();
			}
			if(money > most_money) {
				most_money = money;
				w = i;
			}
		}
		return gamePlayers.get(w);	
	}
}
