package playersetup;

import java.util.ArrayList;

import codingtools.UserPrompts;

/**
 * 
 * @author SamOConnor<p>
 * Class to construct an array list of player's.
 * 
 */

public class DefinePlayer {
	/**
	 * Determine number of player's from user's input.
	 */
	static int numOfPlayer = UserPrompts.playerNumber();
	/**
	 * Array list to store player's.
	 */
	private static ArrayList <Player> gamePlayers = new ArrayList <Player>(); 
	
	/**
	 * Method to use the name inputed from the user to construct each player.<p>
	 * Adds each player to an array list.
	 */
	public static void setPlayers() {
		for(int i = 1; i<=numOfPlayer; i++) {
			gamePlayers.add(new Player(UserPrompts.playerName(i)));
		}
	}
	
	/**
	 * @return
	 * Returns the arrayList containing the players.
	 */
	public static ArrayList <Player> getPlayers(){
		return gamePlayers;
	}
}
