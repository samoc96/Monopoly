package codingtools;

import java.util.Scanner;
/**
 * 
 * @author SamOConnor<p>
 * Class to return the user inputs.
 */
public class UserInputs {
	
	private static Scanner sc1;
	private static Scanner sc2;
	private static Scanner sc3;
	/**
	 * 
	 * @return
	 * Integer inputed by user.
	 */
	public static int returnInt(){
		sc1 = new Scanner(System.in);
		return sc1.nextInt();
	}
	/**
	 * 
	 * @return
	 * String inputed by user.
	 */
	public static String returnString(){
		
		sc2 = new Scanner(System.in);
		return sc2.nextLine();
	}
	
	/**
	 * 
	 * @return
	 * True when the enter button was inputed by user.
	 * <p>False otherwise.
	 */
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

