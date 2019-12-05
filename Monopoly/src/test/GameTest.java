package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import gameplay.Game;
import playersetup.Player;
import propertysetup.PropType;
import propertysetup.Properties;
import propertysetup.TitleDeeds;

public class GameTest {
	Player player = new Player("Tester");
	Player playerTwo = new Player("TesterTwo");
	Player playerThree = new Player("TesterThree");
	Properties underTestTitleDeedsMED = new TitleDeeds("Mediterranean Avenue", PropType.PURPLE, 60, 30, 50, 2, 10, 30, 90, 160, 250, 2);


	ArrayList <Player> gamePlayers = new ArrayList <Player>();
	
	@Before
	public void setPlayer() {
		gamePlayers.add(player);
		gamePlayers.add(playerTwo);
		gamePlayers.add(playerThree);
		gamePlayers.get(0).pay(200);
		gamePlayers.get(1).pay(500);
		gamePlayers.get(2).newProperty(underTestTitleDeedsMED);
	}
	
	@Test
	public void testWinner() {
		//When
		Player result = Game.Winner(gamePlayers);
		System.out.print(result.getName());
		//Then
		assertEquals(playerThree.getName(), result.getName());
	}
}
