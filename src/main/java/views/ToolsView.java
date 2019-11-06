package views;

import controllers.AccountLoginController;
import controllers.ToolsController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Observable;
import models.Tools;

import java.io.IOException;

public class ToolsView implements Observer {

    private Stage primaryStage;
    private ToolsController controller;
    @FXML
    private ChoiceBox countChoiceBox;
    public ToolsView() { }

    public ToolsView(Stage primaryStage, Object toolsController) {
        this.primaryStage = primaryStage;

        this.controller = (ToolsController) toolsController;

    }

    public void rolCheck() {
        controller.rolCheck();
    }


    public void show() {

        Parent root = ViewUtilities.loadFxml("/Pop-up_voorbeeld.fxml", primaryStage, controller);

        Pane pane = (Pane) root.lookup("AnchorPane");

        Scene scene = new Scene(root, 500, 250);
        Stage stagePopUp = new Stage(StageStyle.DECORATED);
        stagePopUp.setTitle("Nieuw project aanmaken");
        stagePopUp.initOwner(primaryStage);
        stagePopUp.initModality(Modality.APPLICATION_MODAL);

        stagePopUp.setScene(scene);
        stagePopUp.show();
    }
    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void setController(Object controller) {
        ToolsController toolsController = (ToolsController) controller;
        this.controller = toolsController;
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