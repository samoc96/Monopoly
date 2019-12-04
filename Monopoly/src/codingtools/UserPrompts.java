package codingtools;

import java.util.InputMismatchException;

public class UserPrompts {
	
	public static int playerNumber(){
		int playerNumber;
		while(true) {
			System.out.println("Set how many players are playing (2-6): ");
			try {
				playerNumber = UserInputs.returnInt();
				if(playerNumber>1 && playerNumber<=6) {
					break;
				}
				else {
					System.out.print("You must enter an integer value between 2-6!\n");
				}
			} 
			catch(InputMismatchException e){
				System.out.print("You must enter an integer value between 2-6!\n");
			}
		}
		return playerNumber;
	}
	
	public static String playerName(int number){
		String playerName;
		while(true) {
			System.out.println("\nPlease enter player"+number+"'s name: ");
			try {
				playerName = UserInputs.returnString();
				if(playerName.matches("[a-zA-Z]+")){
					break;	
				}
				else {
					System.out.print("Please enter a string for the player's name!\n");
				}
			}
			
			catch(InputMismatchException e){
				System.out.print("Please enter a string for the player's name!\n");
			}
		}
		return playerName;
	}
	
	public static boolean pressToRoll() {
		
		boolean pressedEnter;
		String userPressed;
		while(true) {
			System.out.print("Press Enter to Roll the dice!");
			try {
				userPressed = UserInputs.returnString();
				pressedEnter = UserInputs.returnEnter();
				if(pressedEnter && userPressed.isEmpty()){
					break;	
				}
				else {
					System.out.print("Please press the enter button!\n");
				}
			}
			
			catch(InputMismatchException e){
				System.out.print("Please press the enter button!\n");
			}
		}
		return pressedEnter;
	
	}
	
	public static boolean buyProperty(){
		return yesNo("Would you like to purchase this property? y/n ");
	}
	
	public static boolean useJailCard(){
		return yesNo("Would you like to use your Get Out of Jail Free card? y/n ");
	}
	
	public static boolean payJailFine(){
		return yesNo("Would you like to pay a $50 fine to leave Jail? y/n ");
	}
	
	public static boolean viewProperties(){
		return yesNo("Would you like to view your properties? y/n ");
	}
	
	public static boolean propertyAction(){
		return yesNo("Would you like to perform a property action? y/n ");
	}
	
	public static boolean buildHouse(){
		return yesNo("Would you like to build a house? y/n ");	 
	}
	
	public static boolean mortgageProperty(){
		return yesNo("Would you like to mortgage this property? y/n ");	 
	}
	
	public static boolean yesNo(String message) {
		boolean yesNo;
		String entered;
		while(true) {
			System.out.println(message);
			try {
				entered = UserInputs.returnString();
				if(entered.toUpperCase().startsWith("y".toUpperCase())) {
					yesNo = true;
					break;
				}
				else if(entered.toUpperCase().startsWith("n".toUpperCase())) {
					yesNo = false;
					break;
				}
				else {
					System.out.print("You must enter either y or n!\n");
				}
			}
			catch(InputMismatchException e){
				System.out.print("You must enter either y or n!\n");
			}
		}
		return yesNo;
	}
	
	
}
