package views;

import controllers.ToolsController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import models.Observable;

public class ToolsView implements Observer {

    private Stage primaryStage;
    private ToolsController controller;

    public ToolsView() {
    }

    public ToolsView(Stage primaryStage, Object toolsController) {
        this.primaryStage = primaryStage;

        this.controller = (ToolsController) toolsController;
    }

    public void rolCheck() {
        controller.rolCheck();
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
        Parent node = ViewUtilities.loadFxml("/ToolsView.fxml", primaryStage, controller);

        return node;
    }
}