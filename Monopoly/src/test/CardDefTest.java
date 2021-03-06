package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cardsetup.CardDef;
import cardsetup.CardType;
import playersetup.Player;
/**
 * 
 * @author SamOConnor<p>
 * Class to test the CardDef class.
 *
 */
public class CardDefTest {
	

	CardDef cardDef = new CardDef("Advance to \"Go\"\n", CardType.MOVE_TO, 0, 0);
	CardDef chance6 = new CardDef("Bank pays you dividend of $50.\n", CardType.RECEIVE, 50, 0);
	CardDef chance8 = new CardDef("Go Back Three {3} Spaces.", CardType.MOVE, -3, 0);
	CardDef chance11 = new CardDef("Pay poor tax of $15\n", CardType.PAY, 15, 0);
	CardDef chance9 = new CardDef("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.\n", CardType.GTJ, 10, 0);

	Player player = new Player("Tester");
	ArrayList <Player> gamePlayers = new ArrayList <Player>();


	@Before
	public void setPlayer() {
		gamePlayers.add(player);
	}
	
	@Test
	public void testGetMessage() {
		//When
		String result = cardDef.getMessage();
		
		//Then
		assertEquals("Advance to \"Go\"\n", result);
	}
	
	
	@Test
	public void testGetCardType() {
		//When
		CardType result = cardDef.getCardType();
		//Then
		assertEquals(CardType.MOVE_TO,result);
	}
	
	@Test
	public void testActionOne() {
		//When
		cardDef.action(player,gamePlayers);
		int result = player.getPosition();
		
		//Then
		assertEquals(0, result);
	}
	

	public void testActionTwo() {
		//When
		chance6.action(player,gamePlayers);
		double result = player.getMoney();
		
		//Then
		assertEquals(1500+50, result,0.0);
	}
	
	@Test
	public void testActionThree() {
		//When
		chance8.action(player,gamePlayers);
		int result = player.getPosition();
		
		//Then
		assertEquals(37, result);
	}
	
	@Test
	public void testActionFour() {
		//When
		chance11.action(player,gamePlayers);
		double result = player.getMoney();
		
		//Then
		assertEquals(1500-15, result,0.0);
	}
	
	@Test
	public void testActionFive() {
		//When
		chance9.action(player,gamePlayers);
		int result = player.getPosition();
		boolean resultTwo = player.getIsInJail();
		
		//Then
		assertEquals(10, result);
		assertEquals(true, resultTwo);
	}
	
}
