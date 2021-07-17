package org.nic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        File folder = new File("/Users/nicolaspoffley/Desktop/pics");
        String[] filesStrings = folder.list();


        Button button = new Button("Click to corrupt");
        Scene scene = new Scene(button, 200, 100);

        button.setOnAction(actionEvent ->  {
            CorruptorLogic edge = new CorruptorLogic();
            for (int i = 0 ; i < filesStrings.length ; i++) {
                if(filesStrings[i].endsWith("png")||filesStrings[i].endsWith("jpeg")||filesStrings[i].endsWith("jpg")) {
                    Image image = null;
                    try {
                        image = new Image(new FileInputStream("/Users/nicolaspoffley/Desktop/pics/"+filesStrings[i]));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Color[][] img = (edge.filterImage(image));
                    System.out.println(filesStrings[i]);
                    edge.saveImage(img,"/Users/nicolaspoffley/Desktop/OUT/"+filesStrings[i]);
                    System.out.println("Saved image "+i+"/"+(filesStrings.length-1));
                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}