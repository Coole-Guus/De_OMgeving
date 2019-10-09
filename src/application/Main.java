package application;

import controllers.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main  extends Application {

    @Override
    public void start(Stage primaryStage) {
        ApplicationController mainController = new ApplicationController(primaryStage);
        try {
            mainController.launch();
        } catch (IOException e) {
            System.out.println("ERROR, Probably a gui file that is not found");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
