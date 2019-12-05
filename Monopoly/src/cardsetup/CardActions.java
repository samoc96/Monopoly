package cardsetup;

import java.util.ArrayList;
import java.util.HashMap;

import codingtools.DisplayMessages;
import gamesetup.Dice;
import gamesetup.LocationAction;
import gamesetup.PropActions;
import playersetup.Player;
import propertysetup.DefinePropertiesSingleton;
import propertysetup.Properties;
/**
 * 
 * @author SamOConnor<p>
 *Class to perform the card actions for moving to nearest railroad/utility.
 */
public class CardActions {
	/**
	 * Determines where the nearest railroad is to the current players position.<p>
	 * Moves the player to this railroad.<p>
	 * If the railroad is owned but not by the player then the player must pay the owner twice the rent price.<p>
	 * If unowned, the player has the option to buy it.
	 * @param player
	 * @param gamePlayers
	 */
	public static void moveToRailRoad(Player player, ArrayList <Player> gamePlayers) {

		DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
		HashMap<Integer, Properties> d	= definePropertiesSingleton.getHashMap();		

		int posR = player.getPosition();
		
		if(posR<5) {
			player.setPosition(5);
			posR=5;
		}
		else if(posR<15) {
			player.setPosition(15);
			posR=15;
		}
		else if(posR<25) {
			player.setPosition(25);
			posR=25;
		}
		else {
			player.setPosition(35);
			posR=35;
		}
		if(d.get(posR).getOwner()!=null && d.get(posR).getOwner()!=player) {
			DisplayMessages.locationMessage(d.get(posR).getName());
			System.out.print("This railroad is owned! Pay the owner twice the current rent price!\n");
			PropActions.payRent(player, d.get(posR));
			PropActions.payRent(player, d.get(posR));
			DisplayMessages.rentMessage(d.get(posR).getOwner().getName(), d.get(posR).getRentPrice()*2);
		}
		else {
			LocationAction.action(player, gamePlayers);	
		}
	}
	/**
	 * Determines where the nearest utility is to the current players position.<p>
	 * Moves the player to this utility.<p>
	 * If the utility is owned but not by the player then the player must pay the owner 10 times the amount rolled on the dice.<p>
	 * If unowned, the player has the option to buy it.
	 * @param player
	 * @param gamePlayers
	 */
	public static void moveUtility(Player player,ArrayList <Player> gamePlayers) {
		DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
		HashMap<Integer, Properties> d	= definePropertiesSingleton.getHashMap();
		LocationAction.action(player,gamePlayers);
		Dice dice = new Dice();
		int posU = player.getPosition();
		
		if(posU<12||posU>28) {
			player.setPosition(12);
			posU=12;					
		}
		else {
			player.setPosition(28);
			posU=28;

		}
		DisplayMessages.locationMessage(d.get(posU).getName());
		if(d.get(posU).getOwner()!=null && d.get(posU).getOwner()!=player) {
			System.out.print("This utility is owned! Pay the owner 10 times the amount thrown on your next roll!\n");
			dice.roll();
			DisplayMessages.rentMessage(d.get(posU).getOwner().getName(), (dice.die1+dice.die2)*10);
			player.payPlayer(d.get(posU).getOwner(), (dice.die1+dice.die2)*10);
		}
		else {
			LocationAction.action(player,gamePlayers);
		}
	}
	
	public static void payAll(ArrayList <Player> gamePlayers, Player player, int cardTypeVariable1) {
		for(int i = 0; i<gamePlayers.size(); i++) {
			if(gamePlayers.get(i)!=player) {
				player.payPlayer(gamePlayers.get(i), cardTypeVariable1);
			}
		}
	}
	
	public static void receiveAll(ArrayList <Player> gamePlayers, Player player, int cardTypeVariable1) {
		for(int i = 0; i<gamePlayers.size(); i++) {
			if(gamePlayers.get(i)!=player) {
				gamePlayers.get(i).payPlayer(player, cardTypeVariable1);
			}
		}
	}
	
}
