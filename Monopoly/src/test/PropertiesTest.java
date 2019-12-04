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

	Properties underTestTitleDeeds = new TitleDeeds("Mediterranean Avenue", PropType.PURPLE, 60, 30, 50, 2, 10, 30, 90, 160, 250, 2);
	Properties underTestUtilities = new Utilities("Electric Company", PropType.UTILITY, 150, 75);
	Properties underTestRailRoads = new RailRoads("Short Line Railroad", PropType.RAILROAD, 200, 100);

	
	Player player = new Player("Tester");
	
	@Before
	public void setUp() {
		underTestTitleDeeds.setOwner(player);
		underTestTitleDeeds.setRentPrice();
		
		underTestUtilities.setOwner(player);
		underTestUtilities.setRentPrice();
		
		underTestRailRoads.setOwner(player);
		underTestRailRoads.setRentPrice();
	}
	
	@Test
	public void testSetRentPrice() throws Throwable {	
		
		//When
		int result = underTestTitleDeeds.setRentPrice();
		
		//Then
		assertEquals(2, result, 0.0);
	}
	
	@Test
	public void testGetOwner() throws Throwable{
		//When
		Player result = underTestTitleDeeds.getOwner();
		
		//Then
		assertEquals(player, result);
	}
	
	@Test
	public void testGetPropType() throws Throwable{
		PropType result = underTestTitleDeeds.getPropType();
		
		assertEquals(PropType.PURPLE, result);
		
	}
	
}
