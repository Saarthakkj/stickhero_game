package application;

import application.main.Plyr;
import application.main.Stick;
import javafx.animation.AnimationTimer;
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
	
	
	public Stick stick;
	protected int width = 50;
	protected Rectangle easy_platform_rec;
	protected static int distanceBetweenPlatforms = 100;
	private static double lastPlatformPosition;
	private final int platform_count = 3;
	private boolean isCollided ;
	
	private  Plyr plyr;
	
	
	@FXML
    private static Pane easy_gamepane ; // This is linked to the Pane in your FXML file

    public EasyPlatform(Pane easy_gamepane , Stick stick , Plyr plyr)
    {// , ImageView plyr ) {
        
    	super(50); // Wider platform for easier game play
        //	easy_gamepane.getChildren().add(plyr);
        this.stick = stick;
        isCollided = stick.isCollided;
    	easy_gamepane.getChildren().add(stick); // Add the stick to the gameplayPane  
    	this.plyr = plyr;
    	easy_gamepane.getChildren().add(plyr);
    	plyr.setLayoutX(0);
        plyr.setLayoutY(320);
//        plyr.setFitWidth(50);
//        plyr.setFitHeight(50);
        for (int i = 0; i < platform_count; i++) {
        	Rectangle platform = new Rectangle(width, 150); //150 is height
            platform.setLayoutX(lastPlatformPosition);
            platform.setLayoutY(350); // Assuming platforms are at the bottom
            platform.setFill(Color.WHITE);
            easy_gamepane.getChildren().add(platform);
            lastPlatformPosition += distanceBetweenPlatforms;
        }
    }


    public void start_animation() {
        // Animation timer initialization

        AnimationTimer animationTimer = new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long now) {
            if (now - lastUpdate >= 1_000_000_000) {
                // Update player's position here
                //plyr.move(25); // Assuming you have a move() method in the Plyr class
                lastUpdate = now;
                System.out.println(isCollided);
                // Check for collision between Stick and EasyPlatform
                if (stick.isCollided != isCollided) {
                    isCollided = stick.isCollided;
                    // Call the necessary methods or perform actions when collision occurs
                    if (isCollided){
                        double current_locn = plyr.getX();
                        // Collision occurred, handle accordingly
                        plyr.move(current_locn+distanceBetweenPlatforms);
                    }
                }
            }
            }
        };

        // Rest of the method implementation
        // Add any other necessary code here

        animationTimer.start();
    }
    // Initialize the AnimationTimer
    public void initializeAnimationTimer() {
        String flagString = Boolean.toString(isCollided);

        System.out.printf("boolean value of iscollided is : %s" , flagString);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Check if it's time to move the player and generate a new platform
                if (isCollided) {
                    plyr.move(150+distanceBetweenPlatforms);
                    isCollided = false; // Reset isCollided after handling the collision
                }
            }
        };

        // Start the AnimationTimer
        timer.start();
    }

    // Public method to set the isCollided flag
    public void setCollision(boolean isCollided) {
        this.isCollided = isCollided;
    }

    private void movePlayerAndGeneratePlatform() {
        // Move the player
        //stick.setLayoutX(stick.getLayoutX() + distanceBetweenPlatforms);

    	
        // Check if it's time to generate a new platform
        if (stick.getLayoutX() - lastPlatformPosition >= distanceBetweenPlatforms) {
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
    
    private void generatePlatform() 
    {
    	Rectangle platform = new Rectangle(getWidth(), 150);
        platform.setLayoutX(lastPlatformPosition);
        platform.setLayoutY(350); // Assuming platforms are at the bottom
        platform.setFill(Color.WHITE);
        easy_gamepane.getChildren().add(platform);
        lastPlatformPosition += distanceBetweenPlatforms;
    }
}

class MediumPlatform extends Platform {
	
	
	public Stick stick;
	protected int width = 10;
	protected Rectangle med_platform_rec;
	private static int distanceBetweenPlatforms;
	private static double lastPlatformPosition;
	private final int platform_count = 3;
	private boolean isCollided = false;
	
	private  Plyr plyr;
	
	
	@FXML
    private static Pane med_gamepane ; // This is linked to the Pane in your FXML file

    public MediumPlatform(Pane med_gamepane , Stick stick , int distanceBetweenPlatforms , Plyr plyr) 
    {// , ImageView plyr ) {
        
    	super(50); // Wider platform for easier game play
        //	easy_gamepane.getChildren().add(plyr);
        this.stick = stick;
    	med_gamepane.getChildren().add(stick); // Add the stick to the gameplayPane  
    	this.plyr = plyr;
    	med_gamepane.getChildren().add(plyr);
    	plyr.setLayoutX(0);
        plyr.setLayoutY(320);
//        plyr.setFitWidth(50);
//        plyr.setFitHeight(50);
        for (int i = 0; i < platform_count; i++) {
        	Rectangle platform = new Rectangle(getWidth(), 150);
            platform.setLayoutX(lastPlatformPosition);
            platform.setLayoutY(350); // Assuming platforms are at the bottom
            platform.setFill(Color.WHITE);
            med_gamepane.getChildren().add(platform);
            lastPlatformPosition += distanceBetweenPlatforms;
        }
    }




   //Initialize the AnimationTimer
    public void initializeAnimationTimer() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Check if it's time to move the player and generate a new platform
                if (isCollided) {
                    movePlayerAndGeneratePlatform();
                    isCollided = false; // Reset isCollided after handling the collision
                }
            }
        };

        // Start the AnimationTimer
        timer.start();
    }

    // Public method to set the isCollided flag
    public void setCollision(boolean isCollided) {
        this.isCollided = isCollided;
    }

    private void movePlayerAndGeneratePlatform() {
        // Move the player
        //stick.setLayoutX(stick.getLayoutX() + distanceBetweenPlatforms);

    	
        // Check if it's time to generate a new platform
        if (stick.getLayoutX() - lastPlatformPosition >= distanceBetweenPlatforms) {
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
    
    private void generatePlatform() 
    {
    	Rectangle platform = new Rectangle(getWidth(), 150);
        platform.setLayoutX(lastPlatformPosition);
        platform.setLayoutY(350); // Assuming platforms are at the bottom
        platform.setFill(Color.WHITE);
        med_gamepane.getChildren().add(platform);
        lastPlatformPosition += distanceBetweenPlatforms;
    }
}
class HardPlatform extends Platform {
	
	
	public Stick stick;
	protected int width = 10;
	protected Rectangle hard_platform_rec;
	private static int distanceBetweenPlatforms;
	private static double lastPlatformPosition;
	private final int platform_count = 3;
	private boolean isCollided = false;
	
	private  Plyr plyr;
	
	
	@FXML
    private static Pane hard_gamepane ; // This is linked to the Pane in your FXML file

    public HardPlatform(Pane hard_gamepane , Stick stick , int distanceBetweenPlatforms , Plyr plyr) 
    {// , ImageView plyr ) {
        
    	super(50); // Wider platform for easier game play
        //	easy_gamepane.getChildren().add(plyr);
        this.stick = stick;
    	hard_gamepane.getChildren().add(stick); // Add the stick to the gameplayPane  
    	this.plyr = plyr;
    	hard_gamepane.getChildren().add(plyr);
    	plyr.setLayoutX(0);
        plyr.setLayoutY(320);
//        plyr.setFitWidth(50);
//        plyr.setFitHeight(50);
        for (int i = 0; i < platform_count; i++) {
        	Rectangle platform = new Rectangle(getWidth(), 150);
            platform.setLayoutX(lastPlatformPosition);
            platform.setLayoutY(350); // Assuming platforms are at the bottom
            platform.setFill(Color.WHITE);
            hard_gamepane.getChildren().add(platform);
            lastPlatformPosition += distanceBetweenPlatforms;
        }
    }
    
 // Initialize the AnimationTimer
    public void initializeAnimationTimer() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Check if it's time to move the player and generate a new platform
                if (isCollided) {
                    movePlayerAndGeneratePlatform();
                    isCollided = false; // Reset isCollided after handling the collision
                }
            }
        };

        // Start the AnimationTimer
        timer.start();
    }

    // Public method to set the isCollided flag
    public void setCollision(boolean isCollided) {
        this.isCollided = isCollided;
    }

    private void movePlayerAndGeneratePlatform() {
        // Move the player
        //stick.setLayoutX(stick.getLayoutX() + distanceBetweenPlatforms);

    	
        // Check if it's time to generate a new platform
        if (stick.getLayoutX() - lastPlatformPosition >= distanceBetweenPlatforms) {
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
    
    private void generatePlatform() 
    {
    	Rectangle platform = new Rectangle(getWidth(), 150);
        platform.setLayoutX(lastPlatformPosition);
        platform.setLayoutY(350); // Assuming platforms are at the bottom
        platform.setFill(Color.WHITE);
        hard_gamepane.getChildren().add(platform);
        lastPlatformPosition += distanceBetweenPlatforms;
    }
}
