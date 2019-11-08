package views;

import controllers.DetailsController;
import controllers.UpdateHistoryController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Observable;
import models.UpdateHistory;

public class UpdateHistoryView implements Observer {

    private Stage primaryStage;

    public UpdateHistoryController controller;

    private Parent node;

    public VBox messages;

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
        UpdateHistory updateHistory = (UpdateHistory) observable;
        messages.getChildren().removeAll(messages.getChildren());
        for(VBox vbox : updateHistory.updateCards) {
            messages.getChildren().add(vbox);
        }

    }

    @Override
    public void start() {
        this.controller.registerObserver(this);
    }

    @Override
    public Node getParent() {
        node = ViewUtilities.loadFxml("/UpdateHistoryView.fxml", primaryStage, controller, this);
        VBox messages = (VBox) node.lookup("#messages");
        return node;
    }
}