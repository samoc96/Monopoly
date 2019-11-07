package gamesetup;

import playersetup.Player;
import propertysetup.Properties;
import propertysetup.TitleDeeds;

public class PropActions {
	
	Player p;
	Properties prop;
	public PropActions(Player p, Properties prop){
		this.p=p;
		this.prop=prop;
	}
	
	public void buyProp(){
		p.pay(prop.getPrice());
		prop.setOwner(p);
	}
	
	public void mortgageProp(){
		p.receive(prop.getMortgage());
		prop.setOwner(null);
	}
	
	public void buildHH(){
		if(((TitleDeeds) prop).isMonopoly()==true){
			((TitleDeeds) prop).addHouse();
		}
	}
	
	public void payRent(){
		p.payPlayer(prop.getOwner(), prop.getRentPrice());
	}
	
	
}
