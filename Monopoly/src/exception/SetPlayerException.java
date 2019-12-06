package exception;
/**
 * 
 * @author SamOConnor
 *<p>Exception to handle incorrect inputs when setting how many players are playing.
 */
public class SetPlayerException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SetPlayerException() {
		super("The value entered is not an integer between 2-6!\nPlease try again!\n");
	}
}
