package playersetup;

import java.util.ArrayList;

import codingtools.UserPrompts;

public class DefinePlayer {
	
	static int numOfPlayer = UserPrompts.playerNumber();
	private static ArrayList <Player> gamePlayers = new ArrayList <Player>(); 
	
	public static void setPlayers() {
		for(int i = 1; i<=numOfPlayer; i++) {
			gamePlayers.add(new Player(UserPrompts.playerName(i)));
		}
	}
	
	public static ArrayList <Player> getPlayers(){
		return gamePlayers;
	}
}
