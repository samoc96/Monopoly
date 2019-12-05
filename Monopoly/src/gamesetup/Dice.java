package gamesetup;

import codingtools.DisplayMessages;
import codingtools.UserPrompts;
/**
 * 
 * @author SamOConnor<p>
 *Class to roll dice.
 */
public class Dice {
    public int die1;   
    public int die2;   
     /**
      * Roll dice when enter button pressed and display the number rolled.<p>
      */
    public void roll() {
        if(UserPrompts.pressToRoll()) {
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            DisplayMessages.rolledMessage(die1+die2);		
            }
        } 
    } 

