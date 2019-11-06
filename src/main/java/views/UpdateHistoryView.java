package views;

import controllers.UpdateHistoryController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import models.Observable;

public class UpdateHistoryView implements Observer {

    private UpdateHistoryController controller;
    private Stage primaryStage;
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
        Parent node = ViewUtilities.loadFxml("/UpdateHistoryView.fxml", primaryStage, controller);
        return node;
    }
}