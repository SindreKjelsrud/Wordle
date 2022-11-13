/*
 * Interface for WordleGame.
 * - Made for controlling functions in a game.
 */

package Interfaces;

public interface WordleInterface {
	
	/* Objectvariables
	 * ----------------
	 * String gameWord;
	 * String currentWord;
	 * int currentRow;
	 */
	
	/*
	 * Generates random word for each game
	 * taken from a .txt file in the project
	 * folder.
	 * 
	 * @return string 	containing the word of the game
	 */
	public String randomGameWord();
	
	/*
	 * Takes input from user and checks
	 * a .txt file (containing all legal words)
	 * in the project folder, and checks if
	 * it's legal.
	 * 
	 * @param word	userinput in form of variable "currentWord"
	 * 
	 * @return true	if the word is legal
	 */
	public boolean isWordLegal(String word);
	
	/*
	 * Checks if users current input
	 * is equal to the word of the game.
	 * 
	 * @return true	if word is equal
	 */
	public boolean correctWord();
	
	/*
	 * Takes users current word into an array,
	 * and checks each char for if they are correct
	 * and in the right place (1), or if they are correct,
	 * but in the wrong place (2). Char not in word (0).
	 * 
	 * @return int[]	containing values for each char in word & their status
	 */
	public int[] charChecker();
	
	/*
	 * Keeps track of rowes with variable "currentRow"
	 * and the amount of users guesses.
	 * Will also help to reset variable "currentWord" for
	 * each guess.
	 * 
	 * @return false	if currentRow == 5 user has lost
	 */
	public boolean nextRow();
	
	/*
	 * SETTERS:
	 * - setCurrentGuess
	 * - setCurrentRow
	 */
	public void setCurrentGuess(String word);	// Sets variable "currentWord" to users latest guess
	public void setCurrentRow(int x);			// Sets variable "currentRow" to games current row
	
	/*
	 * GETTERS:
	 * - getGameWord
	 * - getCurrentGuess
	 * - getCurrentRow
	 */
	public String getGameWord();		// gets word of the game
	public String getCurrentGuess();	// gets users current guess
	public int getCurrentRow();			// gets current row
	
}