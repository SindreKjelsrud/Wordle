package Objects;

public class Testing {

	public static void main(String[] args) {
		WordleGame game = new WordleGame();
		
		// Testing randomGameWord()-method
		System.out.println(game.randomGameWord());
		
		// Testing isWordLegal()-method
		String falseWord = "wordle";
		String correctWord = "feste";
		System.out.println("'wordle' is " + game.isWordLegal(falseWord) 
						   + ", and 'feste' is " + game.isWordLegal(correctWord));
	
		
	}

}
