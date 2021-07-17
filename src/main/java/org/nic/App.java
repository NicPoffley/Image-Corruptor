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


        //File folder = new File("/Users/nicolaspoffley/Desktop/pics");
        //String[] filesStrings = folder.list();

        try {

            // set title for the stage
            stage.setTitle("FileChooser");

            // create a File chooser
            DirectoryChooser directoryChooser = new DirectoryChooser();

            // create a Label
            Label label = new Label("no files selected");

            // create a Button
            Button button = new Button("Show open dialog");

            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<>() {

                        public void handle(ActionEvent e) {

                            // get the file selected
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
                        }
                    };

            button.setOnAction(event);


            // create a VBox
            VBox vbox = new VBox(30, label, button);

            // set Alignment
            vbox.setAlignment(Pos.CENTER);

            // create a scene
            Scene scene = new Scene(vbox, 800, 500);

            // set the scene
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