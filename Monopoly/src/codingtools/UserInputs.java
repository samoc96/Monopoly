package codingtools;

import java.util.Scanner;

public class UserInputs {
	
	private static Scanner sc1;
	private static Scanner sc2;
	private static Scanner sc3;

	public static int returnInt(){
		sc1 = new Scanner(System.in);
		return sc1.nextInt();
	}
	
	public static String returnString(){
		
		sc2 = new Scanner(System.in);
		return sc2.nextLine();
	}
	
	
	public static boolean returnEnter() {
		
		sc3 = new Scanner(System.in);
		if(sc3.hasNextLine()) {
			return true;
		}
		else {
			return false;
		}
	}
}

