package codingtools;

import java.util.InputMismatchException;

import propertysetup.Properties;
/**
 * 
 * @author SamOConnor<p>
 *Class to prompt the user to give an input of the appropriate type.
 */
public class UserPrompts {
	/**
	 * @return
	 * The user inputed integer as long as it is between 2 and 6.
	 */
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
					throw new InputMismatchException();
				}
			} 
			catch(InputMismatchException e){
				System.out.print("Reason for failure - " + e.getMessage()+"\nPlease input an integer between 2-6!\n");
			}
		}
		return playerNumber;
	}
	/**
	 * 
	 * @param number
	 * @return
	 * The user inputed String. 
	 */
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
					throw new InputMismatchException();
				}
			}
			
			catch(InputMismatchException e){
				System.out.print("Reason for failure - " + e.getMessage()+"\nPlease enter a string for the player's name!\n");
			}
		}
		return playerName;
	}
	/**
	 * 
	 * @return
	 * True when the enter button is pressed.<p>
	 * False otherwise.
	 */
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
					throw new InputMismatchException();
				}
			}
			
			catch(InputMismatchException e){
				System.out.print("Reason for failure - " + e.getMessage()+"\nPlease press the enter button!\n");
			}
		}
		return pressedEnter;
	
	}
	/**
	 * 
	 * @param properties
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean buyProperty(Properties properties){
		return yesNo("Would you like to purchase this property for a cost of: $"+properties.getPrice()+"? y/n ");
	}
	/**
	 * 
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean useJailCard(){
		return yesNo("Would you like to use your Get Out of Jail Free card? y/n ");
	}
	/**
	 * 
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean payJailFine(){
		return yesNo("Would you like to pay a $50 fine to leave Jail? y/n ");
	}
	/**
	 * 
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean viewProperties(){
		return yesNo("Would you like to view your properties? y/n ");
	}
	/**
	 * 
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean propertyAction(){
		return yesNo("Would you like to perform a property action? y/n ");
	}
	/**
	 * 
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean buildHouse(){
		return yesNo("Would you like to build a house? y/n ");	 
	}
	/**
	 * 
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
	public static boolean mortgageProperty(){
		return yesNo("Would you like to mortgage this property? y/n ");	 
	}
	/**
	 * 
	 * @param message
	 * <p>
	 * Prints the message.<p>
	 * @return
	 * True when y is pressed.<p>
	 * False when n is pressed.
	 */
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
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e){
				System.out.print("Reason for failure - " + e.getMessage()+"\nYou must enter either y or n!\n");
			}
		}
		return yesNo;
	}
	
	
}
