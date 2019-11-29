package gameplay;

import java.util.ArrayList;
import java.util.HashMap;

import codingtools.UserPrompts;
import gamesetup.LocationAction;
import gamesetup.PropActions;
import playersetup.DefinePlayer;
import playersetup.Player;
import playersetup.Token;
import propertysetup.DefineProperties;
import propertysetup.Properties;

public class Game {
	
	
	//scan in number of players
	//scan in player names
	//scan in player tokens
	//add players to array list
	//while loop that iterates through players and performs turn()
	//print to screen constantly informing players
	
	
	public static void main(String[] args){
		//int numberOfPlayers = UserPrompts.playerNumber();
		//System.out.println(+numberOfPlayers);
		//boolean buyProp = UserPrompts.buyProperty();
		//System.out.println(buyProp);
		//UserPrompts.locationMessage("Go");
		
		
		UserPrompts.welcomeMessage();
		DefinePlayer.setPlayers();
		ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
		//Player player = new Player("Sam", Token.BLACK);
		//while(true) {
			//if(UserPrompts.playersTurn(player)) {
				//Turn turn = new Turn(player);
				//turn.playerRoll();
			//}
		//}
		//UserPrompts.playersPosition(gamePlayers.get(0));
		//UserPrompts.playersBank(gamePlayers.get(0));
		DefineProperties.setProperties();
		HashMap<Integer, Properties> test = DefineProperties.getHashMap();
		//PropActions propActions = new PropActions(gamePlayers.get(1), test.get(15));
		
		PropActions.buyProp(gamePlayers.get(1), test.get(15));
		//PropActions propActions = new PropActions(gamePlayers.get(1), test.get(25));
		PropActions.buyProp(gamePlayers.get(1), test.get(25));
		UserPrompts.playersBank(gamePlayers.get(1));		
		
		
		//System.out.print("\n"+test.get(15).getRentPrice());
		//UserPrompts.playersBank(gamePlayers.get(1));
		//UserPrompts.playersProperties(gamePlayers.get(1));
		LocationAction locationAction = new LocationAction(gamePlayers.get(0));
		gamePlayers.get(0).setPosition(7);
		locationAction.action();
		
		UserPrompts.playersBank(gamePlayers.get(0));
		UserPrompts.playersBank(gamePlayers.get(1));
		//System.out.print(gamePlayers.get(0).getIsInJail());
		
		//UserPrompts.playersPosition(gamePlayers.get(0));
		//UserPrompts.playersBank(gamePlayers.get(0));
		//UserPrompts.playersProperties(gamePlayers.get(1));
		//UserPrompts.playersBank(gamePlayers.get(1));		
		//UserPrompts.playersBank(gamePlayers.get(2));		
		//System.out.print(player.getPosition()+"\n");
		//player.movePosition(-3);
		//System.out.print(player.getPosition());
		
		
		
		
		//HashMap<Integer, Properties> test = DefineProperties.getHashMap();
		//System.out.println(test.get(1).getName());
	
		
		
		//DefinePlayer.setPlayers();
		//ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
		//for(int i = 0; i < gamePlayers.size(); i++) {
			//UserPrompts.playersBank(gamePlayers.get(i));			
		//}
		//int i = 0;
		
		//while(gamePlayers.size()>0) {
			//if(UserPrompts.playersTurn(gamePlayers.get(i))) {
				//Turn turn = new Turn(gamePlayers.get(i));
				//turn.playerRoll();
			//}
			//i++;
			//if(i>gamePlayers.size()-1) {
				//i=0;
			//}
		//}

	}

	

	
	//int numberOfPlayers;
	//private ArrayList<Player> players;
	
	//public void inputNumPlayers(int num)
	//{
		//numberOfPlayers = num;
	//}
	
	
	
}
