package gamesetup;

import codingtools.DisplayMessages;
import codingtools.UserPrompts;

public class Dice {
    public int die1;   // Number showing on the first die.
    public int die2;   // Number showing on the second die.
     
    public void roll() {
        if(UserPrompts.pressToRoll()) {
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            DisplayMessages.rolledMessage(die1+die2);		
    	}
    }
    
} // end class PairOfDice

