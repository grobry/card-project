import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
	
	ArrayList<Card>deck = new ArrayList<>();
	
	public ArrayList<Card> createDeck() {
		
	deck.add(new Card("Ace", "Hearts"));
	deck.add(new Card("Two", "Hearts"));
	deck.add(new Card("Three", "Hearts"));
	deck.add(new Card("Four", "Hearts"));
	deck.add(new Card("Five", "Hearts"));
	deck.add(new Card("Six", "Hearts"));
	deck.add(new Card("Seven", "Hearts"));
	deck.add(new Card("Eight", "Hearts"));
	deck.add(new Card("Nine", "Hearts"));
	deck.add(new Card("Ten", "Hearts"));
	deck.add(new Card("Jack", "Hearts"));
	deck.add(new Card("Queen", "Hearts"));
	deck.add(new Card("King", "Hearts"));
	deck.add(new Card("Ace", "Spades"));
	deck.add(new Card("Two", "Spades"));
	deck.add(new Card("Three", "Spades"));
	deck.add(new Card("Four", "Spades"));
	deck.add(new Card("Five", "Spades"));
	deck.add(new Card("Six", "Spades"));
	deck.add(new Card("Seven", "Spades"));
	deck.add(new Card("Eight", "Spades"));
	deck.add(new Card("Nine", "Spades"));
	deck.add(new Card("Ten", "Spades"));
	deck.add(new Card("Jack", "Spades"));
	deck.add(new Card("Queen", "Spades"));
	deck.add(new Card("King", "Spades"));
	deck.add(new Card("Ace", "Clubs"));
	deck.add(new Card("Two", "Clubs"));
	deck.add(new Card("Three", "Clubs"));
	deck.add(new Card("Four", "Clubs"));
	deck.add(new Card("Five", "Clubs"));
	deck.add(new Card("Six", "Clubs"));
	deck.add(new Card("Seven", "Clubs"));
	deck.add(new Card("Eight", "Clubs"));
	deck.add(new Card("Nine", "Clubs"));
	deck.add(new Card("Ten", "Clubs"));
	deck.add(new Card("Jack", "Clubs"));
	deck.add(new Card("Queen", "Clubs"));
	deck.add(new Card("King", "Clubs"));
	deck.add(new Card("Ace", "Diamonds"));
	deck.add(new Card("Two", "Diamonds"));
	deck.add(new Card("Three", "Diamonds"));
	deck.add(new Card("Four", "Diamonds"));
	deck.add(new Card("Five", "Diamonds"));
	deck.add(new Card("Six", "Diamonds"));
	deck.add(new Card("Seven", "Diamonds"));
	deck.add(new Card("Eight", "Diamonds"));
	deck.add(new Card("Nine", "Diamonds"));
	deck.add(new Card("Ten", "Diamonds"));
	deck.add(new Card("Jack", "Diamonds"));
	deck.add(new Card("Queen", "Diamonds"));
	deck.add(new Card("King", "Diamonds"));
	return deck;
	}
	
	public int setNumber(Card thiscard) {
		String rank = thiscard.getRank();
		if(rank == "Ace") {
			return 1;
		}
		if(rank == "Two") {
			return 2;
		}
		if(rank == "Three") {
			return 3;
		}
		if(rank == "Four") {
			return 4;
		}
		if(rank == "Five") {
			return 5;
		}
		if(rank == "Six") {
			return 6;
		}
		if(rank == "Seven") {
			return 7;
		}
		if(rank == "Eight") {
			return 8;
		}
		if(rank == "Nine") {
			return 9;
		}
		if(rank == "Ten") {
			return 10;
		}
		if(rank == "Jack") {
			return 11;
		}
		if(rank == "Queen") {
			return 12;
		}
		if(rank == "King") {
			return 13;
		}
		else{
			return 0;
		}
	}
	
	public boolean isEmpty() {
		return deck.size() == 0;
	}
	public ArrayList<Card> shuffleDeck() {
		if(deck.isEmpty()) {
			createDeck();
		}
		Collections.shuffle(deck);
		return deck;
	}
	
	public void checkTop(){
		if(deck.isEmpty()) {
			createDeck();
		}
		Card printThis = deck.get(deck.size() - 1);
		System.out.println(printThis.getCard() + "\n");
		deck.remove(deck.size() - 1);
	}
	
	public ArrayList<Card> createDeckA(){
		ArrayList<Card> deckA = new ArrayList<>();
		List<Card> tempDeck = deck.subList(0, 15);
		deckA.addAll(tempDeck);
		return deckA;
	}
	public ArrayList<Card> createDeckB(){
		ArrayList<Card> deckB = new ArrayList<>();
		List<Card> tempDeck = deck.subList(16, 31);
		deckB.addAll(tempDeck);
		return deckB;
	}
   public void printDeck(ArrayList<Card> thisDeck) {
	   int k = thisDeck.size() - 1;
	   for (int i = 0; i <= k; i++) {
		   int j = i + 1;
		   Card printThis = thisDeck.get(i);
		   System.out.print(j + ". " + printThis.getCard() + "\n");
	   }
	   System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n~Scroll up to view deck. When finished, scroll down to hide hand~.\n");
   }
	   public void seeDeck() {
		   if(deck.isEmpty()) {
				createDeck();
			}
		   System.out.println("This deck holds " + deck.size() + " cards\n");
		   shuffleDeck();
		   System.out.println("Set for Player One: \n");
		   ArrayList<Card> deckA = createDeckA();
		   printDeck(deckA);
		   System.out.println("\nSet for Player Two: \n");
		   ArrayList<Card> deckB = createDeckB();
		   printDeck(deckB);
	   }
}
