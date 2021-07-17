package org.nic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
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

        try {

            stage.setTitle("FileChooser");
            DirectoryChooser directoryChooser = new DirectoryChooser();
            Label label = new Label("Image Corruptor");
            Button button = new Button("Choose Directory Of Images");

            EventHandler<ActionEvent> event =
                    e -> {

                        File selectedDirectory = directoryChooser.showDialog(stage);

                        if (selectedDirectory != null) {

                            System.out.println(selectedDirectory.getAbsolutePath());
                            File folder = new File(selectedDirectory.getAbsolutePath());
                            String[] filesStrings = folder.list();

                            CorruptorLogic edge = new CorruptorLogic();
                            for (int i = 0; i < filesStrings.length; i++) {
                                if (filesStrings[i].endsWith("png") || filesStrings[i].endsWith("jpeg") || filesStrings[i].endsWith("jpg")) {
                                    Image image = null;
                                    try {
                                        image = new Image(new FileInputStream("/Users/nicolaspoffley/Desktop/pics/" + filesStrings[i]));
                                    } catch (FileNotFoundException f) {
                                        f.printStackTrace();
                                    }
                                    Color[][] img = (edge.filterImage(image));
                                    System.out.println(filesStrings[i]);
                                    edge.saveImage(img, "/Users/nicolaspoffley/Desktop/OUT/" + filesStrings[i]);
                                    System.out.println("Saved image " + i + "/" + (filesStrings.length - 1));
                                }
                            }


                        }
                    };

            button.setOnAction(event);

            VBox vbox = new VBox(60, label, button);
            vbox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vbox, 800, 500);
            stage.setScene(scene);

            stage.show();
        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }


/*

*/

    }

    public static void main(String[] args) {
        launch();
    }

}