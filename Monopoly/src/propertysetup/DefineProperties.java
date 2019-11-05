package propertysetup;

import gamesetup.RailRoads;
import gamesetup.Utilities;

import java.util.HashMap;

public class DefineProperties {
	Properties med = new TitleDeeds("Mediterranean Avenue", PropType.PURPLE, 60, 30, 50, 2, 10, 30, 90, 160, 250, 2);
	Properties bal = new TitleDeeds("Baltic Avenue", PropType.PURPLE, 60, 30, 50, 4, 20, 60, 180, 320, 450, 2);

	Properties ori = new TitleDeeds("Oriental Avenue", PropType.LIGHTBLUE, 100, 50, 50, 6, 30, 90, 270, 400, 550, 3);
	Properties ver = new TitleDeeds("Vermont Avenue", PropType.LIGHTBLUE, 100, 50, 50, 6, 30, 90, 270, 400, 550, 3);
	Properties con = new TitleDeeds("Connecticut Avenue", PropType.LIGHTBLUE, 100, 60, 50, 8, 40, 100, 300, 450, 600, 3);
	
	
	Properties cha = new TitleDeeds("St. Charles Place", PropType.PINK, 140, 70, 100, 10, 50, 150, 450, 625, 750, 3);
	Properties sta = new TitleDeeds("States Avenue", PropType.PINK, 140, 70, 100, 10, 50, 150, 450, 625, 750, 3);
	Properties vir = new TitleDeeds("Virginia Avenue", PropType.PINK, 160, 80, 100, 12, 60, 180, 500, 700, 900, 3);
	
	Properties jam = new TitleDeeds("St. James Place", PropType.ORANGE, 180, 90, 100, 14, 70, 200, 550, 750, 950, 3);
	Properties ten = new TitleDeeds("Tennessee Avenue", PropType.ORANGE, 180, 90, 100, 14, 70, 200, 550, 750, 950, 3);
	Properties yor = new TitleDeeds("New York Avenue", PropType.ORANGE, 200, 100, 100, 16, 80, 220, 600, 800, 1000, 3);
	
	Properties ken = new TitleDeeds("Kentucky Avenue", PropType.RED, 220, 110, 150, 18, 90, 250, 700, 875, 1050, 3);
	Properties ind = new TitleDeeds("Indiana Avenue", PropType.RED, 220, 110, 150, 18, 90, 250, 700, 875, 1050, 3);
	Properties ill = new TitleDeeds("Illinois Avenue", PropType.RED, 240, 120, 150, 20, 100, 300, 750, 925, 1100, 3);
	
	Properties atl = new TitleDeeds("Atlantic Avenue", PropType.YELLOW, 260, 130, 150, 22, 110, 330, 800, 975, 1150, 3);
	Properties ven = new TitleDeeds("Ventnor Avenue", PropType.YELLOW, 260, 130, 150, 22, 110, 330, 800, 975, 1150, 3);
	Properties mar = new TitleDeeds("Marvin Gardens", PropType.YELLOW, 280,140, 150, 24, 120, 360, 850, 1025, 1200, 3);
	
	Properties pac = new TitleDeeds("Pacific Avenue", PropType.GREEN, 300, 150, 200, 26, 130, 390, 900, 1100, 1275, 3);
	Properties car = new TitleDeeds("North Carolina Avenue", PropType.GREEN, 300, 150, 200, 26, 130, 390, 900, 1100, 1275, 3);
	Properties pen = new TitleDeeds("Pennsylvania Avenue", PropType.GREEN, 320, 160, 200, 28, 150, 450, 1000, 1200, 1400,3);
	
	Properties par = new TitleDeeds("Park Place", PropType.DARKBLUE, 350, 175, 200, 35, 175, 500, 1100, 1300, 1500,2);
	Properties boa = new TitleDeeds("Boardwalk", PropType.DARKBLUE, 400, 200, 200, 50, 200, 600, 1400, 1700, 2000, 2);
	
	Properties rea = new RailRoads("Reading Railroad", PropType.RAILROAD, 200, 100);
	Properties penn = new RailRoads("Pennsylvania Railroad", PropType.RAILROAD, 200, 1000);
	Properties bo = new RailRoads("B & O Railroad", PropType.RAILROAD, 200, 100);
	Properties sho = new RailRoads("Short Line Railroad", PropType.RAILROAD, 200, 100);
	
	Properties ele = new Utilities("Electric Company", PropType.UTILITY, 150, 75);
	Properties wat = new Utilities("Water Works", PropType.UTILITY, 150, 75);
	
	public HashMap<Integer, Properties> getHashMap(){
		
		HashMap<Integer, Properties> hs = new HashMap<Integer, Properties>();
		
		hs.put(1, med);
		hs.put(3, bal);
		hs.put(6, ori);
		hs.put(8, ver);
		hs.put(9, con);
		hs.put(11, cha);
		hs.put(13, sta);
		hs.put(14, vir);
		hs.put(16, jam);
		hs.put(18, ten);
		hs.put(19, yor);
		hs.put(21, ken);
		hs.put(23, ind);
		hs.put(24, ill);
		hs.put(26, atl);
		hs.put(27, ven);
		hs.put(29, mar);
		hs.put(31, pac);
		hs.put(32, car);
		hs.put(34, pen);
		hs.put(37, par);
		hs.put(39, boa);
		
		hs.put(5, rea);
		hs.put(15, penn);
		hs.put(25, bo);
		hs.put(35, sho);
		
		hs.put(12, ele);
		hs.put(28, wat);
		return hs;
	}
	
}