package gameplay;

import java.util.ArrayList;

import codingtools.DisplayMessages;
import codingtools.UserPrompts;
import gamesetup.Dice;
import gamesetup.LocationAction;
import gamesetup.PropActions;
import playersetup.Player;
import propertysetup.TitleDeeds;
/**
 * 
 * @author SamOConnor<p>
 *	Class to enable player to perform a normal turn or a jail turn.
 */
public class Turn {
	/**
	 * Method takes in a player, a dice and an arrayList of players.<p>
	 * Present's the player with a number of different options such as viewing properties and performing actions.<p>
	 * Player then roll's the dice and performs a location action based on their new position.<p>
	 * After this action the method checks if the player is bankrupt.<p>
	 * Displays messages such as the player's bank and who's turn it is etc.
	 * @param player
	 * @param dice
	 * @param gamePlayers
	 */
	public static void playerTurn(Player player,Dice dice, ArrayList <Player> gamePlayers){
		DisplayMessages.playersTurn(player);
		DisplayMessages.playersBank(player);
		if(player.getNumOfProps()!=0 && UserPrompts.viewProperties()) {
			DisplayMessages.playersProperties(player);
			DisplayMessages.displayBreak();
			}
		if(player.getNumOfProps()!=0 && UserPrompts.propertyAction()) {
			for(int i = 0; i < player.getNumOfProps(); i++) {
				System.out.print("For the following property:\n"+player.getProperties().get(i).getName()+"\n");
				if(player.getProperties().get(i).isMonopoly()) {
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
		dice.roll();
		player.movePosition(dice.die1+dice.die2);
		LocationAction.action(player, gamePlayers);
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
		DisplayMessages.playersBank(player);
		if(player.getNumOfProps()!=0 && UserPrompts.viewProperties()) {
			DisplayMessages.playersProperties(player);
			}
		DisplayMessages.displayBreak();
		}
	
	/**
	 * Takes in a player, a dice and an arrayList of players.<p>
	 * First determines if the player has a GOJ card and if they want to use it.<p>
	 * If they use it, they are free from jail and proceed to their normal turn.<p>
	 * Otherwise, they have the option to pay a fine and leave jail.<p>
	 * If they don't pay the fine they may try roll a double to leave.<p>
	 * If they fail to throw a double in three consecutive jail turns, they pay the fine and leave.
	 * @param player
	 * @param dice
	 * @param gamePlayers
	 */
	public static void jailTurn(Player player, Dice dice,ArrayList <Player> gamePlayers) {
		DisplayMessages.playersTurn(player);
		DisplayMessages.jailMessage();
		if(player.getHasJailCard() && UserPrompts.useJailCard()) {
				DisplayMessages.usedJailCard();
				player.setIsInJail(false);
				playerTurn(player,dice,gamePlayers);
		}
		else if(UserPrompts.payJailFine()){
			DisplayMessages.payJailFine();
			player.pay(50);
			player.setIsInJail(false);
			playerTurn(player,dice,gamePlayers);
		}
		else {
			DisplayMessages.rollDoubleJail();
			dice.roll();
			if(dice.die1 == dice.die2) {
				DisplayMessages.doubleRolledJail();
				player.setIsInJail(false);
				playerTurn(player,dice,gamePlayers);				
			}
			else {
				player.setNumberOfJailDoubles(player.getNumberOfJailDoubles()+1);
				if(player.getNumberOfJailDoubles()==3) {
					DisplayMessages.doublePayJailFine();
					player.pay(50);
					player.setIsInJail(false);
					playerTurn(player,dice,gamePlayers);
				}
				else {
					DisplayMessages.noDoubleRolledJail();
				}
			}
		}
	}
}
