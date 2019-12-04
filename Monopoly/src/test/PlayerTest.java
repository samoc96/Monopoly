package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import playersetup.Player;
import propertysetup.PropType;
import propertysetup.Properties;
import propertysetup.TitleDeeds;

public class PlayerTest {
	Player player = new Player("Tester");
	Player playerTwo = new Player("TesterTwo");
	Properties underTestTitleDeedsMED = new TitleDeeds("Mediterranean Avenue", PropType.PURPLE, 60, 30, 50, 2, 10, 30, 90, 160, 250, 2);
	Properties underTestTitleDeedsBAL = new TitleDeeds("Baltic Avenue", PropType.PURPLE, 60, 30, 50, 4, 20, 60, 180, 320, 450, 2);


	
	@Before
	public void setUp() {
		player.setPosition(20);
		player.setHasJailCard(true);
		player.setIsInJail(true);
		player.setNumberOfJailDoubles(1);
		player.setNumOfRR(2);
		player.setNumOfU(1);
		player.setBankrupt(true);
	}
	
	@Test
	public void testSetPosition() {
		//When
		player.setPosition(30);
		player.setIsInJail(false);
		player.setPosition(5);
		int result = player.getMoney();
		
		//Then
		assertEquals(1700,result);
	}
	
	@Test
	public void testGetPosition() {
		//When
		int result = player.getPosition();
		
		//Then
		assertEquals(20,result);
	}
	
	@Test
	public void testGetHasJailCard() {
		//When
		boolean result = player.getHasJailCard();
		
		//Then
		assertEquals(true,result);
	}
	
	@Test
	public void testSetIsInJail() {
		//When
		boolean result = player.getIsInJail();
		
		//Then
		assertEquals(true, result);
	}
	
	@Test
	public void testSetNumberOfJailDoubles() {
		//When
		int result = player.getNumberOfJailDoubles();
		
		//Then
		assertEquals(1, result);
	}
	
	@Test
	public void testSetNumOfRR() {
		//When
		int result = player.getNumOfRR();
		
		//Then
		assertEquals(2, result);
	}
	
	@Test
	public void testSetNumOfU() {
		//When
		int result = player.getNumOfU();
		
		//Then
		assertEquals(1, result);
	}
	
	@Test
	public void testIsBankrupt() {
		//When
		boolean result = player.isBankrupt();
		
		//Then
		assertEquals(true, result);
	}
	
	@Test
	public void testGetName() {
		//When
		String result = player.getName();
		
		//Then
		assertEquals("Tester", result);
	}
	
	@Test
	public void testGetMoney() {
		//When
		int result = player.getMoney();
		
		//Then
		assertEquals(1500, result);
	}
	
	@Test
	public void testPay() {
		//When
		player.pay(50);
		int result = player.getMoney();
		
		//Then
		assertEquals(1500-50, result);
	}
	
	@Test
	public void testReceive() {
		//When
		player.receive(50);
		int result = player.getMoney();
		
		//Then
		assertEquals(1500+50, result);
	}
	
	@Test
	public void testNewProperty() {
		//When
		player.newProperty(underTestTitleDeedsMED);
		int result = player.getNumOfProps();
		
		//Then
		assertEquals(1,result);	
	}
	
	@Test
	public void testRemoveProperty() {
		//When
		player.newProperty(underTestTitleDeedsMED);
		player.newProperty(underTestTitleDeedsBAL);
		player.removeProperty(underTestTitleDeedsBAL);
		int result = player.getNumOfProps();
		
		//Then
		assertEquals(1,result);	
	}
	
	@Test
	public void testPayPlayer() {
		//When
		player.payPlayer(playerTwo, 100);
		int result = playerTwo.getMoney();
		int resultTwo = player.getMoney();
		
		//Then
		assertEquals(1500+100,result);	
		assertEquals(1500-100,resultTwo);	

	}
	
	@Test
	public void testGetProperties() {
		//When
		player.newProperty(underTestTitleDeedsMED);
		ArrayList <Properties> result = player.getProperties();
		
		//Then
		assertEquals(underTestTitleDeedsMED, result.get(0));
	}
	
	@Test
	public void testMovePosition() {
		//When
		player.movePosition(5);
		int result = player.getPosition();
		player.movePosition(20);
		int resultTwo = player.getPosition();
		player.movePosition(-10);
		int resultThree = player.getPosition();
		
		//Then
		assertEquals(25,result);
		assertEquals(5,resultTwo);
		assertEquals(35,resultThree);
	}
}
