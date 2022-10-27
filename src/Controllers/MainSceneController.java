package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSceneController {

	// Event Listener on Button.onAction
	@FXML
	public void btnPlayClicked(ActionEvent event) throws IOException {
		Parent rulesSceneParent = FXMLLoader.load(getClass().getResource("/FXML/GameScene.fxml"));
		Scene rulesScene = new Scene(rulesSceneParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Sids Wordle");
		window.setScene(rulesScene);
		window.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnRulesClicked(ActionEvent event) throws IOException {
		Parent rulesSceneParent = FXMLLoader.load(getClass().getResource("/FXML/RulesScene.fxml"));
		Scene rulesScene = new Scene(rulesSceneParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("How to Play");
		window.setScene(rulesScene);
		window.show();
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void btnCreditsClicked(ActionEvent event) throws IOException {
		Parent rulesSceneParent = FXMLLoader.load(getClass().getResource("/FXML/CreditsScene.fxml"));
		Scene rulesScene = new Scene(rulesSceneParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Credits");
		window.setScene(rulesScene);
		window.show();
	}
}
