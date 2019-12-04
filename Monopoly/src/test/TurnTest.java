package test;

import org.junit.Before;
import org.junit.Test;

import gameplay.Turn;
import gamesetup.Dice;
import gamesetup.LocationAction;
import playersetup.Player;

public class TurnTest {
	
	Dice dice = new Dice();
	Player player = new Player("Sam");
	
	@Before
	public void setUp() {
		player.setPosition(30);		
	}

	@Test
	public void testJailTurn() {
		LocationAction.action(player);
		Turn.jailTurn(player, dice);
	}

}
