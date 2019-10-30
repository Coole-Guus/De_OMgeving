package views;

import controllers.ExperimentListController;
import controllers.FilterController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import models.Experiment;
import models.ExperimentList;
import models.Observable;

import java.io.IOException;

public class ExperimentListView implements Observer {
    private  Stage primaryStage;
    private  ExperimentListController controller;

    public ExperimentListView() {}

    public ExperimentListView(Stage primaryStage, Object experimentListController) {
        this.primaryStage = primaryStage;
        this.controller = (ExperimentListController) experimentListController;
    }

    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void setController(Object controller) {

    }

    @Override
    public void update(Observable observable) {

    }

    @Override
    public void start() {

    }

    @Override
    public Node getParent() {
        Parent node = ViewUtilities.loadFxml("/ExperimentListView.fxml", primaryStage, controller);

        return node;
    }
}