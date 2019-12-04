package gamesetup;

import codingtools.DisplayMessages;
import playersetup.Player;
import propertysetup.PropType;
import propertysetup.Properties;
import propertysetup.RailRoads;
import propertysetup.TitleDeeds;
import propertysetup.Utilities;

public class PropActions {
	
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
	
	public static void mortgageProp(Player player, Properties properties){
		player.receive(properties.getMortgage()/2);
		player.removeProperty(properties);
		DisplayMessages.mortgageProp(properties);
		properties.setOwner(null);		
	}
	
	public static void buildHH(Player player, Properties properties){
		((TitleDeeds) properties).addHouse();	
	}
	
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
