package codingtools;

import playersetup.Player;

public abstract class UserPrompts {
	
	public static void pastGo() {
		System.out.println("You have passed GO! Collect $200\n");
	}
	
	public static int playerNumber(){
		System.out.println("Set how many players are playing (1-6): ");
		return UserInputs.returnInt();
	}
	
	public static String playerName(int number){
		System.out.println("\nPlease enter player"+number+"'s name: ");
		return UserInputs.returnString();
	}
	
	public static void welcomeMessage() {
		System.out.println("Welcome to Monopoly!");
	}
	
	public static void playersBank(Player player){
		System.out.println(player.getName()+"------------ Bank Account = $"+player.getMoney()+"\n");
	}
	
	public static void playersProperties(Player player){
		System.out.println(player.getName()+" has the following current properties:\n");
		int assetValue = 0;
		for(int i=0; i < player.getNumOfProps(); i++) {
			System.out.println(player.getProperties().get(i).getName()+"\n");
			assetValue += player.getProperties().get(i).getPrice();
		}
		System.out.println("Total Value of assets: $"+assetValue+"\n");
	}
	
	public static void playersTurn(Player player){
		System.out.println("It's " +player.getName()+" turn to roll the dice\n");
	}
	
	public static boolean pressToRoll() {
		System.out.println("Press Enter to roll the dice:");
		return UserInputs.returnEnter();
	}
	
	public static void playersPosition(Player player){
		
		System.out.println("\nYour current position is: " +player.getPosition());
		
	}
	//public static Token playerToken(){
		//System.out.println("Please enter players token, you may choose from: ");
		//return UserInputs.returnString();
	//}
	
	public static boolean buyProperty(){
		System.out.println("Would you like to purchase this property? y/n ");
		return UserInputs.returnString().startsWith("y");	
	}
	
	public static void locationMessage(String location){
		System.out.println("You have landed on:"+location);
	}
	
	public static void rolledMessage(int rolled){
		System.out.println("You have rolled:" +rolled+"\n");
	}
	
	public static void rentMessage(String owner, int rentPrice){
		System.out.println("You have landed on "+owner+" property:");
		System.out.println("You must now pay:"+rentPrice);
	}
	
	public static void taxMessage(int tax){
		System.out.println("You must now pay: "+tax);
	}
	
	public static boolean buildHouse(){
		System.out.println("Would you like to build a house? y/n ");
		return UserInputs.returnString().startsWith("y");
	}
	
	public static boolean mortgageProperty(){
		System.out.println("Would you like to mortgage this property? y/n ");
		return UserInputs.returnString().startsWith("y");
	}
	
	public static void cardMessage(String message){
		System.out.println("\n"+message);
	}
}
