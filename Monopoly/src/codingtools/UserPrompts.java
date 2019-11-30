package codingtools;

public class UserPrompts {
	
	public static int playerNumber(){
		System.out.println("Set how many players are playing (1-6): ");
		return UserInputs.returnInt();
	}
	
	public static String playerName(int number){
		System.out.println("\nPlease enter player"+number+"'s name: ");
		return UserInputs.returnString();
	}
	
	public static boolean pressToRoll() {
		System.out.println("Press Enter to roll the dice:");
		return UserInputs.returnEnter();
	}
	
	public static boolean buyProperty(){
		System.out.println("Would you like to purchase this property? y/n ");
		return UserInputs.returnString().startsWith("y");	
	}
	
	public static boolean propertyAction(){
		System.out.println("Would you like to perform a property action? y/n ");
		return UserInputs.returnString().startsWith("y");	
	}
	
	public static boolean buildHouse(){
		System.out.println("Would you like to build a house? y/n ");
		return UserInputs.returnString().startsWith("y");
	}
	
	public static boolean mortgageProperty(){
		System.out.println("Would you like to mortgage this property? y/n ");
		return UserInputs.returnString().startsWith("y");
	}
	
}
