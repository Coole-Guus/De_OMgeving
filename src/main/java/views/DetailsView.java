package views;

import controllers.DetailsController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import models.Observable;

public class DetailsView implements Observer {

    private DetailsController controller;
    private Stage primaryStage;

    public DetailsView() { }




    public DetailsView(Stage primaryStage, Object filterController) {
        this.primaryStage = primaryStage;

        this.controller = (DetailsController) filterController;

        start();
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
        Parent node = ViewUtilities.loadFxml("/DetailsView.fxml", primaryStage, controller);

        return node;
    }
}