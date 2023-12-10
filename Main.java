package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	public static void main(String[] args) {
		launch(args);
	}
	
class Animations {
    private Stick stick;
    //private Player player;
    private Cherry cherry;

    public Animations() {
        stick = new Stick();
        //player = new Player();
        cherry = new Cherry(0, 0);

//        // Set up mouse event handlers
//        stick.setOnMousePressed(this::handleMousePressed);
//        stick.setOnMouseReleased(this::handleMouseReleased);
    }

//    private void handleMousePressed(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY) {
//            startStickGrowth(); // Start stretching the stick
//        }
//    }

//    private void handleMouseReleased(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY) {
//            stopStickGrowth(); // Stop stretching the stick
//        }
//    }
//
//    private void startStickGrowth() {
//        stick.startStretch(); // Correctly start the stick growth animation
//    }

    private void stopStickGrowth() {
        //stick.stopStretch(); // Stop the stick growth animation
        // Rotate the stick by 90 degrees when growth stops
        stick.setRotate(stick.getRotate() + 90);
    }

    public Stick getStick() {
        return stick;
    }

//    private void player_moving() {
//        // Code to move the player using the player object
//        player.moveCharacter();
//    }

    private void button_hovering() {
        // Code for button hovering animation
    }

    private void cherry_hovering() {
        // Code for cherry hovering using the cherry object
	        cherry.hover();
	    }
}


//animation of player:
class Plyr extends ImageView {
	
	

    private boolean isCollided;

    public Plyr(Image image) {
        super(image);
    }

    public void handleCollision() {
        if (isCollided) {
            // Assuming new coordinates for translation
            double newX = getLayoutX() + 50;
            double newY = getLayoutY() + 50;

            // Create a TranslateTransition for the player ImageView
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), this);

            // Set the new coordinates as the destination for translation
            translateTransition.setToX(newX);
            translateTransition.setToY(newY);

            // Set up an event handler for when the animation finishes
            translateTransition.setOnFinished(event -> {
                // Code to execute after the animation finishes
            });

            // Play the translation animation
            translateTransition.play();

            // Reset the collision flag
            isCollided = false;
        }
    }
    
    public void changeSize(double width, double height) {
        this.setFitWidth(width);
        this.setFitHeight(height);
    }

}

//animated stick :
class Stick extends Rectangle {
  private static final double MAX_HEIGHT = 300.0;
  private static final double GROWTH_STEP = 1.0;
  private static final double ROTATION_DURATION = 500; // Milliseconds for rotation duration
  private Timeline growthAnimation;
  private Timeline rotationAnimation;
  private boolean isGrowing = false; // Flag to manage the stick's growth state
  public boolean isCOllided = false;
  
  public Stick() {
      super(50, 340, 5, 10);
      this.setFill(Color.BLACK);

      growthAnimation = new Timeline(new KeyFrame(Duration.millis(20), e -> grow()));
      growthAnimation.setCycleCount(Timeline.INDEFINITE);

      rotationAnimation = new Timeline(new KeyFrame(Duration.millis(ROTATION_DURATION), e -> rotate()));
      rotationAnimation.setCycleCount(1); // Only rotate once

      this.setOnMousePressed(event -> handleMousePressed());
  }

  private void grow() {
      if (this.getHeight() + GROWTH_STEP <= MAX_HEIGHT) {
          this.setHeight(this.getHeight() + GROWTH_STEP);
          this.setY(this.getY() - GROWTH_STEP);
      } else {
          stopStretch();
      }
  }

  private void handleMousePressed() {
      if (!isGrowing) {
          startStretch();
      } else {
          stopStretch();
          fall();
      }
  }

  private void startStretch() {
      isGrowing = true;
      growthAnimation.play();
  }

  private void stopStretch() {
      isGrowing = false;
      growthAnimation.stop();
  }

  private void fall() {
      rotationAnimation.setOnFinished(event -> rotate());
      rotationAnimation.play();
      rotationAnimation.setOnFinished(event -> {
    	  isCOllided = true; // Set flag to true after rotation completes
      });
  }

  private void rotate() {
      this.setRotate(90);
      this.setTranslateX(this.getHeight()/2-2.5);
      this.setTranslateY(this.getHeight()/2);
  }

  public double getCurrentHeight() {
      return this.getHeight();
  }
  
  // Method to check if the stick has collided (completed its rotation)
  public boolean hasCollided() {
      return isCOllided;
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

}


