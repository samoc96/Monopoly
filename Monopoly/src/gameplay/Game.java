package gameplay;

import java.util.ArrayList;
import codingtools.DisplayMessages;
import gamesetup.Dice;
import playersetup.DefinePlayer;
import playersetup.Player;
import propertysetup.DefineProperties;

public class Game {
	
	public static void main(String[] args){
		DisplayMessages.welcomeMessage();
		DefinePlayer.setPlayers();
		ArrayList <Player> gamePlayers = DefinePlayer.getPlayers();
		
			
		
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
