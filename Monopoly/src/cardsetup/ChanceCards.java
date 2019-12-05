package cardsetup;
/**
 * 
 * @author SamOConnor<p>
 * Class to define the Chance Cards.
 *
 */
public class ChanceCards {
	
		CardDef chance1 = new CardDef("Advance to \"Go\"\n", CardType.MOVE_TO, 0, 0);
		CardDef chance2 = new CardDef("Advance to Illinois Ave. {Avenue}. If you pass Go, collect $200.\n", CardType.MOVE_TO, 24, 0);
		CardDef chance3 = new CardDef("Advance to St. Charles Place. If you pass Go, collect $200.\n", CardType.MOVE_TO, 11, 0);
		CardDef chance4 = new CardDef("Advance token to nearest Utility. If unowned, you may buy it from the Bank.\nIf owned, throw dice and pay owner a total 10 times the amount thrown.\n", CardType.MOVE_UTIL, 0, 0);
		CardDef chance5 = new CardDef("Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled.\nIf Railroad is unowned, you may buy it from the Bank\n", CardType.MOVE_RR, 0, 0);
		CardDef chance6 = new CardDef("Bank pays you dividend of $50.\n", CardType.RECEIVE, 50, 0);
		CardDef chance7 = new CardDef("Get out of Jail Free. This card may be kept until needed, or traded/sold.\n", CardType.GOJ, 0, 0);
		CardDef chance8 = new CardDef("Go Back Three {3} Spaces.", CardType.MOVE, -3, 0);
		CardDef chance9 = new CardDef("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.\n", CardType.GTJ, 10, 0);
		CardDef chance10 = new CardDef("Make general repairs on all your property: For each house pay $25, For each hotel {pay} $100.\n", CardType.PAY_PER_HH, 25, 100);
		CardDef chance11 = new CardDef("Pay poor tax of $15\n", CardType.PAY, 15, 0);
		CardDef chance12 = new CardDef("Take a trip to Reading Railroad.\n", CardType.MOVE_TO, 5, 0);
		CardDef chance13 = new CardDef("Take a walk on the Boardwalk. Advance token to Boardwalk.\n", CardType.MOVE_TO, 39, 0);
		CardDef chance14 = new CardDef("You have been elected Chairman of the Board. Pay each player $50.\n", CardType.PAY_ALL, 50, 0);
		CardDef chance15 = new CardDef("Your building {and} loan matures. Receive {Collect} $150.\n", CardType.RECEIVE, 150, 0);
		CardDef chance16 = new CardDef("You have won a crossword competition. Collect $100.\n", CardType.RECEIVE, 100, 0);
}
