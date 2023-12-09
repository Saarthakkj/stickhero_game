package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

abstract class Platform {
    protected static int width;

    public Platform(int width) {
        this.width = width;
        // Set other properties of the platformShape as needed
    }

    static int getWidth() {
        return width; // Get the width of the platform
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class EasyPlatform extends Platform {

    private static Pane easy_gamepane; // This is linked to the Pane in your FXML file
    private static int distanceBetweenPlatforms;
    private static double lastPlatformPosition;
    private final int initialPlatformCount = 3;

    public EasyPlatform(Pane easy_gamepane, Main.Stick stick, int distanceBetweenPlatforms) {
        super(50); // Wider platform for easier gameplay
        EasyPlatform.easy_gamepane = easy_gamepane; // Initialize the static variable

        easy_gamepane.getChildren().add(stick); // Add the stick to the gameplayPane
        EasyPlatform.distanceBetweenPlatforms = distanceBetweenPlatforms;

        // Initialize platforms
        for (int i = 0; i < initialPlatformCount; i++) {
            generatePlatform();
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

    private void generatePlatform() {
        Rectangle platform = new Rectangle(getWidth(), 20);
        platform.setLayoutX(lastPlatformPosition);
        platform.setLayoutY(easy_gamepane.getHeight() - 20);
        platform.setFill(Color.WHITE);
        easy_gamepane.getChildren().add(platform);
    }

    public void generatePlatforms() {
    }
}

// You can uncomment the MediumPlatform and HardPlatform classes if needed
//class MediumPlatform extends Platform {
//    private Pane med_pane; // Matches fx:id in FXML
//    private StickController stickController = new StickController(med_pane);
//
//    public MediumPlatform() {
//        setWidth(100); // Wider platform for easier gameplay
//    }
//
//    @Override
//    int getWidth() {
//        return super.getWidth();
//    }
//
//    public void adjustPlatformWidths() {
//        for (Node node : med_pane.getChildren()) {
//            if (node instanceof Rectangle) {
//                Rectangle platform = (Rectangle) node;
//                int width = super.getWidth(); // calculate or retrieve width
//                platform.setWidth(width);
//            }
//        }
//    }
//}
//
//class HardPlatform extends Platform {
//    private Pane hard_pane; // Matches fx:id in FXML
//    private StickController stickController = new StickController(hard_pane);
//
//    public HardPlatform() {
//        setWidth(50); //Wider platform for easier gameplay
//    }
//
//    @Override
//    int getWidth() {
//        return super.getWidth();
//    }
//
//    public void adjustPlatformWidths() {
//        for (Node node : hard_pane.getChildren()) {
//            if (node instanceof Rectangle) {
//                Rectangle platform = (Rectangle) node;
//                int width = super.getWidth(); // calculate or retrieve width
//                platform.setWidth(width);
//            }
//        }
//    }
//}
