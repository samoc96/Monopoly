package gamesetup;

import codingtools.DisplayMessages;
import playersetup.Player;
import propertysetup.PropType;
import propertysetup.Properties;
import propertysetup.RailRoads;
import propertysetup.TitleDeeds;
import propertysetup.Utilities;
/**
 * 
 * @author SamOConnor
 *Class to perform various actions on properties
 */
public class PropActions {
	/**
	 * Adds property to the player's property arrayList.<p>
	 * Set's the player as the properties owner.<p>
	 * Displays the price paid for the property.<p>
	 * Increments the number of railroads/utilities owned if the property is a railroad/utility.
	 * @param player
	 * @param properties
	 */
	public static void buyProp(Player player, Properties properties){
		player.pay(properties.getPrice());
		properties.setOwner(player);
		player.newProperty(properties);
		DisplayMessages.boughtProperty(properties);
		if(properties.getPropType().equals(PropType.RAILROAD)) {
			int n = 1 + player.getNumOfRR();
			player.setNumOfRR(n);
			((RailRoads) properties).setRailRoadRentPrice(n);
		}
		
		else if(properties.getPropType().equals(PropType.UTILITY)) {
			int u = 1 + player.getNumOfU();
			player.setNumOfU(u);
			}
	}
	/**
	 * Mortgages the given property for the given player.<p>
	 * Player receives 1/2 the mortgage price.<p>
	 * Property removed from player's properties arrayList.<p>
	 * Display messages describing the action.
	 * @param player
	 * @param properties
	 */
	public static void mortgageProp(Player player, Properties properties){
		player.receive(properties.getMortgage()/2);
		player.removeProperty(properties);
		DisplayMessages.mortgageProp(properties);
		properties.setOwner(null);		
	}
	/**
	 * Builds a house or hotel on the player's specified property depending on the previous number of houses.
	 * @param player
	 * @param properties
	 */
	public static void buildHH(Player player, Properties properties){
		((TitleDeeds) properties).addHouse();	
	}
	/**
	 * Player pays the owner of the property the appropriate rent.<p>
	 * Rent price uniquely determined for railroads and utilities.
	 * @param player
	 * @param properties
	 */
	public static void payRent(Player player, Properties properties){
		if(properties.getPropType().equals(PropType.UTILITY)) {
			((Utilities) properties).setUtilitiesRentPrice(properties.getOwner().getNumOfU());			
			player.payPlayer(properties.getOwner(), properties.getRentPrice());
		}
		
		if(properties.getPropType().equals(PropType.RAILROAD)) {
			((RailRoads) properties).setRailRoadRentPrice(properties.getOwner().getNumOfRR());			
			player.payPlayer(properties.getOwner(), properties.getRentPrice());
		}
		
		else {
			player.payPlayer(properties.getOwner(), properties.getRentPrice());			
		}
	}
	
	
}
