package application;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Character_Movement {

    public class CharacterMovement extends Application {

        private static final double W = 600, H = 400;

        private static final String HERO_IMAGE_LOC =
                "";

        private Image heroImage;
        private Node hero;

        boolean running, goNorth, goSouth, goEast, goWest, jumping;

        @Override
        public void start(Stage stage) throws Exception {
            heroImage = new Image(HERO_IMAGE_LOC);
            hero = new ImageView(heroImage);

            Group dungeon = new Group(hero);

            moveHeroTo(W / 2, H / 2);

            Scene scene = new Scene(dungeon, W, H, Color.FORESTGREEN);

            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case UP:
                            goNorth = true;
                            break;
                        case DOWN:
                            goSouth = true;
                            break;
                        case LEFT:
                            goWest = true;
                            break;
                        case RIGHT:
                            goEast = true;
                            break;
                        case SHIFT:
                            running = true;
                            break;
                        case SPACE:
                            if (!jumping) {
                                jumping = true;
                                jump();
                            }
                            break;
                    }
                }
            });

            scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case UP:
                            goNorth = false;
                            break;
                        case DOWN:
                            goSouth = false;
                            break;
                        case LEFT:
                            goWest = false;
                            break;
                        case RIGHT:
                            goEast = false;
                            break;
                        case SHIFT:
                            running = false;
                            break;
                    }
                }
            });

            stage.setScene(scene);
            stage.show();

            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    int dx = 0, dy = 0;

                    if (goNorth) dy -= 1;
                    if (goSouth) dy += 1;
                    if (goEast) dx += 1;
                    if (goWest) dx -= 1;
                    if (running) {
                        dx *= 3;
                        dy *= 3;
                    }

                    if (jumping) {
                        dy -= 5; // Adjust this value for the jump height
                        jumping = false; // Only jump once per key press
                    }

                    moveHeroBy(dx, dy);
                }
            };
            timer.start();
        }

        private void jump() {
            // Implement jumping logic here
            // You can modify the moveHeroBy method to include jumping behavior
        }

        // ... (rest of the code remains unchanged)
    }

}
