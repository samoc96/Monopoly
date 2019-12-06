package exception;
/**
 * 
 * @author SamOConnor
 *<p>Exception to handle incorrect inputs when pressing enter to perform an action.
 */
public class PressEnterException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PressEnterException() {
		super("The input was not the enter button!\nPlease press the enter button!\n");
	}
}
