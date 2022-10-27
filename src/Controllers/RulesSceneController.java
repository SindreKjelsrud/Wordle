package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RulesSceneController {

	// Event Listener on Button.onAction
	@FXML
	public void btnMenuClicked(ActionEvent event) throws IOException {
		Parent rulesSceneParent = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
		Scene rulesScene = new Scene(rulesSceneParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Sids Wordle");
		window.setScene(rulesScene);
		window.show();
	}
}
