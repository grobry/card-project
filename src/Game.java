import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Cards{
	
	Scanner sc = new Scanner(System.in);
	
	static int Turn;
	
	static boolean Test;
	
	static Card checkCard;
	
	ArrayList<Card>deckA;
	ArrayList<Card>deckB;
	
	ArrayList<Card> disgardPile = new ArrayList<Card>();
	
	public Game() {
		Turn = 1;
	}
	
	public  void playerMain() {
		if (Turn == 1) {
			setGame();
			System.out.println("Would you like to enable test functions? Enter 1 for yes, and 2 for no.");
			int q = sc.nextInt();
			if(q == 1) {
				Test = true;
			}
			else {
				Test = false;
			}
		}
		int playerChoice = 99;
		while(playerChoice != 4)
		{
			checkEmpty();
			playerChoice = playerMenu();
			if(Test == false) {
			switch(playerChoice) 
			{
				case 1: viewDeck();
				break;
				case 2: getCard();
				break;
				case 3: callBS();
				break;
				case 4: exit();
				break;
					}
			}
			if(Test == true) {
				switch(playerChoice) 
				{
					case 1: viewDeck();
					break;
					case 2: getCard();
					break;
					case 3: callBS();
					break;
					case 4: exit();
					break;
					case 5: editTurn();
					break;
					case 6: viewPile();
					break;
					case 7: seeDeck();
					break;
					case 8: clearDeckA();
					break;
					case 9: clearDeckB();
					break;
				}
			}
		}
	}
		public int playerMenu() {	
			int playerChoice = 99;
			System.out.println("\n\n\n\n\n\t\tPlayer " + getPlayer() + "'s Menu: Turn " + Turn);
			System.out.println("------------------------------------------------------");
			System.out.println("\n\t\t    1. View Deck\n" +
							   "\t\t    2. Present Card\n"+
				               "\t\t    3. Call ''BS''\n"+
							   "\t\t    4. End game\n"  
				               );
			if(Test == true) {
				System.out.print("\t\tTest Functions:\n" +
								    "\n\t\t    5. Edit turn\n"+
						           "\t\t    6. View disgard pile\n"+
								    "\t\t    7. View both decks\n" +
						            "\t\t    8. Clear deck A\n" +
								    "\t\t    9. Clear deck B\n"
						   );
			}
			System.out.println("------------------------------------------------------");
			System.out.println("Enter a choice: ");
			System.out.println(); 
			playerChoice = sc.nextInt();
				return playerChoice;
		}
		
	public void setGame() {
		if(deck.isEmpty()) {
			createDeck();
		}
	   shuffleDeck();
	   deckA = createDeckA();
	   deckB = createDeckB();
   }
	
	public String getPlayer() {
		if (Turn % 2 == 0) {
			return "B";
		}
		else {
			return "A";
		}
	}
	
	public ArrayList<Card> sendPlayer(){
		String whichPlayer = getPlayer();
		if (whichPlayer == "A") {
			return deckA;
		}
		else{
			return deckB;
		}
	}
	
	public ArrayList<Card> setDeck(ArrayList<Card> thisDeck){
		String whichPlayer = getPlayer();
		if (whichPlayer == "A") {
			deckA = thisDeck;
			return deckA;
		}
		else{
			deckB = thisDeck;
			return deckB;
		}
	}
	
	public void viewDeck() {
		System.out.println("\nPlayer "+ getPlayer() + "'s deck:\n");
		ArrayList<Card> thisDeck = sendPlayer();
		printDeck(thisDeck);
	}
	
	public void getCard() {
		ArrayList<Card> thisDeck = sendPlayer();
		viewDeck();
		System.out.println("\n\n\n\n\n\n\n\n\nPlease input the number of the card you would like to play.\n\n\n");
		int c = 99;
		c = sc.nextInt();
		int d = c - 1;
		
		Card cardAt = thisDeck.get(d);
		String cardString = cardAt.getCard();
		System.out.println("\nNow playing " + cardString +  "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n~Scroll up to check card. When finished, scroll down to hide last play~\n\n\n ");
		
		disgardPile.add(cardAt);
		thisDeck.remove(cardAt);
		checkCard = cardAt;
		setDeck(thisDeck);
		
		Turn++;
		
		   }
	public int turnConv() {
		int turnCon = Turn % 13;
		return turnCon;
	}
	
	public ArrayList<Card> callBS (){
		if (Turn == 1) {
			System.out.println("Can't call BS on Turn 1 :(\n");
			return deckA;
			}
		else {
		System.out.println("\nCalling BS on the last card played...\n");
		String whichPlayer = getPlayer();
		int thisTurn = turnConv() - 1;
		int thisCard = setNumber(checkCard);
			if (whichPlayer == "A"){
				if (thisCard == thisTurn){
					System.out.println("Player B was NOT lying, Player A takes the deck.\n");
					deckA.addAll(disgardPile);
					disgardPile.clear();
					Turn++;
					return deckA;
				}
				else{
					System.out.println("Player B was lying, Player B takes the deck.\n");
					deckB.addAll(disgardPile);
					disgardPile.clear();
					Turn++;
					return deckB;
				}
			}
			else{
				if(thisCard == thisTurn){
					System.out.println("Player A was NOT lying, Player B takes the deck.\n");
					deckB.addAll(disgardPile);
					disgardPile.clear();
					Turn++;
					return deckB;
				}
				else{
					System.out.println("Player A was lying, Player A takes the deck.\n");
					deckA.addAll(disgardPile);
					disgardPile.clear();
					Turn++;
					return deckA;
				}
			}
		}
	}
	public void checkEmpty() {
		if (deckA.size() == 0){
			System.out.println("Player A wins!\n");
			exit();
		}
		if (deckA.size() == 0) {
			System.out.println("Player B wins!\n");
			exit();
		}
	}
	
	public void exit(){
		System.out.println("Game has been reset\n");
		reset();
		setGame();
	}
	public void reset() {
		Turn = 1;
		deckA.clear();
		deckB.clear();
		deck.clear();
		disgardPile.clear();
		Test = false;
	}
	public void editTurn() {
		System.out.println("Please input a turn: ");
		Turn = sc.nextInt();
		int coord = Turn % 13;
		System.out.println("This turn matches with turn: " + coord);
	}
	
	public void viewPile() {
		printDeck(disgardPile);
	}
	public void clearDeckA() {
		deckA.clear();
	}
	public void clearDeckB() {
		deckB.clear();
	}
	public void rules() {
		System.out.println("\n\tThis game is a shedding card game that is played by two players."
				+ "\nEach player will recieve a deck of 15 shuffled cards and will try to empty "
				+ "\ntheir hand before than their opponent. During each turn, a player is asked"
				+ "\nto submit a card that has a number coordinating to the current turn (ie: "
				+ "\nan ace of hearts during turn one, or a queen of spades on turn 12). However, a player"
				+ "\nis able to lie their way out of this and place a card that does not coordinate"
				+ "\n(ie: a two of clubs on turn 5). If a player suspects that the other player is "
				+ "\nbeing untruthful, they are able to call ''BS'' on the last card played. If the "
				+ "\nlast card played did not coordinate, then the player who drew it must inherit the"
				+ "\nentire pile of disgarded cards onto their deck. If it did, then the player who"
				+ "\naccused the other inherits the stack instead. Once either player is out of cards or"
				+ "\nforfeits, the game ends"
				+"\n\n\tAdditionally, once all turns have passed that coordinate to each card rank"
				+"\n(when the turns surpass the rank of ''King'' or 13) the turns then relate to"
				+ "\nthe next set of 13 numbers (ie: an ace is now to be expected on turn 14, and a "
				+ "\nthree on turn 15)");
		
	}
}
		
