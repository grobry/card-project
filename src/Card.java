
public class Card extends Cards{
	String suite;
	String rank;
	
	public Card(String rank, String suite) {
		this.suite = suite;
		this.rank = rank;
	}
	
	public String getCard() {
		return rank + " of " + suite; 
	}
	public String getSuite() {
		return suite;
	}
	
	public String getRank() {
		return rank;
	}
	
  }
