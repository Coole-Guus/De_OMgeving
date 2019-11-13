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
        System.setProperty("prism.allowhidpi", "false");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //wordt gevuld met loadView
        Parent root = new Pane();
        Scene scene = new Scene(root, ViewUtilities.screenWidth, (ViewUtilities.screenHeight));

        primaryStage.setScene(scene);
        primaryStage.setY(ViewUtilities.screenMinY);
        primaryStage.setX(ViewUtilities.screenMinX);

        primaryStage.setResizable(false);

        new ApplicationController(primaryStage);

        primaryStage.setTitle("de_OMgeving");

        primaryStage.show();
    }
}
