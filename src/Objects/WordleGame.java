package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Interfaces.WordleInterface;

public class WordleGame implements WordleInterface {
	
	private String gameWord;
	private String currentWord;
	private int currentRow;
	
	public WordleGame() {
		gameWord = randomGameWord();
		currentRow = 1;
	}

	/*
	 * Generates random word for each game
	 * taken from a .txt file in the project
	 * folder.
	 * 
	 * @return string 	containing the word of the game
	 */
	@Override
	public String randomGameWord() {
		String randomWordOfGame = "";
		
		try {
			String[] words = new String[6];
			int i = 0;
			Scanner scan = new Scanner(new File("gameWords.txt"));

			while (scan.hasNext()) {
				words[i] = scan.nextLine();
				i++;
			}
			
			int random = (int) (Math.random() * i);
			randomWordOfGame = words[random];
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return randomWordOfGame;
	}

	@Override
	public boolean isWordLegal(String word) {
		boolean legal = false;
		
		// Gets list containing legal words
		String[] wordlist = new String[26];
		try {
			int i = 0;
			Scanner scan = new Scanner(new File("legalWords.txt"));

			while (scan.hasNext()) {
				wordlist[i] = scan.nextLine();
				i++;
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Compares words in wordlist with "word" to check if word is legal¨
		for (int i = 0; wordlist[i] != null; i++) {
			if (wordlist[i].equals(word)) {
				legal = true;
			}
		}
		
		return legal;
	}

	@Override
	public boolean correctWord() {
		return currentWord.equalsIgnoreCase(gameWord);
	}

	@Override
	public int[] charChecker() {
		int[] charStatuses = new int[5];
		
		for (int i = 0; i < gameWord.length(); i++) {
			String correctWordCS = gameWord.charAt(i) + "";
			String userWordCS = currentWord.charAt(i) + "";
			
			if (correctWordCS.contentEquals(userWordCS)) {
				charStatuses[i] = 2;
			} else if (gameWord.contains(userWordCS)) {
				charStatuses[i] = 1;
			} else {
				charStatuses[i] = 0;
			}
		}
		
		return charStatuses;
	}

	@Override
	public boolean nextRow() {
		currentRow++;
		return true;
	}

	@Override
	public void setCurrentGuess(String word) {
		currentWord = word;
	}
	
	@Override
	public void setCurrentRow(int x) {
		currentRow = x;
	}

	@Override
	public String getGameWord() {
		return gameWord;
	}

	@Override
	public String getCurrentGuess() {
		return currentWord;
	}

	@Override
	public int getCurrentRow() {
		return currentRow;
	}

}
