package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainView;

import java.io.IOException;

public class ApplicationController {
    private Stage primaryStage;
    private MainView mainView;

    public ApplicationController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("De OMgeving");
        mainView = new MainView(primaryStage);
        primaryStage.show();
    }
}
