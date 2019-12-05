package codingtools;

import playersetup.Player;
import propertysetup.Properties;
/**
 * 
 * @author SamOConnor
 *<p>Class to display various messages.
 */
public class DisplayMessages {
	
	public static void displayBreak() {
		System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n");
	}
	
	public static void usedJailCard() {
		System.out.print("You have used your Get Out of Jail Free card!\nYou are now free from jail proceed with your turn!\n");
	}
	
	public static void rollDoubleJail() {
		System.out.print("Try roll a double to leave!\n");
	}
	
	public static void doubleRolled() {
		System.out.print("You have rolled a double! Go again!\n");
	}
	
	public static void jailMessage() {
		System.out.print("You are in Jail!\n");
	}
	
	public static void doublePayJailFine() {
		System.out.print("You have failed to roll a double in your last 3 goes!\nYou must now pay the $50 fine!\nYou are now free from jail proceed with your turn!\n");
	}
	
	public static void payJailFine() {
		System.out.print("You have paid the $50 Jail fine!\nYou are now free from jail proceed with your turn!\n");
	}
	
	public static void doubleRolledJail() {
		System.out.print("You have rolled a double!\nYou are now free from jail proceed with your turn!\n");
	}
	
	public static void noDoubleRolledJail() {
		System.out.print("You have failed to roll a double!\nTry again next Turn!\n");
	}
	
	public static void houseBought() {
		System.out.print("You built a new house congrats!\n");
	}
	
	public static void doubleGoToJailMessage() {
		System.out.print("You have rolled 3 doubles in a row!\nNow you must go to jail!\n");
	}
	
	public static void pastGo() {
		System.out.println("You have passed GO! Collect $200\n");
	}
	
	public static void bankruptWarningMessage() {
		System.out.print("Your money has dropped below $0!\nYou must now mortgage your property or face going bankrupt!\n");
	}
	

	public static void bankruptMessage() {
		System.out.print("You are officially bankrupt!\nYou are now out of the game :(\n");
	}
	
	public static void welcomeMessage() {
		System.out.println("Welcome to Monopoly!\n");
	}
	/**
	 * Displays the property that has been mortgaged and the amount received by the player.
	 * @param properties
	 */
	public static void mortgageProp(Properties properties) {
		System.out.print("The following property has been mortgaged:\n"+properties.getName()+"\n");
		System.out.print("You will recieve: $"+properties.getMortgage()/2+"\n");
	}
	/**
	 * Displays the plater's bank.
	 * @param player
	 */
	public static void playersBank(Player player){
		System.out.println(player.getName()+"------------ Bank Account = $"+player.getMoney()+"\n");
	}
	/**
	 * Displays the player's properties.
	 * @param player
	 */
	public static void playersProperties(Player player){
		System.out.println(player.getName()+" has the following current properties:\n");
		int assetValue = 0;
		for(int i=0; i < player.getNumOfProps(); i++) {
			System.out.println(player.getProperties().get(i).getName()+"\n");
			assetValue += player.getProperties().get(i).getPrice();
		}
		System.out.println("Total Value of assets: $"+assetValue+"\n");
	}
	/**
	 * Displays which players turn it is.
	 * @param player
	 */
	public static void playersTurn(Player player){
		System.out.println("It's " +player.getName()+" turn to roll the dice!\n");
	}
	/**
	 * Displays the player's position.
	 * @param player
	 */
	public static void playersPosition(Player player){
		
		System.out.println("Your current position is: " +player.getPosition());
		
	}
	
	public static void locationMessage(String location){
		System.out.println("You have landed on:"+location);
	}
	
	public static void rolledMessage(int rolled){
		System.out.println("You have rolled:" +rolled);
	}
	
	public static void rentMessage(String owner, int rentPrice){
		System.out.println("You have landed on "+owner+" property:");
		System.out.println("You must now pay: $"+rentPrice);
	}
	
	public static void taxMessage(int tax){
		System.out.println("You must now pay: $"+tax);
	}
	
	public static void cardMessage(String message){
		System.out.println("\n"+message);
	}
	
	public static void boughtProperty(Properties properties) {
		System.out.print("Congrats! You have bought the property: "+properties.getName()+"\nThis cost you a total of: $"+properties.getPrice()+"\n");
	}
	
}
