/*
 * Omran (Omi) Majumder
 * Dr. Alrajab
 * BCS345 JAVA Programming
 * 12 March 2021
 * Assignment 3
 * This program outputs a house using JavaFX
 */

package javafx.house;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Omran (Omi) Majumder
 */
public class JavaFXHouse extends Application{
        
    public static void main(String[] args) {
        
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        
        // declare and instantiate Rectangle for background sky box
        Rectangle skyBox = new Rectangle(0, 0, 595, 300);
        skyBox.setFill(Color.rgb(200, 230, 255)); // set fill color to blue
        
        // declare and instantiate Rectangle for background grass box
        Rectangle grassBox = new Rectangle(0, 300, 595, 300);
        grassBox.setFill(Color.rgb(100, 200, 0)); // set fill color to green
        
        // declare and instantiate Rectangle for house box
        Rectangle houseBox = new Rectangle(70, 165, 455, 320);
        houseBox.setFill(Color.rgb(170, 50, 0)); // set fill color to red
        houseBox.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Polygon for raking (outside of roof)
        Polygon raking = new Polygon(300, 15, 560, 140, 40, 140);
        raking.setFill(Color.WHITE); // set fill color to white
        raking.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Polygon for raking shadow (outside of roof)
        Polygon rakingShadow = new Polygon(300, 25, 520, 130, 80, 130);
        rakingShadow.setFill(Color.rgb(201, 201, 201)); // set fill color to white
        
        // declare and instantiate Polygon for gable (below raking shadow)
        Polygon gable = new Polygon(300, 35, 480, 120, 120, 120);
        gable.setFill(Color.WHITE); // set fill color to white
        
        // declare and instantiate Rectangle for lintel (below roof)
        Rectangle lintel = new Rectangle(70, 140, 460, 25);
        lintel.setFill(Color.WHITE); // set fill color to white
        lintel.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Rectangle for center door
        Rectangle centerDoor = new Rectangle(265, 265, 65, 150);
        centerDoor.setFill(Color.WHITE); // set fill color to white
        centerDoor.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Rectangle for right door
        Rectangle rightDoor = new Rectangle(395, 290, 65, 125);
        rightDoor.setFill(Color.WHITE); // set fill color to white
        rightDoor.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Rectangle for left door
        Rectangle leftDoor = new Rectangle(135, 290, 65, 125);
        leftDoor.setFill(Color.WHITE); // set fill color to white
        leftDoor.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Rectangle for plaque (above door)
        Rectangle plaque = new Rectangle(265, 190, 65, 40);
        plaque.setFill(Color.rgb(201, 201, 201)); // set fill color to gray
        plaque.setStroke(Color.BLACK); // set border to black
        
        // declare and instantiate Group for previously instantiated objects
        Group root = new Group(skyBox, grassBox, houseBox, raking, rakingShadow,
            gable, lintel, centerDoor, rightDoor, leftDoor, plaque);
        
        // declare and instantiate array of Rectangles for steps
        Rectangle[] steps = new Rectangle[11];
        // declare and initialize constant for total steps
        final int NUM_STEPS = 11; 
        for (int i = 0; i < NUM_STEPS; i++) {
            
            // instantiates array element with dimensions and position
            steps[i] = new Rectangle(130 - i * 10, 415 + i * 10, 335 + i * 20, 
                    10);
            steps[i].setFill(Color.rgb(201, 201, 201)); // set fill color to gray
            steps[i].setStroke(Color.BLACK); // set border to black
            root.getChildren().add(steps[i]); // add step to Group
            
        }
        
        // declare and intantiate array of Rectangles for door panes
        Rectangle[] doorPanes = new Rectangle[26];
        // declare and initialize constants for total door panes
        final int NUM_DOOR_PANES = 26, NUM_DOORS = 3, NUM_DOOR_PANE_ROWS = 4,
                NUM_DOOR_PANE_COLUMNS = 2;
        for (int i = 0; i < NUM_DOOR_PANES - 2; i++) {
            for (int j = 0; j < NUM_DOORS; j++) {
                for (int k = 0; k < NUM_DOOR_PANE_ROWS; k++) {
                    for (int m = 0; m < NUM_DOOR_PANE_COLUMNS; m++) {
                        
                        // nested for-loops to instantiate door panes with 
                        // dimensions and position
                        doorPanes[i] = new Rectangle(145 + m * 30 + j * 130, 
                                300 + k * 28.5, 15, 20);
                        root.getChildren().add(doorPanes[i]); // add door pane to Group
                        
                    }
                }
            }
        }
        for (int i = 24; i < NUM_DOOR_PANES; i++) {
            for (int j = 0; j < 2; j++) {
                
                // nested for-loops  to instantiate center door panes with
                // dimensions and position
                doorPanes[i] = new Rectangle(275 + j * 30, 275, 15, 18);
                root.getChildren().add(doorPanes[i]); // add door pane to Group
                
            }
        }
        
        // declare and instantiate array of Rectangles for plinths (below columns)
        Rectangle[] plinths = new Rectangle[4];
        // declare and initialize constants for total columns (also used for plinths)
        final int NUM_COLUMNS = 4;
        for (int i = 0; i < NUM_COLUMNS; i++) {
            
            // for-loop to instantiate plinths with dimensions and position
            plinths[i] = new Rectangle(75 + i * 130, 403, 55, 12);
            plinths[i].setFill(Color.WHITE); // set fill color to white
            plinths[i].setStroke(Color.BLACK); // set border to black
            root.getChildren().add(plinths[i]); // add plinth to Group
            
        }
        
        // declare and instantiate array of Rectangles for columns
        Rectangle[] columns = new Rectangle[4];
        for (int i = 0; i < NUM_COLUMNS; i++) {
            
            // for-loop to instantiate columns with dimensions and position
            columns[i] = new Rectangle(80 + i * 130, 165, 45, 238);
            columns[i].setFill(Color.WHITE); // set fill color to white
            columns[i].setStroke(Color.BLACK); // set border to black
            root.getChildren().add(columns[i]); // add column to Group
            
        }
        
        // declare and instantiate array of Rectangles for fillets (column carvings)
        Rectangle[] fillets = new Rectangle[4];
        // declare and initialize constant for total number of fillets
        final int NUM_FILLETS = 4;
        for (int i = 0; i < NUM_FILLETS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                
                // for-loop to instantiate columns with dimensions and position
                fillets[i] = new Rectangle(85 + i * 130 + j * 10, 166, 5, 236);
                fillets[i].setFill(Color.rgb(201, 201, 201)); // set fill color to gray
                root.getChildren().add(fillets[i]); // add fillet to Group
                
            }         
        }
        
