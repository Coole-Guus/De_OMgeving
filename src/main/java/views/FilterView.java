package views;

import controllers.FilterController;
import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import models.Observable;


public class FilterView implements Observer {
    private Stage primaryStage;
    private FilterController controller;

    public FilterView() {}

    public FilterView(Stage primaryStage, Object filterController) {
        this.primaryStage = primaryStage;

        this.controller = (FilterController) filterController;
    }

    @Override
    public void setStage(Stage stage) {
        this.primaryStage = stage;
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
        Parent node = ViewUtilities.loadFxml("/FilterView.fxml", primaryStage, controller);

        return node;
    }

    public void checkbox1(ActionEvent actionEvent) {
        CheckBox checkboc1 = (CheckBox) actionEvent.getTarget();
        System.out.println("CLINK " + checkboc1.isSelected());
    }
}