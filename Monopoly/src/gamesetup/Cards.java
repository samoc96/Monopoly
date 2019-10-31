package gamesetup;

import java.util.ArrayList;

public class Cards {

	private ArrayList<String> cards;

	public Cards(ArrayList<String> cards) {
		this.setCards(cards);
	}

	public ArrayList<String> getCards() {
		return cards;
	}

	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}

	public ArrayList<String> addCard(ArrayList<String> cards, String title) {
		cards.add(title);
		return cards;
	}

}
