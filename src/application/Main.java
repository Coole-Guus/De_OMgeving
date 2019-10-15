package application;

import controllers.ApplicationController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        new ApplicationController(primaryStage);

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("de_OMgeving");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
