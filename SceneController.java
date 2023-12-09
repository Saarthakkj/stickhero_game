package application;

import java.awt.*;
import java.io.IOException;

import application.Main.Stick;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SceneController {
	@FXML
	private Stage stage1;
	private Stage stage2;
	@FXML
	private static Pane easy_gamepane ;
	private Stage stage_easy;
	@FXML
	private Stage stage_end;

	@FXML
	private ImageView plyr;

	@FXML
	private Rectangle stick;


	
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
	
	
	 

	
	
	public void switchToEndgame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		stage_end= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage_end.setScene(scene);
		stage_end.show();
	}
	public void playerTransition() {
		Translate translate = new Translate();
		translate.setX(0);
		translate.setY(0);
		plyr.getTransforms().add(translate);

		Timeline timeline = new Timeline();
		KeyFrame kf = new KeyFrame(Duration.millis(0), new KeyValue(translate.xProperty(), plyr.getLayoutX()));
		KeyFrame kf2 = new KeyFrame(Duration.millis(1000), new KeyValue(translate.xProperty(), stick.getMaxX() + 2));
		timeline.getKeyFrames().addAll(kf, kf2);
		timeline.play();

	}
	public void switchToeasy_gameplay(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("easy_gameplay.fxml"));

		Pane easy_gamepane = (Pane) loader.load();

		Main main_obj = new Main();

		Stick stick = main_obj.new Stick(); // Create the stick
		EasyPlatform easyPlatform = new EasyPlatform(easy_gamepane,stick, 100); // Initialize EasyPlatform with the stick

		// Assuming you have a method named initializePlatforms in EasyPlatform class
		easyPlatform.generatePlatforms();

		Scene scene = new Scene(easy_gamepane);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}
