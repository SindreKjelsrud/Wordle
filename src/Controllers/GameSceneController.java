package Controllers;

import java.io.IOException;

import Objects.WordleGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameSceneController {
	
	private WordleGame game = new WordleGame();
	private int[] correctChars;
	private Label one, two, three, four, five; 	// Labels for words and colorchanging
	
	// @FXML variables
	@FXML
	private Label lb1, lb2, lb3, lb4, lb5, 
				  lb6, lb7, lb8, lb9, lb10,
				  lb11, lb12, lb13, lb14, lb15,
				  lb16, lb17, lb18, lb19, lb20,
				  lb21, lb22, lb23, lb24, lb25;	
	
	@FXML
	private TextField userInput;
	
	@FXML
	private Button goBtn;
	
	@FXML
	private Button resetBtn;
	
	@FXML
	private Label endgame;

	
	// Event Listener on Button.onAction
	/*
	 * Checks and outputs if users guessed word is
	 * legal or not, and will show result of each
	 * guess to user.
	 * Includes also a winning and losing screen. ****
	 */
	@FXML
	public void btnGoClicked(ActionEvent event) {
		String userGuess = userInput.getText().toLowerCase();
		game.setCurrentGuess(userGuess);
		setRows();
		
		// Checks if userGuess is legal or not
		if (game.isWordLegal(userGuess)) {
			userGuess = userGuess.toUpperCase();
			char[] letters = userGuess.toCharArray();
			
			// Letters to labels
			one.setText("" + letters[0] + "");
			two.setText("" + letters[1] + "");
			three.setText("" + letters[2] + "");
			four.setText("" + letters[3] + "");
			five.setText("" + letters[4] + "");
			
			// Colorchange
			correctChars = game.charChecker();
			
			colorChanger(correctChars[0], one);
			colorChanger(correctChars[1], two);
			colorChanger(correctChars[2], three);
			colorChanger(correctChars[3], four);
			colorChanger(correctChars[4], five);
			
			game.nextRow();
		} else {
			userInput.setPromptText("Not a legal word!");
		}
		
		// if game.correctWord
		if (game.correctWord()) {
			endgame.setText("YOU WON!");
			endgame.setTextFill(Color.GREEN);
		}
		
		// if getCurrentRow < 5 - you lost new game x setup
		if (game.getCurrentRow() > 5) {			
			endgame.setText("YOU LOST!");
			endgame.setTextFill(Color.RED);
		}
		
		// Clears inputfield for next guess
		userInput.setText("");
	}
	
	// Event Listener on Button.onAction
	/*
	 * Resets userinput field and all labels
	 */
		@FXML
		public void btnResetClicked(ActionEvent event) {
			userInput.setPromptText("Write a word here!");
			newGameSetup();
		}
		
	// Event Listener on Button.onAction
		/*
		 * Goes back to menu when logo is clicked
		 */
	@FXML
	public void btnMenuClicked(ActionEvent event) throws IOException {
		Parent menuSceneParent = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
		Scene menuScene = new Scene(menuSceneParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Sids Wordle");
		window.setScene(menuScene);
		window.show();
	}
	
	/*
	 * Fixes setup for each row in the game
	 */
	private void setRows() {
		switch(game.getCurrentRow()) {
		case 1:
			one = lb1;
			two = lb2;
			three = lb3;
			four = lb4;
			five = lb5;
			break;
		case 2:
			one = lb6;
			two = lb7;
			three = lb8;
			four = lb9;
			five = lb10;
			break;
		case 3:
			one = lb11;
			two = lb12;
			three = lb13;
			four = lb14;
			five = lb15;
			break;
		case 4:
			one = lb16;
			two = lb17;
			three = lb18;
			four = lb19;
			five = lb20;
			break;
		case 5:
			one = lb21;
			two = lb22;
			three = lb23;
			four = lb24;
			five = lb25;
			break;
		}
	}
	
	/*
	 *  Fixes setup for a new game, and resets 
	 *  both color and text for all labels
	 */
	private void newGameSetup() {
		game = new WordleGame();
		endgame.setText("");
		Label[] labels = {
						  lb1, lb2, lb3, lb4, lb5, 
						  lb6, lb7, lb8, lb9, lb10,
						  lb11, lb12, lb13, lb14, lb15,
						  lb16, lb17, lb18, lb19, lb20,
						  lb21, lb22, lb23, lb24, lb25
						 };
		
		for (int i = 0; i < labels.length; i++) {
			labels[i].setText("");
			labels[i].setStyle("-fx-background-color: lightgrey;");
		}
	}
	
	/*
	 * Changes colors of labels to show user
	 * which letters of current guess are:
	 * 	0) wrong (not in gameword)
	 * 	1) correct, but in wrong place
	 * 	2) correct and in right place
	 * 
	 * @param x -> each case mentioned over^
	 * @param y -> which label to change background on
	 */
	private void colorChanger(int x, Label y) {
		switch(x) {
		case 0:
			y.setStyle("-fx-background-color: lightgrey;");
			break;
		case 1:
			y.setStyle("-fx-background-color: yellow;");
			break;
		case 2:
			y.setStyle("-fx-background-color: green;");
			break;
		}
	}
}