        // declare and instantiate array of Circles for cornices (top of columns)
        Circle[] cornices = new Circle[8];
        // declare and initialize constants for total number of cornices
        final int NUM_CORNICES = 8, NUM_COLUMN_CORNICES = 2;
        for (int i = 0; i < NUM_CORNICES; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                for (int k = 0; k < NUM_COLUMN_CORNICES; k++) {
                    
                    // nested for-loops to instantiate cornices with dimensions
                    // and position
                    cornices[i] = new Circle(80 + k * 45 + j * 130, 175, 10);
                    cornices[i].setFill(Color.WHITE); // set fill color to white
                    cornices[i].setStroke(Color.BLACK); // set border to black
                    root.getChildren().add(cornices[i]); // add cornice to Group
                    
                }
            }
        }
        
        // declare and instantiate array of Rectangles for platforms (below plinth)
        Rectangle[] platforms = new Rectangle[2];
        // declare and initialize constant for total number of platforms
        final int NUM_PLATFORMS = 2;
        for (int i = 0; i < NUM_PLATFORMS; i++) {
            
            // for-loop to instantiate platforms with dimensions and position
            platforms[i] = new Rectangle(70 + i * 395, 415, 60, 5);
            platforms[i].setFill(Color.rgb(201, 201, 201)); // set fill color to gray
            platforms[i].setStroke(Color.BLACK); // set border to black
            root.getChildren().add(platforms[i]); // add platform to Group
            
        }
        
        // declare and instantiate Scene with dimensions and Group
        Scene scene = new Scene(root, 595, 600);
        stage.setTitle("A House"); // set title of Scene
        stage.setScene(scene); // set Scene
        stage.show(); // show Scene
    }
    
}
