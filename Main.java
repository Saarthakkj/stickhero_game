package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	@Override
	public void start(Stage stage){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("first_scrn.fxml"));
			Scene first_scrn = new Scene(root);
			
			//first_scrn.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			String css = this.getClass().getResource("application.css").toExternalForm();
			first_scrn.getStylesheets().add(css);
			
			stage.setScene(first_scrn);
			Image icon = new Image(getClass().getResourceAsStream("game_icon2.jpg"));

			stage.getIcons().add(icon);
			stage.setTitle("Stick Hero Game");
			
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	class Animation {
	    private Stick stick;
	    private Player player;
	    private Cherry cherry;

	    public Animation() {
	        stick = new Stick();
	        player = new Player();
	        cherry = new Cherry(0, 0);
	    }

	    private void stick_stretch() {
	        // Code to stretch the stick using the stick object
	        stick.stretch();
	    }

	    private void player_moving() {
	        // Code to move the player using the player object
	        player.moveCharacter();
	    }

	    private void button_hovering() {
	        // Code for button hovering animation
	    }
	    private void cherry_hovering() {
	        // Code for cherry hovering using the cherry object
	        cherry.hover();
	    }
	}

	class Stick {
	    private double length;
	    private double position;

	    public void stretch() {
	        // Stretch the stick based on user input or animation
	        // Iterate the length
	    }

	    public void fall() {
	        // Make the stick fall towards the target platform
	    }

	    public double getLength() {
	        return length;
	    }

	    public double getPosition() {
	        return position;
	    }

	    // Reset method for restoring stick's length
	    public void reset() {
	        length = 0;
	    }
	}

	class Cherry {
	    private Point2D location;

	    public Cherry(double x, double y) {
	        location = new Point2D(x, y);
	    }

	    public Point2D getLocation() {
	        return location;
	    }

	    public void hover() {
	    }
	}

	class CherryManager {
	    private ArrayList<Cherry> cherries;
	    private int cherryCount;

	    public void addCherry(double x, double y) {
	        cherries.add(new Cherry(x, y));
	    }

	    public void collectCherry() {
	        cherryCount++;
	    }

	    public void useCherries(int amount) {
	        cherryCount -= amount;
	    }

	    public ArrayList<Cherry> getCherries() {
	        return cherries;
	    }

	    public int getCherryCount() {
	        return cherryCount;
	    }
	}

	class Player {
	    private CherryManager cherryManager;
	    private int revivalCost = 5;

	    public Player() {
	        this.cherryManager = cherryManager;
	    }

	    void moveCharacter() {
	        // Handles the movement of the stick-hero character between platforms
	    }

	    void stretchStick() {
	        // Stretches out the stick to bridge the gaps between platforms
	    }

	    void collectCherries() {
	        cherryManager.collectCherry();
	        // Collects cherries and increases cherry_count
	    }

	    void revive() {
	        if (cherryManager.getCherryCount() >= revivalCost) {
	            // Revive the player
	            cherryManager.useCherries(revivalCost);
	            // Additional logic for reviving the player goes here
	        } else {
	            // Display a message or take other actions if the player doesn't have enough cherries to revive
	        }
	    }

	    void flipCharacter() {
	        // Flips the character upside down to collect rewards
	    }
	}

	class Platform {
	    private int width;

	    void getWidth() {
	        // Get the width of the platform
	    }
	}

	class StartGameScreen {
	    public void levelSelection() {
	        // Code for level selection screen
	    }

	    public void startGame() {
	        // Code for the start game screen
	    }
	}

	class DuringGameScreen {
	    public void duringGame() {
	        //Code for the gameplay phase
	    }
	}

	class EndGameScreen {
	    public void endGame() {
	        // Code for the end game screen
	    }
	}
}
//		we need a root node in the constructor of scene
//		Basic type of root node: group
		
		

