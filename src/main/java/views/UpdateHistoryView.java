package views;

import controllers.DetailsController;
import controllers.UpdateHistoryController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import models.Observable;
import models.UpdateHistory;

public class UpdateHistoryView implements Observer {

    private Stage primaryStage;

    public UpdateHistoryController controller;

    public UpdateHistoryView() { }

    public UpdateHistoryView(Stage primaryStage, Object updateHistoryController) {
        this.primaryStage = primaryStage;

        this.controller = (UpdateHistoryController) updateHistoryController;
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
        Parent node = ViewUtilities.loadFxml("/UpdateHistoryView.fxml", primaryStage, controller, this);
        return node;
    }
}