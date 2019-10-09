package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.SampleView;

import java.io.IOException;

public class ApplicationController {
    private Stage primaryStage;

    public ApplicationController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void launch() throws IOException {
        primaryStage.setTitle("De OMgeving");
        SampleView view = new SampleView(primaryStage);
        view.setStage(primaryStage);
        primaryStage.show();
    }
}
