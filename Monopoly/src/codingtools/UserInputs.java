package codingtools;

import java.util.Scanner;

public abstract class UserInputs {
	
	private static Scanner sc;
	private static Scanner sc2;
	private static Scanner sc3;

	public static String returnString(){
		sc2 = new Scanner(System.in);
		return sc2.nextLine();
	}
	
	public static int returnInt(){
		sc = new Scanner(System.in);
		return sc.nextInt();
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

