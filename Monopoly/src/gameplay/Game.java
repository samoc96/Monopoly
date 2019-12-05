package gameplay;

import java.util.ArrayList;
import codingtools.DisplayMessages;
import gamesetup.Dice;
import playersetup.DefinePlayer;
import playersetup.Player;
import propertysetup.DefinePropertiesSingleton;
/**
 * 
 * @author SamOConnor<p>
 * Class to play the game and determine winner.
 *
 */
public class Game {
	private static int numOfBankrupt;
	/**
	 * Method that runs until there are less than two players remaining or two players have gone bankrupts.<p>
	 * Prints welcome message.<p>
	 * Asks user to create players and stores the players in an arrayList.<p>
	 * Iterates through the arrayList and each player performs either a normal or jail turn.<p>
	 * If a player rolls a double during a normal turn they go again.<p>
	 * If they roll three consecutive doubles in a turn they go to jail.<p>
	 * If a player goes bankrupt he is removed from the game.<p>
	 * After the loop is broken, the game is over and the winner is determined using the Winner method.
	 */
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
		
	/**
	 * Method to determine who has won the game.<p>
	 * Iterates through the remaining players once the game has ended and determines their combined cash and total assets value.<p>
	 * Player with most value wins.
	 * @param gamePlayers
	 * @return
	 * The player who has won the game.
	 */
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
