package application;

import static org.junit.Assert.*;
import org.junit.Test;

import application.Main.Stick;
import javafx.scene.paint.Color;

public class test {
    
    @Test
    public void testStickInitialHeight() {
    	Main main_obj = new Main();
        Stick stick = main_obj.new Stick();
        assertEquals("Initial height should be 10", 10.0, stick.getHeight(), 0.01);
    }

    @Test
    public void testStickColor() {
    	Main main_obj = new Main();
    	Stick stick = main_obj.new Stick();
        assertEquals("Stick color should be black", Color.BLACK, stick.getFill());
    }

    // Add more tests here...
}