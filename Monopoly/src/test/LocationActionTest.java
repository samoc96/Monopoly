package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import gamesetup.LocationAction;
import playersetup.Player;
import propertysetup.DefinePropertiesSingleton;
import propertysetup.Properties;

public class LocationActionTest {
	Player player = new Player("Tester");
	Player playerTwo = new Player("TesterTwo");
	DefinePropertiesSingleton definePropertiesSingleton = DefinePropertiesSingleton.getInstance();
//	DefinePropertiesSingleton.setProperties();
	
	
	@Test
	public void testActionOne() {
		//When
		player.setPosition(0);
		LocationAction.action(player);
		//Then
		int result = player.getPosition();
		assertEquals(0, result);
	}
	
	@Test
	public void testActionTwo() {
		//When
		player.setPosition(10);
		LocationAction.action(player);
		int result = player.getPosition();
		//Then
		assertEquals(10, result);
	}
	
	@Test
	public void testActionThree() {
		//When
		player.setPosition(20);
		LocationAction.action(player);
		int result = player.getPosition();
		//Then
		assertEquals(20, result);
	}
	
	@Test
	public void testActionFour() {
		//When
		player.setPosition(30);
		LocationAction.action(player);
		int result = player.getPosition();
		boolean resultTwo = player.getIsInJail();
		//Then
		assertEquals(10, result);
		assertEquals(true, resultTwo);
		
	}
	
	@Test
	public void testActionFive() {
		//When
		player.setPosition(4);
		LocationAction.action(player);
		int result = player.getMoney();
		//Then
		assertEquals(1500-200,result);
	}
	
	@Test
	public void testActionSix() {
		//When
		player.setPosition(38);
		LocationAction.action(player);
		int result = player.getMoney();
		//Then
		assertEquals(1500-75,result);
	}
	
	@Test
	public void testActionSeven() {
		//When
		definePropertiesSingleton.setProperties();
		HashMap<Integer, Properties> d	= definePropertiesSingleton.getHashMap();	

		d.get(1).setOwner(playerTwo);
		player.setPosition(1);
		LocationAction.action(player);
		int result = player.getMoney();
		int resultTwo = playerTwo.getMoney();
		//Then
		assertEquals(1500-d.get(1).getRentPrice(),result);
		assertEquals(1500+d.get(1).getRentPrice(),resultTwo);
	}
}
