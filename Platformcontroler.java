package application;

import java.io.IOException;

import application.Main.Stick;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

abstract class Platform {
	@FXML
    protected static int width;
		
	
	
	public Platform(int width) {
        this.width = width;
        // Set other properties of the platformShape as needed
    }

    static int getWidth() {
        return width;// Get the width of the platform
    }

	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
class EasyPlatform extends Platform {
	
	protected int width = 10;
	protected Rectangle easy_platform_rec;
	private static int distanceBetweenPlatforms;
	private static double lastPlatformPosition;
	private final int initialPlatformCount = 3;
	
	@FXML
    private static Pane easy_gamepane ; // This is linked to the Pane in your FXML file
	

    public EasyPlatform(Pane easy_gamepane , Stick stick , int distanceBetweenPlatforms ) {
        super(50); // Wider platform for easier game play
        easy_gamepane.getChildren().add(stick); // Add the stick to the gameplayPane        
        for (int i = 0; i < initialPlatformCount; i++) {
        	Rectangle platform = new Rectangle(getWidth(), 150);
            platform.setLayoutX(lastPlatformPosition);
            platform.setLayoutY(350); // Assuming platforms are at the bottom
            platform.setFill(Color.WHITE);
            easy_gamepane.getChildren().add(platform);
            lastPlatformPosition += distanceBetweenPlatforms;
        }
    }
    public void playerMoved(double playerPositionX) {
    	// Check if it's time to generate a new platform
        if (playerPositionX - lastPlatformPosition >= distanceBetweenPlatforms) {
            generatePlatform();
            lastPlatformPosition += distanceBetweenPlatforms;
        }
        
    }

//    public void initializePlatforms() {
//        // Perform additional initializations here, if needed
//        // For example, generating initial platforms
//        for (int i = 0; i < initialPlatformCount; i++) {
//            generatePlatform();
//            lastPlatformPosition += distanceBetweenPlatforms;
//        }
//    }
    private void generatePlatform() {
    	Rectangle platform = new Rectangle(getWidth(), 150);
        platform.setLayoutX(lastPlatformPosition);
        platform.setLayoutY(350); // Assuming platforms are at the bottom
        platform.setFill(Color.WHITE);
        easy_gamepane.getChildren().add(platform);
        lastPlatformPosition += distanceBetweenPlatforms;
    }
    
    
//    public static void main(String[] args) {
//    	lastPlatformPosition = -distanceBetweenPlatforms;
//    	if (playerPositionX - lastPlatformPosition >= distanceBetweenPlatforms) {
//    		easy_platform_rec = new Rectangle(getWidth(), 20);
//            // Create a new platform
//            Rectangle platform = new Rectangle(getWidth(), 20);
//            easy_gamepane.getChildren().add(platform);
//
//            // Set the position of the new platform
//            lastPlatformPosition += distanceBetweenPlatforms; // Update last position
//            platform.setLayoutX(lastPlatformPosition);
//            platform.setLayoutY(easy_gamepane.getHeight() - 20);
//        }
//    	
//    }
  
    
}



//class MediumPlatform extends Platform {
//	private Pane med_pane; // Matches fx:id in FXML
//	private StickController stickController = new StickController(med_pane);
//
//    public MediumPlatform() {
//        setWidth(100); // Wider platform for easier gameplay
//    }
//
//    @Override
//    int getWidth() {
//    	return super.getWidth();
//    }
//    public void adjustPlatformWidths() {
//        for (Node node : med_pane.getChildren()) {
//            if (node instanceof Rectangle) {
//                Rectangle platform = (Rectangle) node;
//                int width = super.getWidth();// calculate or retrieve width
//                platform.setWidth(width);
//            }
//        }
//	}
//}
//
//class HardPlatform extends Platform {
//	private Pane hard_pane; // Matches fx:id in FXML
//	private StickController stickController = new StickController(hard_pane);
//
//    public HardPlatform() {
//        setWidth(50); //Wider platform for easier gameplay
//    }
//
//    @Override
//    int getWidth() {
//    	return super.getWidth();
//    }
//    public void adjustPlatformWidths() {
//        for (Node node : hard_pane.getChildren()) {
//            if (node instanceof Rectangle) {
//                Rectangle platform = (Rectangle) node;
//                int width = super.getWidth();// calculate or retrieve width
//                platform.setWidth(width);
//            }
//        }
//	}
//}
