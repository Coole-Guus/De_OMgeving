package application;

import controllers.ApplicationController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import views.ViewUtilities;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //wordt gevuld met loadView
        Parent root = new Pane();
        Scene scene = new Scene(root, ViewUtilities.screenWidth, (ViewUtilities.screenHeight - 70));
        primaryStage.setScene(scene);

        new ApplicationController(primaryStage);

        primaryStage.setFullScreen(false);
        primaryStage.setTitle("de_OMgeving");

        primaryStage.show();
    }
}
