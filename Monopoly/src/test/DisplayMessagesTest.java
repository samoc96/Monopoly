package test;

import org.junit.Test;

import codingtools.DisplayMessages;
import playersetup.Player;
/**
 * 
 * @author SamOConnor<p>
 * Class to test the DisplayMessages class.
 *
 */
public class DisplayMessagesTest {
	Player player = new Player("Tester");
	@Test
	public void testDisplays() {
		DisplayMessages.bankruptMessage();
		DisplayMessages.bankruptWarningMessage();
		DisplayMessages.displayBreak();
		DisplayMessages.doubleGoToJailMessage();
		DisplayMessages.doubleRolled();
		DisplayMessages.houseBought();
		DisplayMessages.jailMessage();
		DisplayMessages.payJailFine();
		DisplayMessages.locationMessageNonProperty("Go");
		DisplayMessages.playersBank(player);
		DisplayMessages.playersPosition(player);
		DisplayMessages.playersTurn(player);
		DisplayMessages.usedJailCard();
		DisplayMessages.welcomeMessage();
		DisplayMessages.taxMessage(200);
		DisplayMessages.rolledMessage(12);
		DisplayMessages.pastGo();
	}
}
