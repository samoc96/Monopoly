package codingtools;

import java.util.Scanner;

public abstract class UserInputs {
	
	public static String returnString(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int returnInt(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
}

