package application;

import java.io.IOException;

import application.Main.Plyr;
import application.Main.Stick;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
//	@FXML
//	private ImageView plyr;
	
	private Scene scene;
	private Parent root;
	
	public static Pane geteasy_gamepane()
	{
		return easy_gamepane;
	}
	
	public void switchTofirst_scrn(ActionEvent event) throws IOException 
	{
		root = FXMLLoader.load(getClass().getResource("first_scrn.fxml"));
		stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage1.setScene(scene);
		stage1.show();

	}
	
	

	public void switchTosecond_scrn(ActionEvent event) throws IOException 
	{
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
	
	
	public void switchToeasy_gameplay(ActionEvent event) throws IOException 
	{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("easy_gameplay.fxml"));
        
        Pane easy_gamepane = (Pane) loader.load();
        
        Main main_obj = new Main();
        
        Stick stick = main_obj.new Stick() ; // Create the stick        
        
        //String imageUrl = getClass().getResource("player3.png").toExternalForm();
        //Image playerImage = new Image(imageUrl);
        Image playerImage = new Image(getClass().getResourceAsStream("player5.png"));        
        Plyr plyr = main_obj.new Plyr(playerImage);
        
        EasyPlatform easyPlatform = new EasyPlatform(easy_gamepane, stick , 100 , plyr); // Initialize EasyPlatform with the stick

        Scene scene = new Scene(easy_gamepane);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        easyPlatform.initializeAnimationTimer();	
        easyPlatform.setCollision(true);
        //easyPlatform.initializePlatforms();
    }
	public void switchTomed_gameplay(ActionEvent event) throws IOException 
	{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("med_gameplay.fxml"));
        
        Pane med_gamepane = (Pane) loader.load();
        
        Main main_obj = new Main();
        
        Stick stick = main_obj.new Stick() ; // Create the stick        
        
        //String imageUrl = getClass().getResource("player3.png").toExternalForm();
        //Image playerImage = new Image(imageUrl);
        Image playerImage = new Image(getClass().getResourceAsStream("player5.png"));        
        Plyr plyr = main_obj.new Plyr(playerImage);
        
        MediumPlatform medPlatform = new MediumPlatform(med_gamepane, stick , 100 , plyr); // Initialize EasyPlatform with the stick

        Scene scene = new Scene(med_gamepane);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        medPlatform.initializeAnimationTimer();	
        medPlatform.setCollision(true);
        //easyPlatform.initializePlatforms();
    }
	
	public void switchTohard_gameplay(ActionEvent event) throws IOException 
	{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hard_gameplay.fxml"));
        
        Pane hard_gamepane = (Pane) loader.load();
        
        Main main_obj = new Main();
        
        Stick stick = main_obj.new Stick() ; // Create the stick        
        
        //String imageUrl = getClass().getResource("player3.png").toExternalForm();
        //Image playerImage = new Image(imageUrl);
        Image playerImage = new Image(getClass().getResourceAsStream("player5.png"));        
        Plyr plyr = main_obj.new Plyr(playerImage);
        
        HardPlatform hardPlatform = new HardPlatform(hard_gamepane, stick , 100 , plyr); // Initialize EasyPlatform with the stick

        Scene scene = new Scene(hard_gamepane);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        hardPlatform.initializeAnimationTimer();	
        hardPlatform.setCollision(true);
        //easyPlatform.initializePlatforms();
    }

	
	
	public void switchToEndgame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		stage_end= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage_end.setScene(scene);
		stage_end.show();
	}
	

}