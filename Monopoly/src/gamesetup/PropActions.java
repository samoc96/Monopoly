package gamesetup;

import codingtools.DisplayMessages;
import playersetup.Player;
import propertysetup.PropType;
import propertysetup.Properties;
import propertysetup.RailRoads;
import propertysetup.TitleDeeds;
import propertysetup.Utilities;

public class PropActions {
	
	Player p;
	Properties prop;
	//public PropActions(Player p, Properties prop){
		//this.p=p;
		//this.prop=prop;
	//}
	
	public static void buyProp(Player p, Properties prop){
		p.pay(prop.getPrice());
		prop.setOwner(p);
		p.newProperty(prop);
		if(prop.getPropType().equals(PropType.RAILROAD)) {
			int n = 1 + p.getNumOfRR();
			p.setNumOfRR(n);
			((RailRoads) prop).setRailRoadRentPrice(n);
		}
		
		else if(prop.getPropType().equals(PropType.UTILITY)) {
			int u = 1 + p.getNumOfU();
			p.setNumOfU(u);
			}
	}
	
	public static void mortgageProp(Player player, Properties properties){
		player.receive(properties.getMortgage()/2);
		player.removeProperty(properties);
		DisplayMessages.mortgageProp(properties);
		properties.setOwner(null);		
	}
	
	public static void buildHH(Player p, Properties prop){
		((TitleDeeds) prop).addHouse();	
	}
	
	public static void payRent(Player p, Properties prop){
		if(prop.getPropType().equals(PropType.UTILITY)) {
			((Utilities) prop).setUtilitiesRentPrice(prop.getOwner().getNumOfU());			
			p.payPlayer(prop.getOwner(), prop.getRentPrice());
		}
		
		if(prop.getPropType().equals(PropType.RAILROAD)) {
			((RailRoads) prop).setRailRoadRentPrice(prop.getOwner().getNumOfRR());			
			p.payPlayer(prop.getOwner(), prop.getRentPrice());
		}
		
		else {
			p.payPlayer(prop.getOwner(), prop.getRentPrice());			
		}
	}
	
	
}
