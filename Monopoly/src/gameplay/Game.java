package gameplay;

import codingtools.UserPrompts;

public class Game {
	
	
	//scan in number of players
	//scan in player names
	//scan in player tokens
	//add players to array list
	//while loop that iterates through players and performs turn()
	//print to screen constantly informing players
	
	
	public static void main(String[] args){
		int numberOfPlayers = UserPrompts.playerNumber();
		System.out.println(+numberOfPlayers);
		boolean buyProp = UserPrompts.buyProperty();
		System.out.println(buyProp);
	}
	

	
	//int numberOfPlayers;
	//private ArrayList<Player> players;
	
	//public void inputNumPlayers(int num)
	//{
		//numberOfPlayers = num;
	//}
	
	
	
}
