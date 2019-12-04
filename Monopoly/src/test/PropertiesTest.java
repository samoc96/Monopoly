package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import playersetup.Player;

import org.junit.Before;

import propertysetup.PropType;
import propertysetup.Properties;
import propertysetup.RailRoads;
import propertysetup.TitleDeeds;
import propertysetup.Utilities;

public class PropertiesTest {

	Properties underTestTitleDeedsMED = new TitleDeeds("Mediterranean Avenue", PropType.PURPLE, 60, 30, 50, 2, 10, 30, 90, 160, 250, 2);
	Properties underTestTitleDeedsBAL = new TitleDeeds("Baltic Avenue", PropType.PURPLE, 60, 30, 50, 4, 20, 60, 180, 320, 450, 2);
	Properties underTestTitleDeedsORI = new TitleDeeds("Oriental Avenue", PropType.LIGHTBLUE, 100, 50, 50, 6, 30, 90, 270, 400, 550, 3);

	Properties underTestUtilities = new Utilities("Electric Company", PropType.UTILITY, 150, 75);
	Properties underTestRailRoads = new RailRoads("Short Line Railroad", PropType.RAILROAD, 200, 100);

	
	Player player = new Player("Tester");
	
	@Before
	public void setUp() {
		underTestTitleDeedsMED.setOwner(player);
		player.newProperty(underTestTitleDeedsMED);
		underTestTitleDeedsMED.setRentPrice();
		
		underTestTitleDeedsBAL.setOwner(player);
		player.newProperty(underTestTitleDeedsBAL);
		
		underTestUtilities.setOwner(player);
		underTestUtilities.setRentPrice();
		
		underTestRailRoads.setOwner(player);
		underTestRailRoads.setRentPrice();
	}
	
	@Test
	public void testSetRentPrice() {	
		
		//When
		int result = underTestTitleDeedsMED.setRentPrice();
		
		//Then
		assertEquals(2, result, 0.0);
	}
	
	
	
	@Test
	public void testGetOwner() {
		//When
		Player result = underTestTitleDeedsMED.getOwner();
		
		//Then
		assertEquals(player, result);
	}
	
	@Test
	public void testGetPropType() {
		PropType result = underTestTitleDeedsMED.getPropType();
		
		assertEquals(PropType.PURPLE, result);
		
	}
	
	@Test
	public void testIsMonopoly() {
		//When
		boolean result = underTestTitleDeedsMED.isMonopoly();
		
		//Then
		assertEquals(true, result);
		
		//when
		boolean resultTwo = underTestTitleDeedsORI.isMonopoly();
		
		//Then
		assertEquals(false, resultTwo);

	}
	
	@Test
	public void testGetNumOfHouses() {
		//When
		int result = underTestTitleDeedsMED.getNumOfHouses();
		
		//Then
		assertEquals(0, result, 0.0);
		
		//When
		((TitleDeeds) underTestTitleDeedsMED).addHouse();
		int resultOne = underTestTitleDeedsMED.getNumOfHouses();
		
		//Then
		assertEquals(1, resultOne);
		
		//When
		((TitleDeeds) underTestTitleDeedsMED).addHouse();
		int resultTwo = underTestTitleDeedsMED.getNumOfHouses();
				
		//Then
		assertEquals(2, resultTwo);
		
		//When
		((TitleDeeds) underTestTitleDeedsMED).addHouse();
		int resultThree = underTestTitleDeedsMED.getNumOfHouses();
				
		//Then
		assertEquals(3, resultThree);
		
		//When		
		((TitleDeeds) underTestTitleDeedsMED).addHouse();
		int resultFour = underTestTitleDeedsMED.getNumOfHouses();
		System.out.print(resultFour);
				
		//Then
		assertEquals(0, resultFour);

		//When
		int resultFive = underTestRailRoads.getNumOfHouses();
				
		//Then
		assertEquals(0, resultFive, 0.0);
				
		//When
		int resultSix = underTestUtilities.getNumOfHouses();
						
		//Then
		assertEquals(0, resultSix, 0.0);
	}
	
	@Test
	public void testGetNumOfHotels() {
		//When
		int result = underTestTitleDeedsBAL.getNumOfHotels();
		
		//Then
		assertEquals(0, result, 0.0);
		
		//When
		((TitleDeeds) underTestTitleDeedsBAL).addHouse();
		((TitleDeeds) underTestTitleDeedsBAL).addHouse();
		((TitleDeeds) underTestTitleDeedsBAL).addHouse();
		((TitleDeeds) underTestTitleDeedsBAL).addHouse();
		int resultOne = underTestTitleDeedsBAL.getNumOfHotels();
		
		//Then
		assertEquals(1, resultOne, 0.0);
		
		//When
		int resultTwo = underTestRailRoads.getNumOfHotels();
				
		//Then
		assertEquals(0, resultTwo, 0.0);
				
		//When
		int resultThree = underTestUtilities.getNumOfHotels();
						
		//Then
		assertEquals(0, resultThree, 0.0);
	}
	
	@Test
	public void testGetHousePrice() {
		//When
		int result = underTestTitleDeedsMED.getHousePrice();
		
		//Then
		assertEquals(50, result, 0.0);
	}
	
	@Test
	public void testGetMortgage() {
		//When
		int result = underTestTitleDeedsMED.getMortgage();
		
		//Then
		assertEquals(30, result, 0.0);
	}
	
	@Test
	public void testGetPrice() {
		//When
		int result = underTestTitleDeedsMED.getPrice();
		
		//Then
		assertEquals(60, result, 0.0);
	}
	
	@Test
	public void testGetName() {
		//When
		String result = underTestTitleDeedsMED.getName();
		
		//Then
		assertEquals("Mediterranean Avenue", result);
	}
	
	
}
