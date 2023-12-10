//package application;
//
//import application.Main.Stick;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//
//public class StickController {
//	private Main main_obj = new Main(); 
//    static Stick stick;
//
//    public StickController(Pane pane) {
//        this.stick = main_obj.new Stick(); // Directly create the Stick here
//        pane.getChildren().add(stick); // Add the stick to the pane
//
//        // Add mouse click event handlers
//        stick.setOnMousePressed(this::handleMousePressed);
//        stick.setOnMouseReleased(this::handleMouseReleased);
//    }
//
//    private void handleMousePressed(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY) {
//            startStickGrowth(); // Start stretching the stick
//        }
//    }
//
//    private void handleMouseReleased(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY) {
//            stopStickGrowth(); // Stop stretching the stick
//        }
//    }
//
//    private void startStickGrowth() {
//        stick.startStretch(); // Correctly start the stick growth animation
//    }
//
//    private void stopStickGrowth() {
//        stick.stopStretch(); // Stop the stick growth animation
//    }
//
//    public Stick getStick() {
//        return stick;
//    }
//}
