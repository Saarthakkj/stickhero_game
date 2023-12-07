package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneController {
	@FXML
	private Stage stage1;
	private Stage stage2;
	@FXML
	private static Pane easy_gamepane ;
	private Stage stage_easy;
	@FXML
	private Stage stage_end;
	
	private Scene scene;
	private Parent root;
	
	public static Pane geteasy_gamepane(){
		return easy_gamepane;
	}
	
	public void switchTofirst_scrn(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("first_scrn.fxml"));
		stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage1.setScene(scene);
		stage1.show();

	}
	
	

	public void switchTosecond_scrn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("second_scrn.fxml"));
		stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage2.setScene(scene);
		stage2.show();
	}
	
	
	//before error :
//	public void switchToeasy_gameplay(ActionEvent event) throws IOException {
//		Parent root = FXMLLoader.load(getClass().getResource("easy_gameplay.fxml"));
//		Scene scene = new Scene(root);
//		
//		easy_gamepane = (Pane) scene.lookup("#easy_gamepane");
//        EasyPlatform easyPlatform = new EasyPlatform(easy_gamepane);
//        
//        
//        
//		stage_easy = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage_easy.setScene(scene);
//		stage_easy.show();
//		
//	}
	
	
	public void switchToeasy_gameplay(ActionEvent event) throws IOException {
	    // Load the FXML file
	    Parent root = FXMLLoader.load(getClass().getResource("easy_gameplay.fxml"));

	    // Create a new AnchorPane for each scene
	    AnchorPane easyGamePane = new AnchorPane();
	    easyGamePane.getChildren().add(root);

	    // Create the scene with the new AnchorPane
	    Scene scene = new Scene(easyGamePane);

	    // Pass the easyGamePane to EasyPlatform for further modifications
	    EasyPlatform easyPlatform = new EasyPlatform(easyGamePane);

	    // Set the scene to the stage
	    Stage stage_easy = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage_easy.setScene(scene);
	    stage_easy.show();
	}

	
	
	public void switchToEndgame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		stage_end= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage_end.setScene(scene);
		stage_end.show();
	}
	
}
