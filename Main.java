package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import application.Main.Stick;


public class Main extends Application {
		
	private Stage stage;
	
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
	
	private void showSecondStage() {
        // Create the second stage
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Second Stage");
        Button secondaryButton = new Button("Switch to Primary Stage");
        secondaryButton.setOnAction(event -> showPrimaryStage());
        Scene secondaryScene = new Scene(secondaryButton, 300, 200);
        secondaryStage.setScene(secondaryScene);
        
        // Set the owner stage (optional but useful for modality)
        secondaryStage.initOwner(stage);

        // Show the second stage
        secondaryStage.show();
    }
	
	private void showPrimaryStage() {
        // Bring the primary stage to the front if it's behind the secondary stage
        stage.toFront();
    }
	

	public static void main(String[] args) {
		launch(args);
	}
	
class Animations {
    private Stick stick;
    private Player player;
    private Cherry cherry;

    public Animations() {
        stick = new Stick();
        player = new Player();
        cherry = new Cherry(0, 0);

        // Set up mouse event handlers
        stick.setOnMousePressed(this::handleMousePressed);
        stick.setOnMouseReleased(this::handleMouseReleased);
    }

    private void handleMousePressed(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            startStickGrowth(); // Start stretching the stick
        }
    }

    private void handleMouseReleased(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            stopStickGrowth(); // Stop stretching the stick
        }
    }

    private void startStickGrowth() {
        stick.startStretch(); // Correctly start the stick growth animation
    }

    private void stopStickGrowth() {
        stick.stopStretch(); // Stop the stick growth animation
        // Rotate the stick by 90 degrees when growth stops
        stick.setRotate(stick.getRotate() + 90);
    }

    public Stick getStick() {
        return stick;
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

//animated stick :
class Stick extends Rectangle {
    private static final double MAX_HEIGHT = 300.0; // Maximum height of the stick
    private static final double GROWTH_STEP = 1.0; // Growth step per iteration
    private Timeline growthAnimation;

    public Stick() {
        super(50, 340, 5, 10); // x, y, width, height
        this.setFill(Color.BLACK); // Set the fill color of the stick

        // Initialize the growth animation
        growthAnimation = new Timeline(new KeyFrame(Duration.millis(20), e -> grow()));
        growthAnimation.setCycleCount(Animation.INDEFINITE);

        // Set up mouse event handlers
        this.setOnMousePressed(this::handleMousePressed);
        this.setOnMouseReleased(this::handleMouseReleased);
    }

    private void grow() {
        if (this.getHeight() + GROWTH_STEP <= MAX_HEIGHT) {
            this.setHeight(this.getHeight() + GROWTH_STEP);
        } else {
            stopStretch(); // Stop the stretching if max height is reached
        }
    }

    private void handleMousePressed(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            startStretch(); // Start stretching the stick
        }
    }

    private void handleMouseReleased(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            stopStretch(); // Stop stretching the stick
        }
    }

    public void startStretch() {
        growthAnimation.play();
    }

    public void stopStretch() {
        growthAnimation.stop();
    }

    public double getCurrentHeight() {
        return this.getHeight();
    }
}


// this is a demo stick class : (use it for later declaring methods.)
//	class Stick {
//	    private double length;
//	    private double position;
//
//	    public void stretch() {
//	        // Stretch the stick based on user input or animation
//	        // Iterate the length
//	    }
//
//	    public void fall() {
//	        // Make the stick fall towards the target platform
//	    }
//
//	    public double getLength() {
//	        return length;
//	    }
//
//	    public double getPosition() {
//	        return position;
//	    }
//
//	    // Reset method for restoring stick's length
//	    public void reset() {
//	        length = 0;
//	    }
//	}

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

//	class StartGameScreen {
//	    public void levelSelection() {
//	        // Code for level selection screen
//	    }
//
//	    public void startGame() {
//	        // Code for the start game screen
//	    }
//	}
//
//	class DuringGameScreen {
//	    public void duringGame() {
//	        //Code for the game play  phase
//	    }
//	}
//
//	class EndGameScreen{
//	    public void endGame() {
//	        // Code for the end game screen
//	    }
//	}
	
}
//		we need a root node in the constructor of scene
//		Basic type of root node: group
		
		

