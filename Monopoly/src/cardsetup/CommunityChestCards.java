package cardsetup;

public class CommunityChestCards {
	
	CardDef CC1 = new CardDef("Advance to \"Go\"\n", CardType.MOVE_TO, 0, 0);
	CardDef CC2 = new CardDef("Bank error in your favor. Collect $200.\n", CardType.RECEIVE, 200, 0);
	CardDef CC3 = new CardDef("Doctor's fees. {fee} Pay $50.\n", CardType.PAY, 50, 0);
	CardDef CC4 = new CardDef("From sale of stock you get $50.\n", CardType.RECEIVE, 50, 0);
	CardDef CC5 = new CardDef("Get out of Jail Free. This card may be kept until needed, or traded/sold.\n", CardType.GOJ, 0, 0);
	CardDef CC6 = new CardDef("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.\n", CardType.GTJ, 10, 0);
	CardDef CC7 = new CardDef("Grand Opera Night. Collect $50 from every player for opening night seats.\n", CardType.RECEIVE_ALL, 50, 0);
	CardDef CC8 = new CardDef("Holiday {Xmas} Fund matures. Receive {Collect} $100.\n", CardType.RECEIVE, 100, 0);
	CardDef CC9 = new CardDef("Income tax refund. Collect $20.\n", CardType.RECEIVE, 20, 0);
	CardDef CC10 = new CardDef("Life insurance matures – Collect $100\n", CardType.RECEIVE, 100, 0);
	CardDef CC11 = new CardDef("Hospital Fees. Pay $50.\n", CardType.PAY, 50, 0);
	CardDef CC12 = new CardDef("School fees. Pay $50.\n", CardType.PAY, 50, 0);
	CardDef CC13 = new CardDef("Receive $25 consultancy fee.\n", CardType.RECEIVE, 25, 0);
	CardDef CC14 = new CardDef("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.\n", CardType.PAY_PER_HH, 40, 115);
	CardDef CC15 = new CardDef("You have won second prize in a beauty contest. Collect $10.\n", CardType.RECEIVE, 10, 0);
	CardDef CC16 = new CardDef("You inherit $100.\n", CardType.RECEIVE, 100, 0);

}
