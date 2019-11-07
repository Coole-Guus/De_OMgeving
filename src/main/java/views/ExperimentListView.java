package views;

import controllers.ExperimentListController;
import controllers.FilterController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Experiment;
import models.ExperimentList;
import models.Observable;

import java.io.IOException;

public class ExperimentListView implements Observer {
    private  Stage primaryStage;
    private  ExperimentListController controller;

    @FXML
    public FlowPane experimentPane;

    public ExperimentListView() {
    }

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
        updateList((ExperimentList) observable);
    }

    private void updateList(ExperimentList experimentList) {
        for (GridPane card : experimentList.experimentCards) {
            card.setOnMouseClicked( event -> {
                LoadDetails(card.getId());
            });
            try {
                experimentPane.getChildren().add(card);
            } catch (Exception e){
            }
        }
    }

    private void LoadDetails(String id) {
        controller.applicationController.detailsController.showDetails(id);
    }


    @Override
    public void start() {
        controller.registerObserver(this);

        controller.updateHeleList();

        experimentPane.setPrefWrapLength(ViewUtilities.screenWidth - 260);
        experimentPane.setHgap(20);
        experimentPane.setVgap(20);
    }

    @Override
    public Node getParent() {
        Parent node = ViewUtilities.loadFxml("/ExperimentListView.fxml", primaryStage, controller, this);
        return node;
    }
}