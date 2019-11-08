package views;

import controllers.ExperimentListController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.ExperimentList;
import models.Observable;

public class ExperimentListView implements Observer {

    /**
     * @author Leander
     *
     *
     */
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
        experimentPane.getChildren().clear();
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

        controller.updateList("");

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