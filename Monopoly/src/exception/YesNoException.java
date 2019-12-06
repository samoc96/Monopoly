package exception;
/**
 * 
 * @author SamOConnor
 *<p>Exception to handle incorrect inputs when selecting yes or no for various actions.
 */
public class YesNoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public YesNoException() {
		super("The input was not either y or n!\nYou must enter either y or n!\n");
	}
}
