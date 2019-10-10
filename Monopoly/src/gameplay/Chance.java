package gameplay;

import java.util.ArrayList;

public class Chance extends CardDefinition {

	public CardDefinition carddefinition;

	public Chance(ArrayList<String> cards) {
		super(cards);
	}

	public ArrayList<String> addChanceCard(ArrayList<String> chanceCards) {

		carddefinition.addCard(chanceCards, "Advance to \"Go\"");
		carddefinition.addCard(chanceCards, "Advance to Illinois Ave. {Avenue}. If you pass Go, collect $200.");
		carddefinition.addCard(chanceCards, "Advance to St. Charles Place. If you pass Go, collect $200.");
		carddefinition.addCard(chanceCards,
				"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total 10 times the amount thrown.");
		carddefinition.addCard(chanceCards,
				"Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank");
		carddefinition.addCard(chanceCards, "Bank pays you dividend of $50.");
		carddefinition.addCard(chanceCards,
				"Get out of Jail Free. This card may be kept until needed, or traded/sold.");
		carddefinition.addCard(chanceCards, "Go Back Three {3} Spaces.");
		carddefinition.addCard(chanceCards, "Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.");
		carddefinition.addCard(chanceCards,
				"Make general repairs on all your property: For each house pay $25, For each hotel {pay} $100.");
		carddefinition.addCard(chanceCards, "Pay poor tax of $15");
		carddefinition.addCard(chanceCards, "Take a trip to Reading Railroad. ");
		carddefinition.addCard(chanceCards, "Take a walk on the Boardwalk. Advance token to Boardwalk.");
		carddefinition.addCard(chanceCards, "You have been elected Chairman of the Board. Pay each player $50. ");
		carddefinition.addCard(chanceCards, "Your building {and} loan matures. Receive {Collect} $150. ");
		carddefinition.addCard(chanceCards, "You have won a crossword competition. Collect $100.");

		return chanceCards;
	}

}
