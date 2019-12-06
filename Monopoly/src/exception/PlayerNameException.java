package exception;
/**
 * 
 * @author SamOConnor
 *<p>Exception to handle incorrect inputs when setting the player's name.
 */
public class PlayerNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PlayerNameException() {
		super("The input was not of type String.\nPlease enter a string for the player's name!\n");
	}
}
