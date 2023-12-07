package application;

import java.io.IOException;

import application.Main.Stick;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

abstract class Platform {
	@FXML
    protected int width;
		
	protected Rectangle platformShape;
	
	public Platform(int width) {
        this.width = width;
        this.platformShape = new Rectangle(width, 20); // Assuming a fixed height for platforms
        // Set other properties of the platformShape as needed
    }

    int getWidth() {
        return width;// Get the width of the platform
    }

	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
class EasyPlatform extends Platform {
	@FXML
    private Pane easy_gamepane = SceneController.geteasy_gamepane(); // This is linked to the Pane in your FXML file
	Main main_obj = new Main();
	private Stick stick = main_obj.new Stick();

    public EasyPlatform(Pane easy_gamepane) {
        super(150); // Wider platform for easier game play
        easy_gamepane.getChildren().add(stick); // Add the stick to the gameplayPane 
    }
   
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
