package codingtools;

public abstract class UserPrompts {
	public static int playerNumber(){
		System.out.println("Set how many players are playing: ");
		return UserInputs.returnInt();
	}
	
	public static boolean buyProperty(){
		System.out.println("Would you like to purchase this property? y/n ");
		return UserInputs.returnString().startsWith("y");
			
	}
	
	public static void locationMessage(String location){
		System.out.println("You have landed on:"+location);
	}
}
